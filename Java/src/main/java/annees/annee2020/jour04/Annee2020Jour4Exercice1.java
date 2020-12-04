package annees.annee2020.jour04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import util.FileUtils;

public class Annee2020Jour4Exercice1 extends Annee2020Jour4 {

	public static void main(String[] args) {
		new Annee2020Jour4Exercice1().lancer(2020, 4, 1, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<String> liste = FileUtils.listOfLines(input);
		List<String> passeport = new ArrayList<>();
		int total = 0;
		for (int i = 0; i < liste.size(); i++) {
			String string = liste.get(i);
			if (string.trim().length() == 0) {
				if (gererPasseport(passeport)) {
					total++;
				}
				passeport = new ArrayList<>();
			} else {
				String[] blocs = string.split(" ", -1);
				passeport.addAll(Arrays.asList(blocs));
			}
		}
		if (gererPasseport(passeport)) {
			total++;
		}
		return String.valueOf(total);
	}

	private boolean gererPasseport(List<String> p) {
		boolean ecl = false;
		boolean byr = false;
		boolean iyr = false;
		boolean eyr = false;
		boolean hgt = false;
		boolean hcl = false;
		boolean pid = false;
		boolean cid = false;
		for (String string : p) {
			String[] blocs = string.split(":", -1);
			if (StringUtils.equals(blocs[0], "ecl")) {
				ecl = true;
			} else if (StringUtils.equals(blocs[0], "byr")) {
				byr = true;
			} else if (StringUtils.equals(blocs[0], "iyr")) {
				iyr = true;
			} else if (StringUtils.equals(blocs[0], "eyr")) {
				eyr = true;
			} else if (StringUtils.equals(blocs[0], "hgt")) {
				hgt = true;
			} else if (StringUtils.equals(blocs[0], "hcl")) {
				hcl = true;
			} else if (StringUtils.equals(blocs[0], "pid")) {
				pid = true;
			} else if (StringUtils.equals(blocs[0], "cid")) {
				cid = true;
			}
		}
		return ecl && byr && iyr && eyr && hgt && hcl && pid;
	}

}
