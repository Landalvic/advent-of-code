package annees.annee2020.jour04;

import java.util.stream.Stream;

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
		Stream<Passeport> passeports = inputToStreamObjectNotNull(input);
		infos.put("ecl", null);
		infos.put("byr", null);
		infos.put("iyr", null);
		infos.put("eyr", null);
		infos.put("hgt", null);
		infos.put("hcl", null);
		infos.put("pid", null);
		return String.valueOf(passeports.filter(this::gererPasseport).count());
	}

	private boolean gererPasseport(Passeport p) {
		for (var entry : infos.entrySet()) {
			if (!p.getInfos().containsKey(entry.getKey())) {
				return false;
			}
		}
		return true;
	}

}
