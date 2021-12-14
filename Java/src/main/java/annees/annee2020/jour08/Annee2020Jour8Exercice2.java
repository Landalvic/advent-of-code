package annees.annee2020.jour08;

import java.util.ArrayList;
import java.util.List;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour8Exercice2 extends Annee2020Jour8 {

	public static void main(String[] args) {
		new Annee2020Jour8Exercice2().lancer(true);
	}

	public Annee2020Jour8Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Taches taches = new Taches(inputToListObject(input));
		List<Taches> listePossible = new ArrayList<>();
		listePossible.add(taches);
		Taches initiale = listePossible.get(0);
		for (int i = 0; i < initiale.getListeTaches().size(); i++) {
			if (initiale.getListeTaches().get(i) instanceof Jump) {
				listePossible.add(replaceTache(input, i, new NoOperation()));
			} else if (initiale.getListeTaches().get(i) instanceof NoOperation) {
				listePossible.add(replaceTache(input, i, new Jump()));
			}
		}
		while (true) {
			for (Taches tachesEnC : listePossible) {
				if (tachesEnC.getDonnees().getIndex() == tachesEnC.getListeTaches().size() - 1) {
					tachesEnC.getIndex().run(tachesEnC.getDonnees());
					return String.valueOf(tachesEnC.getDonnees().getAccumulateur());
				}
				tachesEnC.getIndex().run(tachesEnC.getDonnees());
			}
		}
	}

	private Taches replaceTache(String input, int index, Tache tache) throws AdventOfCodeException {
		Taches taches = new Taches(new ArrayList<>(inputToListObject(input)));
		Tache t = taches.getListeTaches().remove(index);
		tache.setNbr(t.getNbr());
		tache.setRunned(t.isRunned());
		taches.getListeTaches().add(index, tache);
		return taches;
	}

}
