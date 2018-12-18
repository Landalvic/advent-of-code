package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class FileUtils {

	public static StringBuilder lireLigne(String lien, int sizebuff) {
		StringBuilder builder = new StringBuilder();
		InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(lien);
		char[] buf = new char[sizebuff];
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
