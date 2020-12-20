package commun.calculatrice;

public class OperateurMultiplication extends Operateur {

	public OperateurMultiplication() {
		super("*", 20);
	}

	public OperateurMultiplication(String code) {
		super(code, 20);
	}

	public OperateurMultiplication(String code, int priority) {
		super(code, priority);
	}

	public OperateurMultiplication(int priority) {
		super("*", priority);
	}

	public double calcul(double valeurGauche, double valeurDroite) {
		return valeurGauche * valeurDroite;
	}

}
