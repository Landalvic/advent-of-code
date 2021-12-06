package annees.annee2021.jour04;

public class PlancheBingo {

	private NumeroBingo[][] planche = new NumeroBingo[5][5];

	public NumeroBingo[][] getPlanche() {
		return planche;
	}

	public void setPlanche(NumeroBingo[][] planche) {
		this.planche = planche;
	}

	public void validerNumero(int numero) {
		for (NumeroBingo[] numeroBingos : planche) {
			for (NumeroBingo numeroBingo : numeroBingos) {
				if (numeroBingo.getNumero() == numero) {
					numeroBingo.setGagnant(true);
					return;
				}
			}
		}
	}

	public boolean isGagnant() {
		for (int i = 0; i < 5; i++) {
			boolean gagnant = ligneOuColonneGagnante(i, true) || ligneOuColonneGagnante(i, false);
			if (gagnant) {
				return true;
			}
		}
		return false;
	}

	private boolean ligneOuColonneGagnante(int i, boolean ligne) {
		for (int j = 0; j < 5; j++) {
			NumeroBingo numeroBingo = ligne ? planche[i][j] : planche[j][i];
			if (!numeroBingo.isGagnant()) {
				return false;
			}
		}
		return true;
	}

	public int totalNonGagnant() {
		int total = 0;
		for (NumeroBingo[] numeroBingos : planche) {
			for (NumeroBingo numeroBingo : numeroBingos) {
				if (!numeroBingo.isGagnant()) {
					total += numeroBingo.getNumero();
				}
			}
		}
		return total;
	}

}
