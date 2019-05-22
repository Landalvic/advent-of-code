package annees.annee2018.jour03;

import java.util.List;

public class Annee2018Jour3Exercice2 extends Annee2018Jour3 {

	public static void main(String[] args) {
		new Annee2018Jour3Exercice2().lancer("src/main/resources/annee2018/jour03/data.txt");
	}

	@Override
	public String run(String input) throws Exception {
		List<Demande> demandes = inputToDemandes(input);
		return String.valueOf(demandes.stream().filter(demande -> demande.isSeul()).findAny().get().getId());
	}

}
