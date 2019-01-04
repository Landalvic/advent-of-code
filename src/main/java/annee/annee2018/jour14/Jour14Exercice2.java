package annee.annee2018.jour14;

public class Jour14Exercice2 {

	public static void main(String[] args) {

		String input = "509671";

		int indexElfe1 = 0;
		int indexElfe2 = 1;
		StringBuilder recettes = new StringBuilder();
		recettes.append(3);
		recettes.append(7);
		int indexDejaVerifie = 5;

		while (!recettes.substring(indexDejaVerifie - 5).contains(input)) {
			indexDejaVerifie = recettes.length() > 5 ? recettes.length() - 1 : 5;
			int recette1 = Integer.valueOf("" + recettes.charAt(indexElfe1));
			int recette2 = Integer.valueOf("" + recettes.charAt(indexElfe2));
			String melange = "" + (recette1 + recette2);
			for (int j = 0; j < melange.length(); j++) {
				recettes.append(Integer.valueOf("" + melange.charAt(j)));
			}
			indexElfe1 = (indexElfe1 + 1 + recette1) % recettes.length();
			indexElfe2 = (indexElfe2 + 1 + recette2) % recettes.length();
		}
		System.out.println(recettes.substring(indexDejaVerifie - 5).indexOf(input) + indexDejaVerifie - 5);

	}

}
