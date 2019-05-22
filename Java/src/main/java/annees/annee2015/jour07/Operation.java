package annees.annee2015.jour07;

public enum Operation {

	AND(" AND "),
	OR(" OR "),
	LSHIFT(" LSHIFT "),
	RSHIFT(" RSHIFT "),
	NOT("NOT ");

	private String pattern;

	private Operation(String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}

}
