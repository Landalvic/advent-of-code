package annees.annee2018.jour15;

public class Gobelin extends Personnage {

	public Gobelin(Case emplacement) {
		super(emplacement, 3);
	}

	@Override
	public boolean isEnnemi(Personnage personnage) {
		if (personnage == null) {
			return false;
		}
		return personnage instanceof Elfe;
	}

	@Override
	public String toString() {
		return "G";
	}

}
