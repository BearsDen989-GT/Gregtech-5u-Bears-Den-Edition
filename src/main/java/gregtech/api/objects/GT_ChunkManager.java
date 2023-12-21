package gregtech.api.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.ForgeChunkManager.Ticket;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import gregtech.GT_Mod;
import gregtech.api.enums.GT_Values;
import gregtech.api.interfaces.IChunkLoader;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.util.GT_Log;

/**
 * Handles re-initialization of chunks after a server restart.
 */
public class GT_ChunkManager
    implements ForgeChunkManager.OrderedLoadingCallback, ForgeChunkManager.PlayerOrderedLoadingCallback {

    private final Map<TileEntity, Ticket> registeredTickets = new HashMap<>();
    public static GT_ChunkManager instance = new GT_ChunkManager();

    public static void init() {
        ForgeChunkManager.setForcedChunkLoadingCallback(GT_Mod.instance, instance);
    }

    @Override
    public void ticketsLoaded(List<Ticket> tickets, World world) {}

    /**
     * Determines if tickets should be kept. Based on if the ticket is a machine or a working-chunk ticket.
     * Working-chunk tickets are tossed and recreated when the machine reactivates.
     * Machine tickets are kept only if the config {@code alwaysReloadChunkloaders} is true.
     * Otherwise, machine chunks are tossed and recreated only when the machine reactivates,
     * similarly to a Passive Anchor.
     *
     * @param tickets        The tickets that you will want to select from.
     *                       The list is immutable and cannot be manipulated directly. Copy it first.
     * @param world          The world
     * @param maxTicketCount The maximum number of tickets that will be allowed.
     * @return list of tickets
     */

    @Override
    public List<Ticket> ticketsLoaded(List<Ticket> tickets, World world, int maxTicketCount) {
        List<Ticket> validTickets = new ArrayList<>();
        if (GT_Values.alwaysReloadChunkloaders) {
            for (Ticket ticket : tickets) {
                int x = ticket.getModData()
                    .getInteger("OwnerX");
                int y = ticket.getModData()
                    .getInteger("OwnerY");
                int z = ticket.getModData()
                    .getInteger("OwnerZ");
                if (y > 0) {
                    TileEntity tile = world.getTileEntity(x, y, z);
                    if (tile instanceof IGregTechTileEntity && ((IGregTechTileEntity) tile).isAllowedToWork()) {
                        ForgeChunkManager.forceChunk(ticket, new ChunkCoordIntPair(x >> 4, z >> 4));
                        if (!registeredTickets.containsKey(tile)) {
                            registeredTickets.put(tile, ticket);
                            if (((IGregTechTileEntity) tile).getMetaTileEntity() instanceof IChunkLoader)
                                ForgeChunkManager.forceChunk(
                                    ticket,
                                    ((IChunkLoader) ((IGregTechTileEntity) tile).getMetaTileEntity()).getActiveChunk());
                            validTickets.add(ticket);
                        }
                    }
                }
            }
        }
        return validTickets;
    }

    /**
     * Determines if player tickets should be kept. This is where a ticket list per-player would be created and
     * maintained. When a player joins, an event occurs, their name/UUID/etc is compared against tickets on this list
     * and those tickets are reactivated.
     * Since that info would be maintained/dealt with on a per-player startup, the list returned back to Forge is empty.
     *
     * @param tickets The tickets that you will want to select from.
     *                The list is immutable and cannot be manipulated directly. Copy it first.
     * @param world   The world
     * @return the list of string-ticket paris
     */
    @Override
    public ListMultimap<String, Ticket> playerTicketsLoaded(ListMultimap<String, Ticket> tickets, World world) {
        // Not currently used, so just return an empty list.
        return ArrayListMultimap.create();
    }

    /**
     * Requests a chunk to be loaded for this machine. May pass a {@code null} chunk to load just the machine itself if
     * {@code alwaysReloadChunkloaders} is enabled in config.
     *
     * @param owner   owner of the TileEntity
     * @param chunkXZ chunk coordinates
     * @param player  player
     * @return if the chunk was loaded successfully
     */
    public static boolean requestPlayerChunkLoad(TileEntity owner, ChunkCoordIntPair chunkXZ, String player) {
        if (!GT_Values.enableChunkloaders) return false;
        if (!GT_Values.alwaysReloadChunkloaders && chunkXZ == null) return false;
        if (GT_Values.debugChunkloaders && chunkXZ != null) GT_Log.out
            .println("GT_ChunkManager: Chunk request: (" + chunkXZ.chunkXPos + ", " + chunkXZ.chunkZPos + ")");
        if (instance.registeredTickets.containsKey(owner)) {
            ForgeChunkManager.forceChunk(instance.registeredTickets.get(owner), chunkXZ);
        } else {
            Ticket ticket;
            if (player.equals("")) ticket = ForgeChunkManager
                .requestTicket(GT_Mod.instance, owner.getWorldObj(), ForgeChunkManager.Type.NORMAL);
            else ticket = ForgeChunkManager
                .requestPlayerTicket(GT_Mod.instance, player, owner.getWorldObj(), ForgeChunkManager.Type.NORMAL);
            if (ticket == null) {
                if (GT_Values.debugChunkloaders)
                    GT_Log.out.println("GT_ChunkManager: ForgeChunkManager.requestTicket failed");
                return false;
            }
            if (GT_Values.debugChunkloaders) GT_Log.out.println(
                "GT_ChunkManager: ticket issued for machine at: (" + owner.xCoord
                    + ", "
                    + owner.yCoord
                    + ", "
                    + owner.zCoord
                    + ")");
            NBTTagCompound tag = ticket.getModData();
            tag.setInteger("OwnerX", owner.xCoord);
            tag.setInteger("OwnerY", owner.yCoord);
            tag.setInteger("OwnerZ", owner.zCoord);
            ForgeChunkManager.forceChunk(ticket, chunkXZ);
            if (GT_Values.alwaysReloadChunkloaders)
                ForgeChunkManager.forceChunk(ticket, new ChunkCoordIntPair(owner.xCoord >> 4, owner.zCoord >> 4));
            instance.registeredTickets.put(owner, ticket);
        }
        return true;
    }

    @SuppressWarnings("UnusedReturnValue")
    public static boolean requestChunkLoad(TileEntity owner, ChunkCoordIntPair chunkXZ) {
        return requestPlayerChunkLoad(owner, chunkXZ, "");
    }

    public static void releaseChunk(TileEntity owner, ChunkCoordIntPair chunkXZ) {
        if (!GT_Values.enableChunkloaders) return;
        Ticket ticket = instance.registeredTickets.get(owner);
        if (ticket != null) {
            if (GT_Values.debugChunkloaders) GT_Log.out
                .println("GT_ChunkManager: Chunk release: (" + chunkXZ.chunkXPos + ", " + chunkXZ.chunkZPos + ")");
            ForgeChunkManager.unforceChunk(ticket, chunkXZ);
        }
    }

    public static void releaseTicket(TileEntity owner) {
        if (!GT_Values.enableChunkloaders) return;
        Ticket ticket = instance.registeredTickets.get(owner);
        if (ticket != null) {
            if (GT_Values.debugChunkloaders) {
                GT_Log.out.println(
                    "GT_ChunkManager: ticket released by machine at: (" + owner.xCoord
                        + ", "
                        + owner.yCoord
                        + ", "
                        + owner.zCoord
                        + ")");
                for (ChunkCoordIntPair chunk : ticket.getChunkList()) GT_Log.out
                    .println("GT_ChunkManager: Chunk release: (" + chunk.chunkXPos + ", " + chunk.chunkZPos + ")");
            }
            ForgeChunkManager.releaseTicket(ticket);
            instance.registeredTickets.remove(owner);
        }
    }

    public static void printTickets() {
        GT_Log.out.println("GT_ChunkManager: Start forced chunks dump:");
        instance.registeredTickets.forEach((machine, ticket) -> {
            GT_Log.out.print(
                "GT_ChunkManager: Chunks forced by the machine at (" + machine.xCoord
                    + ", "
                    + machine.yCoord
                    + ", "
                    + machine.zCoord
                    + ")");
            if (ticket.isPlayerTicket()) GT_Log.out.print(" Owner: " + ticket.getPlayerName());
            GT_Log.out.print(" :");
            for (ChunkCoordIntPair c : ticket.getChunkList()) {
                GT_Log.out.print("(");
                GT_Log.out.print(c.chunkXPos);
                GT_Log.out.print(", ");
                GT_Log.out.print(c.chunkZPos);
                GT_Log.out.print("), ");
            }
        });
        GT_Log.out.println("GT_ChunkManager: End forced chunks dump:");
    }
}
