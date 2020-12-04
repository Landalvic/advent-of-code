package annees.annee2020.jour04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import util.FileUtils;

public class Annee2020Jour4Exercice2 extends Annee2020Jour4 {

	public static void main(String[] args) {
		new Annee2020Jour4Exercice2().lancer(2020, 4, 2, true);
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
				if (blocs[1].contains("amb") || blocs[1].contains("blu") || blocs[1].contains("brn") || blocs[1].contains("gry") || blocs[1].contains("grn") || blocs[1].contains("hzl")
						|| blocs[1].contains("oth")) {
					ecl = true;
				}
			} else if (StringUtils.equals(blocs[0], "byr")) {
				try {
					int nbr = Integer.parseInt(blocs[1]);
					if (nbr >= 1920 && nbr <= 2002) {
						byr = true;
					}
				} catch (Exception e) {}
			} else if (StringUtils.equals(blocs[0], "iyr")) {
				try {
					int nbr = Integer.parseInt(blocs[1]);
					if (nbr >= 2010 && nbr <= 2020) {
						iyr = true;
					}
				} catch (Exception e) {}
			} else if (StringUtils.equals(blocs[0], "eyr")) {
				try {
					int nbr = Integer.parseInt(blocs[1]);
					if (nbr >= 2020 && nbr <= 2030) {
						eyr = true;
					}
				} catch (Exception e) {}
			} else if (StringUtils.equals(blocs[0], "hgt")) {
				try {
					if (blocs[1].contains("cm")) {
						int nbr = Integer.parseInt(blocs[1].replace("cm", ""));
						if (nbr >= 150 && nbr <= 193) {
							hgt = true;
						}
					} else if (blocs[1].contains("in")) {
						int nbr = Integer.parseInt(blocs[1].replace("in", ""));
						if (nbr >= 59 && nbr <= 76) {
							hgt = true;
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			} else if (StringUtils.equals(blocs[0], "hcl")) {
				if (blocs[1].length() == 7) {
					if (StringUtils.equals(String.valueOf(blocs[1].charAt(0)), "#")) {
						boolean test = true;
						for (int i = 1; i < blocs[1].length(); i++) {
							if (!StringUtils.equals(String.valueOf(blocs[1].charAt(i)), "a") && !StringUtils.equals(String.valueOf(blocs[1].charAt(i)), "b")
									&& !StringUtils.equals(String.valueOf(blocs[1].charAt(i)), "c") && !StringUtils.equals(String.valueOf(blocs[1].charAt(i)), "d")
									&& !StringUtils.equals(String.valueOf(blocs[1].charAt(i)), "e")
									&& !StringUtils.equals(String.valueOf(blocs[1].charAt(i)), "f")) {
								try {
									int nbr = Integer.parseInt(String.valueOf(blocs[1].charAt(i)));
								} catch (Exception e) {
									test = false;
									break;
								}
							}
						}
						if (test) {
							hcl = true;
						}
					}
				}
			} else if (StringUtils.equals(blocs[0], "pid")) {
				if (blocs[1].length() == 9) {
					try {
						int nbr = Integer.parseInt(blocs[1]);
						pid = true;
					} catch (Exception e) {}
				}
			} else if (StringUtils.equals(blocs[0], "cid")) {
				cid = true;
			}
		}
		return ecl && byr && iyr && eyr && hgt && hcl && pid;
	}

}
