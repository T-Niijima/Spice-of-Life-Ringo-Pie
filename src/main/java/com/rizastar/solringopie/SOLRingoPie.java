package com.rizastar.solringopie;

import com.rizastar.solringopie.client.ContainerScreenRegistry;
import com.rizastar.solringopie.communication.ConfigMessage;
import com.rizastar.solringopie.communication.FoodListMessage;
import com.rizastar.solringopie.item.SOLRingoPieItems;
import com.rizastar.solringopie.item.foodcontainer.FoodContainerScreen;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

@Mod(SOLRingoPie.MOD_ID)
@Mod.EventBusSubscriber(modid = SOLRingoPie.MOD_ID, bus = MOD)
public final class SOLRingoPie
{
	public static final String MOD_ID = "solringopie";
	
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

//	public static boolean HasFarmersDelight() { return ModList.get().isLoaded("farmersdelight"); }
//	public static boolean HasPamsHarvestcraft() { return ModList.get().isLoaded("pamhc2foodcore"); }

	private static final String PROTOCOL_VERSION = "1.0";
	public static SimpleChannel channel = NetworkRegistry.ChannelBuilder
		.named(resourceLocation("main"))
		.clientAcceptedVersions(PROTOCOL_VERSION::equals)
		.serverAcceptedVersions(PROTOCOL_VERSION::equals)
		.networkProtocolVersion(() -> PROTOCOL_VERSION)
		.simpleChannel();

	public static IEventBus modEventBus;

	public SOLRingoPie(FMLJavaModLoadingContext context) {
		modEventBus = context.getModEventBus();
		SOLRingoPieConfig.setUp(context);
		ContainerScreenRegistry.MENU_TYPES.register(modEventBus);
	}
	
	public static ResourceLocation resourceLocation(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

	@SubscribeEvent
	public static void setUp(FMLCommonSetupEvent event) {
		channel.messageBuilder(FoodListMessage.class, 0)
			.encoder(FoodListMessage::write)
			.decoder(FoodListMessage::new)
			.consumerMainThread(FoodListMessage::handle)
			.add();

		channel.messageBuilder(ConfigMessage.class, 1)
				.encoder(ConfigMessage::write)
				.decoder(ConfigMessage::new)
				.consumerMainThread(ConfigMessage::handle)
				.add();

		modEventBus.addListener(SOLRingoPieItems::registerTabs);

	}

	@SubscribeEvent
	public static void setupClient(FMLClientSetupEvent event) {
		event.enqueueWork(() -> { MenuScreens.register(ContainerScreenRegistry.FOOD_CONTAINER.get(), FoodContainerScreen::new); });
	}

//	public SOLRingoPie() {
//	}
}
