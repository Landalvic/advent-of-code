package commun.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;

import commun.annotation.PatternAttribute;
import commun.annotation.PatternClass;
import commun.structure.AdventOfCodeException;

public interface FileUtils {

	public static boolean exist(String input) {
		return Files.exists(Paths.get(input));
	}

	public static Stream<String> streamOfLines(String input) throws AdventOfCodeException {
		try {
			return Files.lines(Paths.get(input));
		} catch (IOException e) {
			throw new AdventOfCodeException(e.getMessage(), e);
		}
	}

	public static String firstLine(String input) throws AdventOfCodeException {
		return streamOfLines(input).findFirst().orElseThrow();
	}

	public static IntStream streamOfInt(String input) throws AdventOfCodeException {
		return streamOfLines(input).mapToInt(Integer::parseInt);
	}

	public static LongStream streamOfLong(String input) throws AdventOfCodeException {
		return streamOfLines(input).mapToLong(Long::parseLong);
	}

	public static DoubleStream streamOfDouble(String input) throws AdventOfCodeException {
		return streamOfLines(input).mapToDouble(Double::parseDouble);
	}

	public static List<String> listOfLines(String input) throws AdventOfCodeException {
		return streamOfLines(input).collect(Collectors.toList());
	}

	public static List<Integer> listOfIntegers(String input) throws AdventOfCodeException {
		return streamOfInt(input).boxed().collect(Collectors.toList());
	}

	public static List<Long> listOfLongs(String input) throws AdventOfCodeException {
		return streamOfLong(input).boxed().collect(Collectors.toList());
	}

	public static List<Double> listOfDoubles(String input) throws AdventOfCodeException {
		return streamOfDouble(input).boxed().collect(Collectors.toList());
	}

	public static StringBuilder lireLigne(String lien) {
		StringBuilder builder = new StringBuilder();
		InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(lien);
		char[] buf = new char[1];
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			while (reader.ready()) {
				reader.read(buf);
				builder.append(buf);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder;
	}

	public static List<String> lireFichier(String lien) {
		List<String> liste = new ArrayList<>();
		InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(lien);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			while (reader.ready()) {
				liste.add(reader.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return liste;
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
					throw new AdventOfCodeException(
							"Le type " + field.getType().getSimpleName() + " n'a pas encore de pattern implémenté.");
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
