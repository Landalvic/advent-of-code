package annees.annee2015.jour08;

import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2015Jour8Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2015Jour8Exercice2().lancer("src/main/resources/annee2015/jour08/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<String> stream = FileUtils.streamOfLines(input);

		int total = stream.mapToInt(string -> {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < string.length(); i++) {
				if (StringUtils.equals("" + string.charAt(i), "\\")) {
					builder.append("\\");
				} else if (StringUtils.equals("" + string.charAt(i), "\"")) {
					builder.append("\\");
				}
				builder.append(string.charAt(i));
			}
			return builder.length() + 2 - string.length();
		}).sum();
		return String.valueOf(total);
	}

}
