package annees.annee2015.jour04;

import java.security.MessageDigest;

import commun.structure.Exercice;
import commun.util.MathUtils;

public abstract class Annee2015Jour4 extends Exercice {

	public String digest(String input) throws Exception {
		byte[] byteChaine = input.getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] hash = md.digest(byteChaine);
		return MathUtils.toHexString(hash);
	}

}
