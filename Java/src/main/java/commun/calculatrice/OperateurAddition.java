package commun.calculatrice;

public class OperateurAddition extends Operateur {

	public OperateurAddition() {
		super("+", 10);
	}

	public OperateurAddition(String code) {
		super(code, 10);
	}

	public OperateurAddition(String code, int priority) {
		super(code, priority);
	}

	public OperateurAddition(int priority) {
		super("+", priority);
	}

	public double calcul(double valeurGauche, double valeurDroite) {
		return valeurGauche + valeurDroite;
	}

}
