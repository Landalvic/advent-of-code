package commun.util;

import java.util.ArrayList;
import java.util.List;

public interface ListUtils {

	public static <T> List<T> retainAllNewListe(List<T> listeQuiRetain, List<T> liste2) {
		List<T> newListe = new ArrayList<>(listeQuiRetain);
		newListe.retainAll(liste2);
		return newListe;
	}

	public static <T> List<T> removeAllNewListe(List<T> listeQuiRetain, List<T> liste2) {
		List<T> newListe = new ArrayList<>(listeQuiRetain);
		newListe.removeAll(liste2);
		return newListe;
	}

}
