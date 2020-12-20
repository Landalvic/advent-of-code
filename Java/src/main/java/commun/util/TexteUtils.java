package commun.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;

import commun.annotation.PatternAttribute;
import commun.annotation.PatternClass;
import commun.structure.AdventOfCodeException;

public interface TexteUtils {

	public static String trouverEntreParenthese(String input) {
		int nbr = 0;
		for (int i = 1; i < input.length(); i++) {
			String cFin = String.valueOf(input.charAt(i));
			if (StringUtils.equals("(", cFin)) {
				nbr++;
			} else if (StringUtils.equals(")", cFin)) {
				if (nbr == 0) {
					return input.substring(1, i);
				} else {
					nbr--;
				}
			}
		}
		return input;
	}

	public static Integer trouverPatternInt(String string, Pattern pattern) {
		String result = trouverPattern(string, pattern);
		if (result != null) {
			return Integer.valueOf(result);
		} else {
			return null;
		}
	}

	public static int[] trouverPatternInt(String string, Pattern pattern, int nbr) {
		Matcher m = pattern.matcher(string);
		if (m.matches()) {
			int[] array = new int[nbr];
			for (int i = 0; i < nbr; i++) {
				array[i] = Integer.parseInt(m.group(i + 1));
			}
			return array;
		} else {
			return new int[0];
		}
	}

	public static long[] trouverPatternLong(String string, Pattern pattern, int nbr) {
		Matcher m = pattern.matcher(string);
		if (m.matches()) {
			long[] array = new long[nbr];
			for (int i = 0; i < nbr; i++) {
				array[i] = Long.parseLong(m.group(i + 1));
			}
			return array;
		} else {
			return new long[0];
		}
	}

	public static String[] trouverPattern(String string, Pattern pattern, int nbr) {
		Matcher m = pattern.matcher(string);
		if (m.matches()) {
			String[] array = new String[nbr];
			for (int i = 0; i < nbr; i++) {
				array[i] = m.group(i + 1);
			}
			return array;
		} else {
			return new String[0];
		}
	}

	public static String trouverPattern(String string, Pattern pattern) {
		Matcher m = pattern.matcher(string);
		if (m.matches()) {
			return m.group(1);
		} else {
			return null;
		}
	}

	public static boolean findPattern(String string, Pattern pattern) {
		Matcher m = pattern.matcher(string);
		return m.matches();
	}

	public static <T> T transformerPattern(String texte, List<Class<? extends T>> clazzArrayS) {
		for (Class<? extends T> clazz : clazzArrayS) {
			T retour = transformerPattern(texte, clazz);
			if (retour != null) {
				return retour;
			}
		}
		return null;
	}

	public static <T> T transformerPattern(String texte, Class<? extends T> clazz) {
		try {
			PatternClass patternAnnotation = clazz.getAnnotation(PatternClass.class);
			Pattern pattern = Pattern.compile(patternAnnotation.value());
			Matcher m = pattern.matcher(texte);
			if (m.matches()) {
				T t = clazz.getDeclaredConstructor().newInstance();
				putInFields(clazz, m, t);
				return t;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static <T> void putInFields(Class<? extends T> clazz, Matcher m, T t) throws AdventOfCodeException {
		for (Field field : clazz.getDeclaredFields()) {
			PatternAttribute patternAttribute = field.getAnnotation(PatternAttribute.class);
			if (patternAttribute != null) {
				String value = m.group(patternAttribute.value());
				Object objectValue;
				if (field.getType().equals(String.class)) {
					objectValue = value;
				} else if (field.getType().equals(Integer.class)) {
					objectValue = Integer.parseInt(value);
				} else if (field.getType().equals(Double.class)) {
					objectValue = Double.parseDouble(value);
				} else {
					throw new AdventOfCodeException("Le type " + field.getType().getSimpleName() + " n'a pas encore de pattern implémenté.");
				}
				PropertyAccessor myAccessor = PropertyAccessorFactory.forDirectFieldAccess(t);
				myAccessor.setPropertyValue(field.getName(), objectValue);
			}
		}
		if (clazz.getSuperclass() != null) {
			putInFields(clazz.getSuperclass(), m, t);
		}
	}

}
