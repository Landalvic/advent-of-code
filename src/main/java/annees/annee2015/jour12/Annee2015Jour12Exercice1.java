package annees.annee2015.jour12;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import util.FileUtils;

public class Annee2015Jour12Exercice1 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour12Exercice1();
	}

	@Override
	public void run() {
		StringBuilder input = FileUtils.lireLigne("./annee2015/jour12/data.txt");
		int total = 0;
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
			}
		}
		System.out.println(total);
	}

}
