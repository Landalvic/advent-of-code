package util;

import java.util.ArrayList;
import java.util.List;

public abstract class MathUtils {

	public static String toHexString(byte[] bytes) {
		StringBuilder retour = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(0xFF & bytes[i]);
			if (hex.length() == 1) {
				retour.append("0");
			}
			retour.append(hex);
		}
		return retour.toString();
	}

	public static List<Integer> listeDiviseurs(int nombre) {
		List<Integer> liste = new ArrayList<>();
		for (int i = 1; i <= nombre / 2; i++) {
			if (nombre % i == 0) {
				liste.add(i);
			}
		}
		liste.add(nombre);
		return liste;
	}

}
