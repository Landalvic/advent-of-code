package annees.annee2018.jour08;

import java.util.ArrayList;
import java.util.List;

import commun.util.FileUtils;

public class Jour8Exercice2 {

	public static void main(String[] args) {
		StringBuilder arbre = FileUtils.lireLigne("./jour8/data.txt");
		String[] elements = arbre.toString().split(" ");

		List<Noeud> noeuds = new ArrayList<>();
		Noeud noeudRacine = null;
		for (int i = 0; i < elements.length; i++) {
			if (noeuds.size() > 0 && noeuds.get(0).getNbrEnfants() == 0) {
				Noeud noeudEnCours = noeuds.get(0);
				for (int j = 0; j < noeudEnCours.getNbrMetadonnees(); j++) {
					noeudEnCours.getMetadonnees().add(Integer.valueOf(elements[i + j]));
				}
				i += noeudEnCours.getNbrMetadonnees() - 1;
				noeudEnCours.setNbrMetadonnees(0);
				noeuds.remove(0);
			} else {
				Noeud noeud = new Noeud(Integer.valueOf(elements[i]), Integer.valueOf(elements[i + 1]));
				i++;
				if (noeuds.size() > 0) {
					noeuds.get(0).getEnfants().add(noeud);
					noeuds.get(0).setNbrEnfants(noeuds.get(0).getNbrEnfants() - 1);
				}
				noeuds.add(0, noeud);
				if (noeudRacine == null) {
					noeudRacine = noeud;
				}
			}
		}

		System.out.println(noeudRacine.calculValeur());
	}

}
