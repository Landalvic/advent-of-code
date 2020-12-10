package annees.annee2020.jour04;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2020Jour4Exercice2 extends Annee2020Jour4 {

	public static void main(String[] args) {
		new Annee2020Jour4Exercice2().lancer(2020, 4, 2, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<Passeport> passeports = inputToStreamObjectNotNull(input);
		infos.put("ecl", Pattern.compile("^(amb|blu|brn|gry|grn|hzl|oth)$"));
		infos.put("byr", Pattern.compile("^([1][9][2][0-9]|[1][9][3-9][0-9]|[2][0][0][0-2])$"));
		infos.put("iyr", Pattern.compile("^([2][0][1][0-9]|[2][0][2][0])$"));
		infos.put("eyr", Pattern.compile("^([2][0][2][0-9]|[2][0][3][0])$"));
		infos.put("hgt", Pattern.compile("^(([1][5-8][0-9]|[1][9][0-3])cm|([5][9]|[6][0-9]|[7][0-6])in)$"));
		infos.put("hcl", Pattern.compile("^#[0-9a-f]{6}$"));
		infos.put("pid", Pattern.compile("^[0-9]{9}$"));
		return String.valueOf(passeports.filter(this::gererPasseport).count());
	}

	private boolean gererPasseport(Passeport p) {
		for (var entry : infos.entrySet()) {
			if (!p.getInfos().containsKey(entry.getKey())
					|| !FileUtils.findPattern(p.getInfos().get(entry.getKey()), entry.getValue())) {
				return false;
			}
		}
		return true;
	}

}
