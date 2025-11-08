package net.devmultiverse.tycoonlib.procedures;

import net.devmultiverse.tycoonlib.TycoonlibMod;

public class ConvertStringToNumberProcedure {
	public static double execute(String text) {
		if (text == null)
			return 0;
		if ((text).equals(Integer.parseInt(text))) {
			TycoonlibMod.LOGGER.info("This text is not a number! (Returning Zero)");
			return 0;
		}
		return Integer.parseInt(text);
	}
}
