package annees.annee2015.jour11;

public class Annee2015Jour11Exercice2 extends Annee2015Jour11 {

	public static void main(String[] args) {
		new Annee2015Jour11Exercice2().lancer("vzbxkghb");
	}

	@Override
	public String run(String input) throws Exception {
		return runCommun(runCommun(input));
	}

}
