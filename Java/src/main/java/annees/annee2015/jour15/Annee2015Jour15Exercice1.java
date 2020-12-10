package annees.annee2015.jour15;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import commun.util.FileUtils;

public class Annee2015Jour15Exercice1 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour15Exercice1();
	}

	@Override
	public void run() {
		List<String> liste = FileUtils.lireFichier("./annee2015/jour15/data.txt");
		Pattern nomPattern = Pattern.compile("(.*): capacity .*");
		Pattern capacitePattern = Pattern.compile(".*: capacity (.*), durability .*");
		Pattern durabilitePattern = Pattern.compile(".*, durability (.*), flavor .*");
		Pattern goutPattern = Pattern.compile(".*, flavor (.*), texture .*");
		Pattern texturePattern = Pattern.compile(".*, texture (.*), calories .*");
		Pattern caloriesPattern = Pattern.compile(".*, calories (.*)");

		List<Ingredient> ingredients = new ArrayList<>();

		for (String string : liste) {
			String nom = FileUtils.trouverPattern(string, nomPattern);
			int capacite = FileUtils.trouverPatternInt(string, capacitePattern);
			int durabilite = FileUtils.trouverPatternInt(string, durabilitePattern);
			int gout = FileUtils.trouverPatternInt(string, goutPattern);
			int texture = FileUtils.trouverPatternInt(string, texturePattern);
			int calories = FileUtils.trouverPatternInt(string, caloriesPattern);
			ingredients.add(new Ingredient(nom, capacite, durabilite, gout, texture, calories));
		}

		Recette meilleureRecette = new Recette(ingredients);
		boolean changement = true;
		while (changement) {
			changement = false;
			for (Ingredient ingredient : ingredients) {
				for (Ingredient ingredient2 : ingredients) {
					if (ingredient != ingredient2) {
						Recette newRecette = new Recette(meilleureRecette, ingredient, ingredient2);
						if (meilleureRecette.score() < newRecette.score()) {
							meilleureRecette = newRecette;
							changement = true;
						}
					}
				}
			}
		}

		System.out.println(meilleureRecette.score());

	}

}
