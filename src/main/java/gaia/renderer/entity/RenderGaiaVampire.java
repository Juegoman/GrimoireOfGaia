package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaVampire;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaVampire extends RenderLiving {

	private static final ResourceLocation vampireEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/eyes_Vampire.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Vampire.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaVampire( float shadowSize) {
        super(rend, new ModelGaiaVampire(), shadowSize);
        this.addLayer(new LayerGlowing(this, vampireEyesTexture));
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
