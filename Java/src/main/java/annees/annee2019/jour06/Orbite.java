package annees.annee2019.jour06;

import commun.Hierarchie;

public class Orbite extends Hierarchie {

	private String code;

	public Orbite(String code) {
		super();
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Orbite [code=" + code + "]";
	}

}
