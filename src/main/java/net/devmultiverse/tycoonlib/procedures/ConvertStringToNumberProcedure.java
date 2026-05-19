package net.devmultiverse.tycoonlib.procedures;

import org.checkerframework.checker.units.qual.s;

public class ConvertStringToNumberProcedure {
	public static double execute(String text) {
		if (text == null)
			return 0;
		return new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(text);
	}
}
