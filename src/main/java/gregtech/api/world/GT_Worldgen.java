package gregtech.api.world;

import gregtech.api.GregTech_API;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import gregtech.api.enums.ConfigCategories;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public abstract class GT_Worldgen {

    public final String mWorldGenName;
    public final boolean mEnabled;
    private final Map<String, Boolean> mDimensionMap = new HashMap<String, Boolean>();

    public GT_Worldgen(String aName, List aList, boolean aDefault) {
        mWorldGenName = aName;
        mEnabled = GregTech_API.sWorldgenFile.get("worldgen", mWorldGenName, aDefault, "Generation enable switch");
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen", "World Generation Config");
        if (mEnabled) aList.add(this);
    }

    /**
     * @param aWorld         The World Object
     * @param aRandom        The Random Generator to use
     * @param aBiome         The Name of the Biome (always != null)
     * @param aDimensionType The Type of Worldgeneration to add. -1 = Nether, 0 = Overworld, +1 = End
     * @param aChunkX        xCoord of the Chunk
     * @param aChunkZ        zCoord of the Chunk
     * @return if the Worldgeneration has been successfully completed
     */
    public boolean executeWorldgen(World aWorld, Random aRandom, String aBiome, int aDimensionType, int aChunkX, int aChunkZ, IChunkProvider aChunkGenerator, IChunkProvider aChunkProvider) {
        return false;
    }

    /**
     * @param aWorld         The World Object
     * @param aRandom        The Random Generator to use
     * @param aBiome         The Name of the Biome (always != null)
     * @param aDimensionType The Type of Worldgeneration to add. -1 = Nether, 0 = Overworld, +1 = End
     * @param aChunkX        xCoord of the Chunk
     * @param aChunkZ        zCoord of the Chunk
     * @return if the Worldgeneration has been successfully completed
     */
    public boolean executeCavegen(World aWorld, Random aRandom, String aBiome, int aDimensionType, int aChunkX, int aChunkZ, IChunkProvider aChunkGenerator, IChunkProvider aChunkProvider) {
        return false;
    }

    public boolean isGenerationAllowed(World aWorld, int aDimensionType, int aAllowedDimensionType) {
        String aDimName = aWorld.provider.getDimensionName();
        Boolean tAllowed = mDimensionMap.get(aDimName);
        if (tAllowed == null) {
            GregTech_API.sWorldgenFile.setCathegoryComment(String.format("worldgen.dimensions.%s", mWorldGenName), String.format("WorldGeneration for %s dimension", mWorldGenName));
            boolean tValue = GregTech_API.sWorldgenFile.get("worldgen.dimensions." + mWorldGenName, aDimName, aDimensionType == aAllowedDimensionType, String.format("Generate in %s", aDimName));
            mDimensionMap.put(aDimName, tValue);

            return tValue;
        }
        return tAllowed;
    }
}
