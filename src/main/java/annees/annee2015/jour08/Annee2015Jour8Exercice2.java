package annees.annee2015.jour08;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import util.FileUtils;

public class Annee2015Jour8Exercice2 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour8Exercice2();
	}

	@Override
	public void run() {
		List<String> liste = FileUtils.lireFichier("./annee2015/jour8/data.txt");

		int total = 0;
		for (String string : liste) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < string.length(); i++) {
				if (StringUtils.equals("" + string.charAt(i), "\\")) {
					builder.append("\\");
				} else if (StringUtils.equals("" + string.charAt(i), "\"")) {
					builder.append("\\");
				}
				builder.append(string.charAt(i));
			}
			total += builder.length() + 2 - string.length();
		}
		System.out.println(total);

	}

}
