
package net.mcreator.perky.world.biome;

import net.minecraft.block.material.Material;
import java.util.ArrayList;
import java.util.HashMap;

@PerkyModElements.ModElement.Tag
public class SmakuvbiomeBiome extends PerkyModElements.ModElement {

	public static Biome biome;

	public SmakuvbiomeBiome(PerkyModElements instance) {
		super(instance, 9);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {

		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-65536).setWaterColor(-10027264).setWaterFogColor(-16711834)
						.withSkyColor(-65536).withFoliageColor(-52378).withGrassColor(-16711936)
						.setAmbientSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("ambient.crimson_forest.loop")))
						.setMoodSound(new MoodSoundAmbience(
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")),
								6000, 8, 2))
						.setAdditionsSound(new SoundAdditionsAmbience((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("block.beacon.deactivate")), 0.0111D))
						.setMusic(new BackgroundMusicSelector(
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beehive.enter")),
								12000, 24000, true))
						.setParticle(new ParticleEffectAmbience(ParticleTypes.BUBBLE, 0.005f)).build();

				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(MinceBlock.block.getDefaultState(),
								Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA.getDefaultState(), Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA.getDefaultState())));

				biomeGenerationSettings.withStructure(StructureFeatures.STRONGHOLD);

				biomeGenerationSettings.withStructure(StructureFeatures.VILLAGE_TAIGA);

				biomeGenerationSettings.withStructure(StructureFeatures.OCEAN_RUIN_WARM);

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.TREE
						.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.SPRUCE_LOG.getDefaultState()),
								new SimpleBlockStateProvider(Blocks.SPRUCE_LEAVES.getDefaultState()),
								new MegaPineFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0),
										FeatureSpread.func_242253_a(13, 4)),
								new GiantTrunkPlacer(13, 2, 14), new TwoLayerFeature(1, 1, 2))).build())
						.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
						.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(Features.Configs.GRASS_PATCH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT)
								.withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8D, 5, 1))));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.FLOWER.withConfiguration(Features.Configs.NORMAL_FLOWER_CONFIG)
								.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
								.func_242731_b(1));

				DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
				DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
				DefaultBiomeFeatures.withFrozenTopLayer(biomeGenerationSettings);

				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(SmakEntity.entity, 1, 1, 1));

				biome = new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.EXTREME_HILLS).depth(0.1f).scale(0.2f)
						.temperature(0.5f).downfall(0.5f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();

				event.getRegistry().register(biome.setRegistryName("perky:smakuvbiome"));
			}
		}

	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM,
				new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(biome)), 3));
	}

}
