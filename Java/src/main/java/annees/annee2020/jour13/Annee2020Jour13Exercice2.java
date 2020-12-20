package annees.annee2020.jour13;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour13Exercice2 extends Annee2020Jour13 {

	public static void main(String[] args) {
		new Annee2020Jour13Exercice2().lancer(true);
	}

	public Annee2020Jour13Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Bus> bus = inputToBus(input);
		long increment = 1;
		while (true) {
			Set<Long> modulos = new HashSet<>();
			boolean test = true;
			for (Bus b : bus) {
				long mod = (increment + b.getDecalage()) % b.getId();
				if (mod != 0) {
					test = false;
				} else {
					modulos.add(b.getId());
				}
			}
			if (test) {
				return String.valueOf(increment);
			} else {
				increment += modulos.stream().reduce(1L, (a, b) -> a * b);
			}
		}
	}

}
