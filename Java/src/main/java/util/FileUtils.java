package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import commun.AdventOfCodeException;

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

	public static List<String> listOfLines(String input) throws AdventOfCodeException {
		return streamOfLines(input).collect(Collectors.toList());
	}

	public static List<Integer> listOfIntegers(String input) throws AdventOfCodeException {
		return streamOfInt(input).boxed().collect(Collectors.toList());
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
				liste.add(new String(reader.readLine()));
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
				array[i] = Integer.valueOf(m.group(i + 1));
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

}
