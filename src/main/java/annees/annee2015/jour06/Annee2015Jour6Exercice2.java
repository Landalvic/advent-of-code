package annees.annee2015.jour06;

public class Annee2015Jour6Exercice2 extends Annee2015Jour6 {

	public static void main(String[] args) {
		new Annee2015Jour6Exercice2().lancer("src/main/resources/annee2015/jour06/data.txt");
	}

	@Override
	protected int allumer(int lumiere) {
		return lumiere + 1;
	}

	@Override
	protected int eteindre(int lumiere) {
		return lumiere - 1 >= 0 ? lumiere - 1 : 0;
	}

	@Override
	protected int basculer(int lumiere) {
		return lumiere + 2;
	}

}
