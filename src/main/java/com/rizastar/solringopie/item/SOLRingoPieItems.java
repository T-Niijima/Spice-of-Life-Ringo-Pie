package com.rizastar.solringopie.item;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import com.rizastar.solringopie.SOLRingoPie;
import com.rizastar.solringopie.item.foodcontainer.FoodContainerItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.common.Mod;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

@Mod.EventBusSubscriber(modid = SOLRingoPie.MOD_ID, bus = MOD)
public final class SOLRingoPieItems
{

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SOLRingoPie.MOD_ID);

	public static final RegistryObject<Item> BOOK = ITEMS.register("food_book", () -> new FoodBookItem());
	public static final RegistryObject<Item> LUNCHBOX = ITEMS.register("lunchbox", () -> new FoodContainerItem(9, "lunchbox"));
	public static final RegistryObject<Item> LUNCHBAG = ITEMS.register("lunchbag", () -> new FoodContainerItem(5, "lunchbag"));
	public static final RegistryObject<Item> GOLDEN_LUNCHBOX = ITEMS.register("golden_lunchbox", () -> new FoodContainerItem(14, "golden_lunchbox"));

	@SubscribeEvent
	public static void registerItems(RegisterEvent event) {
		event.register(ForgeRegistries.Keys.ITEMS,
				helper -> {
					helper.register(ResourceLocation.fromNamespaceAndPath(SOLRingoPie.MOD_ID, "food_book"),
							new FoodBookItem());
					helper.register(ResourceLocation.fromNamespaceAndPath(SOLRingoPie.MOD_ID, "lunchbox"),
							new FoodContainerItem(9,"lunchbox"));
					helper.register(ResourceLocation.fromNamespaceAndPath(SOLRingoPie.MOD_ID, "lunchbag"),
							new FoodContainerItem(5,"lunchbag"));
					helper.register(ResourceLocation.fromNamespaceAndPath(SOLRingoPie.MOD_ID, "golden_lunchbox"),
							new FoodContainerItem(14,"golden_lunchbox"));
				});
	}


	public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			event.accept(BOOK);
			event.accept(LUNCHBOX);
			event.accept(LUNCHBAG);
			event.accept(GOLDEN_LUNCHBOX);
		}
	}
}
