package annees.annee2021.jour08;

public class Annee2021Jour8Exercice1 extends Annee2021Jour8 {

	public static void main(String[] args) {
		new Annee2021Jour8Exercice1().lancer(true);
	}

	public Annee2021Jour8Exercice1() {
		super(1);
	}

	@Override
	protected int transformCode(CodeDigits code) {
		int total = 0;
		for (var digit : code.getOutput()) {
			if (digit.length() == 4 || digit.length() == 3 || digit.length() == 2 || digit.length() == 7) {
				total++;
			}
		}
		return total;
	}

}
