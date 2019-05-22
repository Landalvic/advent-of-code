package annees.annee2015.jour07;

public class Annee2015Jour7Exercice2 extends Annee2015Jour7 {

	public static void main(String[] args) {
		new Annee2015Jour7Exercice2().lancer("src/main/resources/annee2015/jour07/data.txt");
	}

	@Override
	public String run(String input) throws Exception {
		return runCommun(input, Integer.valueOf(runCommun(input, null)));
	}

}
