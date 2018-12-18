package jours.jour5;

import org.apache.commons.lang3.StringUtils;

import util.FileUtils;

public class Jour5Exercice1 {

	public static void main(String[] args) {
		StringBuilder polymere = FileUtils.lireLigne("./jour5/data.txt", 50000);
		for (int i = 0; i < polymere.length() - 1; i++) {
			if (StringUtils.equalsIgnoreCase("" + polymere.charAt(i), "" + polymere.charAt(i + 1))
					&& !StringUtils.equals("" + polymere.charAt(i), "" + polymere.charAt(i + 1))) {
				polymere.deleteCharAt(i + 1);
				polymere.deleteCharAt(i);
				i = i - 2;
				if (i < 0) {
					i = -1;
				}
			}
		}
		System.out.println(polymere.length());
	}

}
