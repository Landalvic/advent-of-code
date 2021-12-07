package commun.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MathUtils {

	public static double mediane(double... a) {
		if (a.length % 2 == 1) {
			return a[(a.length + 1) / 2 - 1];
		} else {
			return (a[a.length / 2 - 1] + a[a.length / 2]) / 2;
		}
	}

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

	public static long binaryToLong(String s, int base) {
		return new BigInteger(s, base).longValue();
	}

	public static long plusGrandDiviseurCommun(long a, long b) {
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger gcd = b1.gcd(b2);
		return gcd.intValue();
	}

	// TODO à tester
	public static long denominateurCommun(long... nombres) {
		Map<Long, Integer> diviseurs = mapDiviseursDenominateurCommun(nombres);
		return denominateurCommun(diviseurs);
	}

	public static long denominateurCommun(Map<Long, Integer> diviseurs) {
		return diviseurs.entrySet().stream().map(entry -> Math.pow(entry.getKey(), entry.getValue())).reduce(1., (a, b) -> a * b).longValue();
	}

	public static Map<Long, Integer> mapDiviseursDenominateurCommun(List<Map<Long, Integer>> listeDiviseurs) {
		Map<Long, Integer> map = new HashMap<>();
		for (var diviseurs : listeDiviseurs) {
			for (var entry : diviseurs.entrySet()) {
				if (map.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
					map.put(entry.getKey(), entry.getValue());
				}
			}
		}
		return map;
	}

	public static Map<Long, Integer> mapDiviseursDenominateurCommun(long... nombres) {
		Map<Long, Integer> map = new HashMap<>();
		for (long nombre : nombres) {
			var freq = mapDiviseurs(nombre);
			for (var entry : freq.entrySet()) {
				if (map.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
					map.put(entry.getKey(), entry.getValue());
				}
			}
		}
		return map;
	}

	public static Map<Long, Integer> mapDiviseurs(long nombreADiviser) {
		Map<Long, Integer> map = new HashMap<>();
		var diviseurs = listeDiviseurs(nombreADiviser);
		for (Long diviseur : diviseurs) {
			Integer nombre = map.get(diviseur);
			map.put(diviseur, (nombre == null) ? 1 : nombre + 1);
		}
		return map;
	}

	public static Set<Long> listeDiviseursUnique(long nombre) {
		return new HashSet<>(listeDiviseurs(nombre));
	}

	public static Set<Long> listeDiviseursUnique(long nombre, long min) {
		return new HashSet<>(listeDiviseurs(nombre, min));
	}

	public static List<Long> listeDiviseurs(long nombre) {
		return listeDiviseurs(nombre, 2);
	}

	public static List<Long> listeDiviseurs(long nombre, long min) {
		List<Long> liste = new ArrayList<>();
		if (nombre >= min) {
			for (var i = min; i <= nombre; i++) {
				while (nombre % i == 0) {
					liste.add(i);
					nombre /= i;
				}
			}
		}
		return liste;
	}

}
