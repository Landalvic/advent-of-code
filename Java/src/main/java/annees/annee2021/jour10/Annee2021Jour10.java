package annees.annee2021.jour10;

import org.apache.commons.lang3.StringUtils;

import commun.StreamBuilder;
import commun.structure.Exercice;
import commun.util.TexteUtils;

public abstract class Annee2021Jour10 extends Exercice {

	protected Annee2021Jour10(int exercice) {
		super(2021, 10, exercice);
	}

	protected String firstWrongCaractere(String ligne) {
		StreamBuilder builder = new StreamBuilder(ligne);
		return builder.find(caractere -> {
			if (verifierCaractereFermant(caractere)) {
				if (verifierCaractereFusion(builder, caractere, builder.getIndex())) {
					builder.delete(builder.getIndex() - 1, builder.getIndex() + 1);
					builder.addIndex(-2);
				} else {
					return caractere;
				}
			}
			return null;
		});
	}

	protected boolean verifierCaractereFermant(String caractere) {
		return TexteUtils.equals(caractere, ")", "}", "]", ">");
	}

	protected boolean verifierCaractereFusion(StreamBuilder builder, String caractere, int i) {
		return i != 0 && StringUtils.equals(TexteUtils.correspondanceOpposee(caractere), builder.charAt(i - 1));
	}

}
