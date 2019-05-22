package annees.annee2015.jour10;

public class Annee2015Jour10Exercice2 extends Annee2015Jour10 {

	public static void main(String[] args) {
		new Annee2015Jour10Exercice2().lancer("1321131112");
	}

	@Override
	public String run(String input) throws Exception {
		return String.valueOf(runCommun(input, 50));
	}

}
