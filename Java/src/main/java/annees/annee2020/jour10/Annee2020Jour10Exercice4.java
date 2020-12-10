package annees.annee2020.jour10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2020Jour10Exercice4 extends Annee2020Jour10 {

	public static void main(String[] args) {
		new Annee2020Jour10Exercice4().lancer(2020, 10, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Integer> liste = FileUtils.listOfIntegers(input);
		int departtest = 0;
		List<AtomicInteger> departs = new ArrayList<>();
		long total = 0;
		List<AtomicInteger> ajout = new ArrayList<>();
		departs.add(new AtomicInteger(departtest));
		int tension1 = 0;
		int tension2 = 0;
		int tension3 = 0;
		while (!departs.isEmpty()) {
			boolean test = false;
			while (!departs.isEmpty()) {
				Iterator<AtomicInteger> iterator = departs.iterator();
				for (int i = 0; i < departs.size(); i++) {
					AtomicInteger depart = departs.get(i);
					if (liste.contains(depart.get() + 1)) {
						if (liste.contains(depart.get() + 2)) {
							ajout.add(new AtomicInteger(depart.get() + 2));
						}
						if (liste.contains(depart.get() + 3)) {
							ajout.add(new AtomicInteger(depart.get() + 3));
						}
						depart.incrementAndGet();
					} else if (liste.contains(depart.get() + 2)) {
						if (liste.contains(depart.get() + 3)) {
							ajout.add(new AtomicInteger(depart.get() + 3));
						}
						depart.addAndGet(2);
					} else if (liste.contains(depart.get() + 3)) {
						depart.addAndGet(3);
					} else {
						tension3++;
						depart.addAndGet(3);
						departs.remove(i);
						i--;
						total++;
					}
				}
			}
			departs.clear();
			departs.addAll(ajout);
			ajout.clear();
		}
		return "" + total;
	}

}
