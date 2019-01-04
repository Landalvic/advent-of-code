package annee.annee2018.jour15;

public class Elfe extends Personnage {

	public Elfe(Case emplacement, int degats) {
		super(emplacement, degats);
	}

	@Override
	public boolean isEnnemi(Personnage personnage) {
		if (personnage == null) {
			return false;
		}
		return personnage instanceof Gobelin;
	}

	@Override
	public String toString() {
		return "E";
	}

}
