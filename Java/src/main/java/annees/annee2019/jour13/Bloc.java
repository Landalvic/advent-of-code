package annees.annee2019.jour13;

import commun.Case;
import commun.Position;

public class Bloc extends Case {

	private long value;

	public Bloc(Position position, long value) {
		super(position);
		this.value = value;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

}
