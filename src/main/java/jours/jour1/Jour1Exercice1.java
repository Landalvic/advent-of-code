package jours.jour1;

import java.util.List;

import util.FileUtils;

public class Jour1Exercice1 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour1/data.txt");
		int total = 0;
		for (String string : liste) {
			total += Integer.valueOf(string);
		}
		System.out.println(total);
	}

}
