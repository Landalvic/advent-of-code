package commun;

public class InfosCase extends Infos {

	private static final long serialVersionUID = 1L;

	private Case<? extends InfosCase> caseMap;

	public Case<? extends InfosCase> getCaseMap() {
		return caseMap;
	}

	public void setCaseMap(Case<? extends InfosCase> caseMap) {
		this.caseMap = caseMap;
	}

}
