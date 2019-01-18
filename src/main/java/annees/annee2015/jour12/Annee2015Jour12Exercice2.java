package annees.annee2015.jour12;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import util.FileUtils;

public class Annee2015Jour12Exercice2 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour12Exercice2();
	}

	@Override
	public void run() {
		StringBuilder input = FileUtils.lireLigne("./annee2015/jour12/data.txt");
		int total = 0;

		int indexRouge = input.indexOf(":\"red\"");
		while (indexRouge != -1) {
			int decalageAccolade = 0;
			for (int i = indexRouge; i < input.length(); i++) {
				if (StringUtils.equals("" + input.charAt(i), "}")) {
					if (decalageAccolade == 0) {
						int indexDebut = 0;
						for (int j = indexRouge; j >= 0; j--) {
							if (StringUtils.equals("" + input.charAt(j), "{")) {
								if (decalageAccolade == 0) {
									indexDebut = j;
									break;
								} else {
									decalageAccolade--;
								}
							} else if (StringUtils.equals("" + input.charAt(j), "}")) {
								decalageAccolade++;
							}
						}
						if (indexDebut - 1 == -1) {
							System.out.println("test");
						}
						input = new StringBuilder(input.substring(0, indexDebut) + input.substring(i + 1));
						break;
					} else {
						decalageAccolade--;
					}
				} else if (StringUtils.equals("" + input.charAt(i), "{")) {
					decalageAccolade++;
				}
			}
			indexRouge = input.indexOf(":\"red\"");
		}

		for (int i = 0; i < input.length(); i++) {
			if (StringUtils.equals("" + input.charAt(i), "-") || NumberUtils.isDigits("" + input.charAt(i))) {
				StringBuilder builder = new StringBuilder("" + input.charAt(i));
				for (int j = i + 1; j < input.length(); j++, i++) {
					if (NumberUtils.isDigits("" + input.charAt(j))) {
						builder.append(input.charAt(j));
					} else {
						break;
					}
				}
				total += Integer.valueOf(builder.toString());
				System.out.println(builder.toString() + " -> " + Integer.valueOf(builder.toString()));
			}
		}
		System.out.println(total);
	}

}
