package annees.annee2020.jour04;

import java.util.List;
import java.util.regex.Pattern;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour4Exercice2 extends Annee2020Jour4 {

	public static void main(String[] args) {
		new Annee2020Jour4Exercice2().lancer(true);
	}

	public Annee2020Jour4Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Passeport> passeports = inputToListObject(input);
		infos.put("ecl", Pattern.compile("^(amb|blu|brn|gry|grn|hzl|oth)$"));
		infos.put("byr", Pattern.compile("^([1][9][2][0-9]|[1][9][3-9][0-9]|[2][0][0][0-2])$"));
		infos.put("iyr", Pattern.compile("^([2][0][1][0-9]|[2][0][2][0])$"));
		infos.put("eyr", Pattern.compile("^([2][0][2][0-9]|[2][0][3][0])$"));
		infos.put("hgt", Pattern.compile("^(([1][5-8][0-9]|[1][9][0-3])cm|([5][9]|[6][0-9]|[7][0-6])in)$"));
		infos.put("hcl", Pattern.compile("^#[0-9a-f]{6}$"));
		infos.put("pid", Pattern.compile("^[0-9]{9}$"));
		return String.valueOf(passeports.stream().filter(this::gererPasseport).count());
	}

}
