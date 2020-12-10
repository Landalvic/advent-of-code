package annees.annee2015.jour16;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import commun.util.FileUtils;

public class Annee2015Jour16Exercice1 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour16Exercice1();
	}

	@Override
	public void run() {
		TanteSue vrai = new TanteSue(null, 3, 7, 2, 3, 0, 0, 5, 3, 2, 1);

		List<String> liste = FileUtils.lireFichier("./annee2015/jour16/data.txt");
		Pattern numeroPattern = Pattern.compile("Sue ([0-9]+): .*");
		Pattern enfantsPattern = Pattern.compile(".*children: ([0-9]+).*");
		Pattern chatsPattern = Pattern.compile(".*cats: ([0-9]+).*");
		Pattern samoyedesPattern = Pattern.compile(".*samoyeds: ([0-9]+).*");
		Pattern pomeraniensPattern = Pattern.compile(".*pomeranians: ([0-9]+).*");
		Pattern akitasPattern = Pattern.compile(".*akitas: ([0-9]+).*");
		Pattern vizslasPattern = Pattern.compile(".*vizslas: ([0-9]+).*");
		Pattern poissonsRougesPattern = Pattern.compile(".*goldfish: ([0-9]+).*");
		Pattern arbresPattern = Pattern.compile(".*trees: ([0-9]+).*");
		Pattern voituresPattern = Pattern.compile(".*cars: ([0-9]+).*");
		Pattern parfumsPattern = Pattern.compile(".*perfumes: ([0-9]+).*");

		List<TanteSue> tantes = new ArrayList<>();

		for (String string : liste) {
			Integer numero = FileUtils.trouverPatternInt(string, numeroPattern);
			Integer enfants = FileUtils.trouverPatternInt(string, enfantsPattern);
			Integer chats = FileUtils.trouverPatternInt(string, chatsPattern);
			Integer samoyedes = FileUtils.trouverPatternInt(string, samoyedesPattern);
			Integer pomeraniens = FileUtils.trouverPatternInt(string, pomeraniensPattern);
			Integer akitas = FileUtils.trouverPatternInt(string, akitasPattern);
			Integer vizslas = FileUtils.trouverPatternInt(string, vizslasPattern);
			Integer poissonsRouges = FileUtils.trouverPatternInt(string, poissonsRougesPattern);
			Integer arbres = FileUtils.trouverPatternInt(string, arbresPattern);
			Integer voitures = FileUtils.trouverPatternInt(string, voituresPattern);
			Integer parfums = FileUtils.trouverPatternInt(string, parfumsPattern);
			tantes.add(new TanteSue(numero, enfants, chats, samoyedes, pomeraniens, akitas, vizslas, poissonsRouges,
					arbres, voitures, parfums));
		}

		for (TanteSue tanteSue : tantes) {
			boolean vraiTanteSue = true;
			if (tanteSue.getEnfants() != null && tanteSue.getEnfants() != vrai.getEnfants()) {
				vraiTanteSue = false;
			} else if (tanteSue.getChats() != null && tanteSue.getChats() != vrai.getChats()) {
				vraiTanteSue = false;
			} else if (tanteSue.getSamoyedes() != null && tanteSue.getSamoyedes() != vrai.getSamoyedes()) {
				vraiTanteSue = false;
			} else if (tanteSue.getPomeraniens() != null && tanteSue.getPomeraniens() != vrai.getPomeraniens()) {
				vraiTanteSue = false;
			} else if (tanteSue.getAkitas() != null && tanteSue.getAkitas() != vrai.getAkitas()) {
				vraiTanteSue = false;
			} else if (tanteSue.getVizslas() != null && tanteSue.getVizslas() != vrai.getVizslas()) {
				vraiTanteSue = false;
			} else if (tanteSue.getPoissonsRouges() != null
					&& tanteSue.getPoissonsRouges() != vrai.getPoissonsRouges()) {
				vraiTanteSue = false;
			} else if (tanteSue.getArbres() != null && tanteSue.getArbres() != vrai.getArbres()) {
				vraiTanteSue = false;
			} else if (tanteSue.getVoitures() != null && tanteSue.getVoitures() != vrai.getVoitures()) {
				vraiTanteSue = false;
			} else if (tanteSue.getParfums() != null && tanteSue.getParfums() != vrai.getParfums()) {
				vraiTanteSue = false;
			}
			if (vraiTanteSue) {
				System.out.println(tanteSue);
			}
		}

	}

}
