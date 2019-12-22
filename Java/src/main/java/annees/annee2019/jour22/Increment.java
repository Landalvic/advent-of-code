package annees.annee2019.jour22;

import java.math.BigInteger;
import java.util.List;

public class Increment implements Operation {

	private int increment;

	public Increment(int increment) {
		super();
		this.increment = increment;
	}

	public int getIncrement() {
		return increment;
	}

	public void setIncrement(int increment) {
		this.increment = increment;
	}

	@Override
	public long calcul(List<Operation> operations, int index, long taille, long monNombre) {
		long inverseRestant = increment - (taille % increment);
		int fois = 0;
		for (int i = 0; i < increment; i++) {
			if ((inverseRestant * i) % increment == 1) {
				fois = i;
				break;
			}
		}
		long unitaire = (taille * fois / increment + 1);
		BigInteger a = new BigInteger("" + monNombre);
		BigInteger b = new BigInteger("" + unitaire);
		BigInteger c = new BigInteger("" + taille);
		long total = a.multiply(b).mod(c).longValue();
		return Operation.lancerPrecedenteOperation(operations, index, taille, total);
	}

}
