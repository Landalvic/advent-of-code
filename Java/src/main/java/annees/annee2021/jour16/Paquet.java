package annees.annee2021.jour16;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.StreamBuilder;
import commun.util.MathUtils;

public class Paquet {

	private StreamBuilder builder;

	public Paquet(StreamBuilder builder) {
		super();
		this.builder = builder;
	}

	public long version() {
		return MathUtils.binaryToLong(builder.substring(0, 3), 2);
	}

	public long id() {
		return MathUtils.binaryToLong(builder.substring(3, 6), 2);
	}

	public int idLongueur() {
		return Integer.parseInt(builder.charAt(6));
	}

	public long calculValeur() {
		var liste = listeSousPaquets();
		switch ((int) id()) {
			case 0: {
				long total = 0;
				for (Paquet paquet : liste) {
					total += paquet.calculValeur();
				}
				return total;
			}
			case 1: {
				long total = 1;
				for (Paquet paquet : liste) {
					total *= paquet.calculValeur();
				}
				return total;
			}
			case 2: {
				long total = Long.MAX_VALUE;
				for (Paquet paquet : liste) {
					total = Math.min(total, paquet.calculValeur());
				}
				return total;
			}
			case 3: {
				long total = Long.MIN_VALUE;
				for (Paquet paquet : liste) {
					total = Math.max(total, paquet.calculValeur());
				}
				return total;
			}
			case 4: {
				return messageToLong();
			}
			case 5: {
				return liste.get(0).calculValeur() > liste.get(1).calculValeur() ? 1 : 0;
			}
			case 6: {
				return liste.get(0).calculValeur() < liste.get(1).calculValeur() ? 1 : 0;
			}
			case 7: {
				return liste.get(0).calculValeur() == liste.get(1).calculValeur() ? 1 : 0;
			}
		}
		return 0;
	}

	public long longueurTotalePaquet() {
		if (id() == 4) {
			return 6 + (long) (message().length() * 1.25);
		} else if (idLongueur() == 1) {
			long total = 0;
			for (var p : listeSousPaquets()) {
				total += p.longueurTotalePaquet();
			}
			return 7 + 11 + total;
		} else {
			return 7 + 15 + longueur();
		}
	}

	public long longueur() {
		if (idLongueur() == 1) {
			return MathUtils.binaryToLong(builder.substring(7, 18), 2);
		} else {
			return MathUtils.binaryToLong(builder.substring(7, 22), 2);
		}
	}

	public String message() {
		StringBuilder s = new StringBuilder();
		for (int i = 6; i < builder.size(); i += 5) {
			s.append(builder.substring(i + 1, i + 5));
			if (StringUtils.equals(builder.charAt(i), "0")) {
				break;
			}
		}
		return s.toString();
	}

	public List<Paquet> listeSousPaquets() {
		List<Paquet> liste = new ArrayList<>();
		if (id() == 4) {
			return liste;
		}
		int sousLongueur = idLongueur() == 1 ? 11 : 15;
		int longueurPaquets = 0;
		long longueur = longueur();
		for (int i = 0; idLongueur() == 1 ? i < longueur : longueurPaquets < longueur; i++) {
			Paquet p = new Paquet(new StreamBuilder(builder.substring(7 + sousLongueur)));
			long l = p.longueurTotalePaquet();
			sousLongueur += l;
			longueurPaquets += l;
			liste.add(p);
		}
		return liste;
	}

	public Paquet sousPaquet(int numero) {
		if (id() == 4) {
			return null;
		}
		int sousLongueur = idLongueur() == 1 ? 11 : 15;
		Paquet p = null;
		for (int i = 0; i < numero; i++) {
			p = new Paquet(new StreamBuilder(builder.substring(7 + sousLongueur)));
			sousLongueur += p.longueurTotalePaquet();
		}
		return p;
	}

	public long messageToLong() {
		return MathUtils.binaryToLong(message(), 2);
	}

	public StreamBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(StreamBuilder builder) {
		this.builder = builder;
	}

}
