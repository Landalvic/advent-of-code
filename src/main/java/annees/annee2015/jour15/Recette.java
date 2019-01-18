package annees.annee2015.jour15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Recette {

	private Map<Ingredient, Integer> ingredients;

	public Recette(List<Ingredient> ingredients) {
		super();
		this.ingredients = new HashMap<>();
		int total = 0;
		for (Ingredient ingredient : ingredients) {
			int nombre = 100 / ingredients.size();
			total += nombre;
			this.ingredients.put(ingredient, nombre);
		}
		for (int i = 0; i < 100 - total; i++) {
			this.ingredients.put(ingredients.get(i), this.ingredients.get(ingredients.get(i)) + 1);
		}
	}

	public Recette(Recette recette, Ingredient ajout, Ingredient enlever) {
		super();
		this.ingredients = new HashMap<>(recette.ingredients);
		this.ingredients.put(ajout, this.ingredients.get(ajout) + 1);
		this.ingredients.put(enlever, this.ingredients.get(enlever) - 1);
	}

	public int calories() {
		int calories = 0;
		for (Entry<Ingredient, Integer> entry : ingredients.entrySet()) {
			calories += entry.getValue() * entry.getKey().getCalories();
		}
		return calories;
	}

	public int score() {
		int capacite = 0;
		int durabilite = 0;
		int gout = 0;
		int texture = 0;
		for (Entry<Ingredient, Integer> entry : ingredients.entrySet()) {
			capacite += entry.getValue() * entry.getKey().getCapacite();
			durabilite += entry.getValue() * entry.getKey().getDurabilite();
			gout += entry.getValue() * entry.getKey().getGout();
			texture += entry.getValue() * entry.getKey().getTexture();
		}
		return capacite * durabilite * gout * texture;
	}

}
