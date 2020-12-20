package commun;

public class CaseDefault extends Case<CaseDefault> {

	public CaseDefault(MapCases<CaseDefault> map, Position position) {
		super(map, position);
	}

	public CaseDefault(MapCases<CaseDefault> map, Position position, String id) {
		super(map, position, id);
	}

	@Override
	public CaseDefault getThis() {
		return this;
	}

}
