
package net.mcreator.perky.world.biome;

import net.minecraft.block.material.Material;
import java.util.ArrayList;
import java.util.HashMap;

@PerkyModElements.ModElement.Tag
public class ObrhoryBiome extends PerkyModElements.ModElement {

	public static Biome biome;

	public ObrhoryBiome(PerkyModElements instance) {
		super(instance, 6);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {

		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-6684673).setWaterColor(-13434625).setWaterFogColor(-256)
						.withSkyColor(-6684673).withFoliageColor(-13312).withGrassColor(-16724992)
						.setAmbientSound(
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("ambient.crimson_forest.loop")))
						.setMoodSound(new MoodSoundAmbience((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("ambient.nether_wastes.additions")), 6000, 8, 2))
						.setAdditionsSound(new SoundAdditionsAmbience((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("ambient.nether_wastes.loop")), 0.0111D))
						.setMusic(new BackgroundMusicSelector(
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), 12000,
								24000, true))
						.setParticle(new ParticleEffectAmbience(ParticleTypes.EXPLOSION, 0.005f)).build();

				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(
						SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(Blocks.SMOOTH_RED_SANDSTONE.getDefaultState(),
								Blocks.STRIPPED_OAK_WOOD.getDefaultState(), Blocks.STRIPPED_OAK_WOOD.getDefaultState())));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.TREE
								.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
										new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
										new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
										new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build())
								.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
								.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(Features.Configs.GRASS_PATCH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT)
								.withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8D, 5, 10))));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS
						.withConfiguration(new ProbabilityConfig(0.3F)).func_242731_b(1).withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.FLOWER.withConfiguration(Features.Configs.NORMAL_FLOWER_CONFIG)
								.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
								.func_242731_b(4));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(
								(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.BROWN_MUSHROOM.getDefaultState()),
										SimpleBlockPlacer.PLACER)).tries(1).func_227317_b_().build()));
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(
								(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.RED_MUSHROOM.getDefaultState()),
										SimpleBlockPlacer.PLACER)).tries(1).func_227317_b_().build()));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.HUGE_BROWN_MUSHROOM.withConfiguration(new BigMushroomFeatureConfig(
								new SimpleBlockStateProvider(Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState().with(HugeMushroomBlock.UP, Boolean.TRUE)
										.with(HugeMushroomBlock.DOWN, Boolean.FALSE)),
								new SimpleBlockStateProvider(Blocks.MUSHROOM_STEM.getDefaultState().with(HugeMushroomBlock.UP, Boolean.FALSE)
										.with(HugeMushroomBlock.DOWN, Boolean.FALSE)),
								1)));
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.HUGE_RED_MUSHROOM.withConfiguration(new BigMushroomFeatureConfig(
								new SimpleBlockStateProvider(Blocks.RED_MUSHROOM_BLOCK.getDefaultState().with(HugeMushroomBlock.DOWN, Boolean.FALSE)),
								new SimpleBlockStateProvider(Blocks.MUSHROOM_STEM.getDefaultState().with(HugeMushroomBlock.UP, Boolean.FALSE)
										.with(HugeMushroomBlock.DOWN, Boolean.FALSE)),
								1)));

				biomeGenerationSettings
						.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
								Feature.DISK
										.withConfiguration(
												new SphereReplaceConfig(Blocks.SAND.getDefaultState(), FeatureSpread.func_242253_a(2, 4), 2,
														ImmutableList.of(Blocks.SMOOTH_RED_SANDSTONE.getDefaultState(),
																Blocks.STRIPPED_OAK_WOOD.getDefaultState())))
										.withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT).func_242731_b(1));

				biomeGenerationSettings
						.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
								Feature.DISK
										.withConfiguration(
												new SphereReplaceConfig(Blocks.GRAVEL.getDefaultState(), FeatureSpread.func_242253_a(2, 3), 2,
														ImmutableList.of(Blocks.SMOOTH_RED_SANDSTONE.getDefaultState(),
																Blocks.STRIPPED_OAK_WOOD.getDefaultState())))
										.withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT).func_242731_b(1));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(Features.Configs.SUGAR_CANE_PATCH_CONFIG)
								.withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(1));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(
								(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.CACTUS.getDefaultState()),
										new ColumnBlockPlacer(1, 2))).tries(1).func_227317_b_().build()));

				DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
				DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
				DefaultBiomeFeatures.withFrozenTopLayer(biomeGenerationSettings);

				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

				biome = new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.NONE).depth(0.1f).scale(0.2f).temperature(0.5f)
						.downfall(0.5f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();

				event.getRegistry().register(biome.setRegistryName("perky:obrhory"));
			}
		}

	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM,
				new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(biome)), 5));
	}

}
