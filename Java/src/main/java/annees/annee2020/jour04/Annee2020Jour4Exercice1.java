package annees.annee2020.jour04;

import java.util.List;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour4Exercice1 extends Annee2020Jour4 {

	public static void main(String[] args) {
		new Annee2020Jour4Exercice1().lancer(true);
	}

	public Annee2020Jour4Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Passeport> passeports = inputToListObject(input);
		infos.put("ecl", null);
		infos.put("byr", null);
		infos.put("iyr", null);
		infos.put("eyr", null);
		infos.put("hgt", null);
		infos.put("hcl", null);
		infos.put("pid", null);
		return String.valueOf(passeports.stream().filter(this::gererPasseport).count());
	}

}
