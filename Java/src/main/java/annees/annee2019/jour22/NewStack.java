package annees.annee2019.jour22;

public class NewStack implements Operation {

	@Override
	public int calcul(int taille, int monNombre) {
		return taille - monNombre;
	}

}
