package commun;

public class MapDefault extends Map<Case> {

	public MapDefault() {
		super();
	}

	public MapDefault(int tailleX, int tailleY) {
		super(tailleX, tailleY);
	}

	@Override
	protected Case initCase(Map<? extends Case> map, Position position) {
		return new Case(map, position);
	}

}
