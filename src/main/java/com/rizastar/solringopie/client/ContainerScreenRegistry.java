package com.rizastar.solringopie.client;

import com.rizastar.solringopie.SOLRingoPie;
import com.rizastar.solringopie.item.foodcontainer.FoodContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ContainerScreenRegistry {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, SOLRingoPie.MOD_ID);

    public static final RegistryObject<MenuType<FoodContainer>> FOOD_CONTAINER =
            MENU_TYPES.register("food_container",
                    () -> IForgeMenuType.create(((windowId, inv, data) -> new FoodContainer(windowId, inv, inv.player))));
}
