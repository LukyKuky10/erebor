
package net.mcreator.perky.item;

@PerkyModElements.ModElement.Tag
public class PaliceItem extends PerkyModElements.ModElement {

	@ObjectHolder("perky:palice")
	public static final Item block = null;

	public PaliceItem(PerkyModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 190;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2.5f;
			}

			public int getHarvestLevel() {
				return 6;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -1f, new Item.Properties().group(ItemGroup.COMBAT)) {

		}.setRegistryName("palice"));
	}

}
