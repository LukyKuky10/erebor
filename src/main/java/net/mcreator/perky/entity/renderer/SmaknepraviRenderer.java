package net.mcreator.perky.entity.renderer;

@OnlyIn(Dist.CLIENT)
public class SmaknepraviRenderer {

	public static class ModelRegisterHandler {

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(SmaknepraviEntity.entity,
					renderManager -> new MobRenderer(renderManager, new ChickenModel(), 0.5f) {
						{
							this.addLayer(new GlowingLayer<>(this));
						}
						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("perky:textures/smak_texture.png");
						}
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
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("perky:textures/smak_texture.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}

	}

}
