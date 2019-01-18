package annees.annee2015.jour4;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;

import util.MathUtils;

public class Annee2015Jour4Exercice2 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour4Exercice1();
	}

	@Override
	public void run() {
		String input = "ckczppom";
		try {
			String hex = "";
			int i = 0;
			do {
				i++;
				String inputTemp = input + i;
				byte[] byteChaine = inputTemp.getBytes("UTF-8");
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] hash = md.digest(byteChaine);
				hex = MathUtils.toHexString(hash);
			} while (!StringUtils.equals(hex.substring(0, 6), "000000"));
			System.out.println(i);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
