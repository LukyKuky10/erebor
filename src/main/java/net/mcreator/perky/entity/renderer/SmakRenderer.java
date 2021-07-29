package net.mcreator.perky.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.mcreator.perky.entity.SmakEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class SmakRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(SmakEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelcustom_model(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("perky:textures/smak.png");
					}
				};
			});
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("perky:textures/smak.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelcustom_model extends EntityModel<Entity> {
		private final ModelRenderer bb_main;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer cube_r15;
		public Modelcustom_model() {
			textureWidth = 16;
			textureHeight = 16;
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.setTextureOffset(0, 0).addBox(-6.0F, -6.0F, -3.0F, 11.0F, 8.0F, 11.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-11.0F, -27.0F, -9.0F, 39.0F, 21.0F, 56.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(12.0F, -6.0F, -3.0F, 10.0F, 8.0F, 11.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-6.0F, -6.0F, 28.0F, 10.0F, 8.0F, 10.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(12.0F, -6.0F, 28.0F, 10.0F, 8.0F, 10.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(8.0F, -30.0F, -15.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(3.0F, -37.0F, 51.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(3.0F, -39.0F, 39.0F, 1.0F, 2.0F, 13.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(13.0F, -38.0F, 39.0F, 1.0F, 3.0F, 13.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(21.0F, 20.0F, 84.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-31.0F, -30.0F, -23.0F, 5.0F, 3.0F, 11.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-92.0F, -25.0F, 31.0F, 209.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-21.0F, -25.0F, 0.0F, 10.0F, 1.0F, 32.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-29.0F, -25.0F, 3.0F, 8.0F, 1.0F, 29.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-45.0F, -25.0F, 5.0F, 16.0F, 1.0F, 27.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-75.0F, -25.0F, 12.0F, 30.0F, 1.0F, 19.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-92.0F, -25.0F, 23.0F, 18.0F, 1.0F, 9.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(27.0F, -25.0F, 0.0F, 11.0F, 1.0F, 31.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(38.0F, -25.0F, 3.0F, 8.0F, 1.0F, 29.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(44.0F, -25.0F, 7.0F, 18.0F, 1.0F, 25.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(62.0F, -25.0F, 11.0F, 35.0F, 0.0F, 20.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(95.0F, -25.0F, 19.0F, 21.0F, 1.0F, 13.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(8.0F, -39.0F, 40.0F, 1.0F, 2.0F, 15.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(3.0F, -33.0F, 62.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(12.0F, -33.0F, 61.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.3927F, -0.1745F, 0.0F);
			cube_r1.setTextureOffset(0, 0).addBox(-39.0F, -35.0F, -11.0F, 15.0F, 4.0F, 13.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.3491F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(0, 0).addBox(-39.0F, -38.0F, -21.0F, 23.0F, 3.0F, 22.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.7418F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(0, 0).addBox(-24.0F, -50.0F, -6.0F, 16.0F, 3.0F, 10.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.48F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(0, 0).addBox(-32.0F, -46.0F, -19.0F, 30.0F, 5.0F, 18.0F, 0.0F, false);
			cube_r4.setTextureOffset(0, 0).addBox(-40.0F, -43.0F, -21.0F, 49.0F, 4.0F, 22.0F, 0.0F, false);
			cube_r4.setTextureOffset(0, 0).addBox(-1.0F, -36.0F, -9.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.5236F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(0, 0).addBox(-3.0F, -40.0F, -16.0F, 16.0F, 4.0F, 18.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r6);
			setRotationAngle(cube_r6, -0.1309F, 0.0F, 0.0F);
			cube_r6.setTextureOffset(0, 0).addBox(2.0F, -38.0F, 53.0F, 11.0F, 8.0F, 17.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r7);
			setRotationAngle(cube_r7, -0.1745F, 0.0F, 0.0F);
			cube_r7.setTextureOffset(0, 0).addBox(1.0F, -45.0F, 38.0F, 14.0F, 14.0F, 17.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r8);
			setRotationAngle(cube_r8, -0.4363F, 0.0F, 0.0F);
			cube_r8.setTextureOffset(0, 0).addBox(4.0F, -41.0F, 30.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r9);
			setRotationAngle(cube_r9, -0.3491F, 0.0F, 0.0F);
			cube_r9.setTextureOffset(0, 0).addBox(4.0F, -37.0F, 31.0F, 9.0F, 1.0F, 9.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r10);
			setRotationAngle(cube_r10, -0.2618F, 0.0F, 0.0F);
			cube_r10.setTextureOffset(0, 0).addBox(3.0F, -33.0F, 29.0F, 11.0F, 1.0F, 14.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.6545F, 0.0F, 0.0F);
			cube_r11.setTextureOffset(0, 0).addBox(7.0F, -32.0F, 5.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.6981F, 0.0F, 0.0F);
			cube_r12.setTextureOffset(0, 0).addBox(6.0F, -30.0F, 6.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.6109F, 0.0F, 0.0F);
			cube_r13.setTextureOffset(0, 0).addBox(4.0F, -29.0F, 4.0F, 8.0F, 2.0F, 7.0F, 0.0F, false);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.3927F, 0.0F, 0.0F);
			cube_r14.setTextureOffset(0, 0).addBox(0.0F, -34.0F, -9.0F, 22.0F, 4.0F, 22.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.2618F, 0.0F, 0.0F);
			cube_r15.setTextureOffset(0, 0).addBox(-2.0F, -31.0F, -5.0F, 24.0F, 9.0F, 20.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
