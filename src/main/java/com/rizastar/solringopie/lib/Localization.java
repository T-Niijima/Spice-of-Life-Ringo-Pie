package com.rizastar.solringopie.lib;

import com.rizastar.solringopie.SOLRingoPie;
//import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public final class Localization {
	
	/** e.g. keyString("tooltip", "eaten_status.not_eaten_1") -> "tooltip.solringopie.eatenStatus.not_eaten_1") */
	public static String keyString(String domain, String path) {
		return domain + "." + SOLRingoPie.MOD_ID + "." + path;
	}
	
	@OnlyIn(Dist.CLIENT)
	public static String localized(String domain, String path, Object... args) {
		return (Component.translatable(keyString(domain, path))).getString();
	}

	public static MutableComponent localizedComponent(String domain, String path, Object... args) {
		return Component.translatable(keyString(domain, path));
	}

	public static MutableComponent localizedQuantityComponent(String domain, String path, int number) {
		String key = keyString(domain, path);
		// 整数 `number` をObject[]として渡す必要がある
		Object[] args = new Object[]{number};

		return number == 1
				? Component.translatable(key + ".singular") // 引数なしのオーバーロード
				: Component.translatable(key + ".plural", args); // 引数ありのオーバーロード（Object[]として渡す）
	}
	
	public static String formatBigNumber(int number) {
		if (number < 1000) {
			return "" + number;
		} else if (number < 10_000) {
			return Math.round(number / 1000F) + "." + Math.round((number % 1000) / 100F) + "k";
		} else {
			return Math.round(number / 1000F) + "k";
		}
	}
	
	private Localization() {}
}
