package annees.annee2015.jour10;

import commun.Exercice;

public abstract class Annee2015Jour10 extends Exercice {

	public String runCommun(String input, int iterations) throws Exception {
		for (int iteration = 0; iteration < iterations; iteration++) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				int nbr = 1;
				for (int j = i + 1; j < input.length(); j++) {
					if (c == input.charAt(j)) {
						nbr++;
					} else {
						break;
					}
				}
				builder.append(nbr + "" + c);
				i += nbr - 1;
			}
			input = builder.toString();
		}
		return String.valueOf(input.length());
	}

}
