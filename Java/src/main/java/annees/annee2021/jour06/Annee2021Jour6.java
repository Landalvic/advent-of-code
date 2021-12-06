package annees.annee2021.jour06;

import java.util.ArrayList;
import java.util.List;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public abstract class Annee2021Jour6 extends Exercice {

	protected Annee2021Jour6(int exercice) {
		super(2021, 6, exercice);
	}

	public String runCommun(String input, int nbrJours) throws AdventOfCodeException {
		var nombres = FileUtils.firstLineOfInteger(input, ",");
		List<BancDePoissons> poissons = new ArrayList<>();
		for (Integer integer : nombres) {
			ajouterPoisson(poissons, integer);
		}
		for (int j = 0; j < nbrJours; j++) {
			poissons.forEach(p -> p.setNumero(p.getNumero() - 1));
			var bancReproduction = trouverBancDePoisson(poissons, -1);
			var banc6 = trouverBancDePoisson(poissons, 6);
			banc6.setNombre(banc6.getNombre() + bancReproduction.getNombre());
			bancReproduction.setNumero(8);
		}
		return String.valueOf(poissons.stream().mapToLong(BancDePoissons::getNombre).sum());
	}

	protected void ajouterPoisson(List<BancDePoissons> poissons, int numero) {
		var banc = trouverBancDePoisson(poissons, numero);
		banc.setNombre(banc.getNombre() + 1);
	}

	protected BancDePoissons trouverBancDePoisson(List<BancDePoissons> poissons, int numero) {
		var bloc = poissons.stream().filter(p -> p.getNumero() == numero).findAny().orElse(null);
		if (bloc == null) {
			bloc = new BancDePoissons(numero, 0);
			poissons.add(bloc);
		}
		return bloc;
	}

}
