package commun.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

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

	public static List<Integer> firstLineOfInteger(String input, String separator) throws AdventOfCodeException {
		var blocs = streamOfLines(input).findFirst().orElseThrow().split(separator);
		List<Integer> retour = new ArrayList<>(blocs.length);
		for (String b : blocs) {
			retour.add(Integer.parseInt(b));
		}
		return retour;
	}

	public static List<Long> firstLineOfLong(String input, String separator) throws AdventOfCodeException {
		var blocs = streamOfLines(input).findFirst().orElseThrow().split(separator);
		List<Long> retour = new ArrayList<>(blocs.length);
		for (String b : blocs) {
			retour.add(Long.parseLong(b));
		}
		return retour;
	}

	public static List<Double> firstLineOfDouble(String input, String separator) throws AdventOfCodeException {
		var blocs = streamOfLines(input).findFirst().orElseThrow().split(separator);
		List<Double> retour = new ArrayList<>(blocs.length);
		for (String b : blocs) {
			retour.add(Double.parseDouble(b));
		}
		return retour;
	}

	public static Stream<List<String>> streamOfCharacters(String input) throws AdventOfCodeException {
		return streamOfLines(input).map(TexteUtils::stringToList);
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
		return streamOfLines(input).toList();
	}

	public static List<Integer> listOfIntegers(String input) throws AdventOfCodeException {
		return streamOfInt(input).boxed().toList();
	}

	public static List<Long> listOfLongs(String input) throws AdventOfCodeException {
		return streamOfLong(input).boxed().toList();
	}

	public static List<Double> listOfDoubles(String input) throws AdventOfCodeException {
		return streamOfDouble(input).boxed().toList();
	}

	public static List<List<String>> listOfCharacters(String input) throws AdventOfCodeException {
		return streamOfCharacters(input).toList();
	}

	public static Set<String> setOfLines(String input) throws AdventOfCodeException {
		return streamOfLines(input).collect(Collectors.toSet());
	}

	public static Set<Integer> setOfIntegers(String input) throws AdventOfCodeException {
		return streamOfInt(input).boxed().collect(Collectors.toSet());
	}

	public static Set<Long> setOfLongs(String input) throws AdventOfCodeException {
		return streamOfLong(input).boxed().collect(Collectors.toSet());
	}

	public static Set<Double> setOfDoubles(String input) throws AdventOfCodeException {
		return streamOfDouble(input).boxed().collect(Collectors.toSet());
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

}
