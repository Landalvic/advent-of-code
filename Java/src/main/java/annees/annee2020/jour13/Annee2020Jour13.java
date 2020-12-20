package annees.annee2020.jour13;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public abstract class Annee2020Jour13 extends Exercice {

	@Override
	protected void init() {}

	public Annee2020Jour13(int exercice) {
		super(2020, 13, exercice);
	}

	protected List<Bus> inputToBus(String input) throws AdventOfCodeException {
		List<String> lignes = FileUtils.listOfLines(input);
		List<Bus> bus = new ArrayList<>();
		String[] blocs = lignes.get(1).split(",", -1);
		for (int i = 0; i < blocs.length; i++) {
			if (!StringUtils.equals("x", blocs[i])) {
				bus.add(new Bus(Long.valueOf(blocs[i]), i));
			}
		}
		return bus;
	}

}
