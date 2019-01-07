package util;

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

}
