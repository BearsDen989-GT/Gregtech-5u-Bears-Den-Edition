package gregtech.common.render;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import static gregtech.api.enums.GT_Values.RES_PATH_ENTITY;

public class GT_Renderer_Entity_Arrow
        extends RenderArrow {
    private final ResourceLocation mTexture;

    public GT_Renderer_Entity_Arrow(Class aArrowClass, String aTextureName) {
        this.mTexture = new ResourceLocation(RES_PATH_ENTITY + aTextureName + ".png");
        RenderingRegistry.registerEntityRenderingHandler(aArrowClass, this);
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return this.mTexture;
    }
}
