package annees.annee2015.jour09;

public class Annee2015Jour9Exercice1 extends Annee2015Jour9 {

	public static void main(String[] args) {
		new Annee2015Jour9Exercice1().lancer("src/main/resources/annee2015/jour09/data.txt");
	}

	@Override
	public String run(String input) throws Exception {
		return String.valueOf(runCommun(input).min().getAsInt());
	}

}
