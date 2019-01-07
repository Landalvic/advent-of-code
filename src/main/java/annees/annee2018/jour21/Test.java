package annees.annee2018.jour21;

import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		long[] test = { 65536, 5844974, 256 };
		Set<Long> liste = new TreeSet<>();
		int nbrEntre = 0;
		long nombre = 0;
		long lastNombre = 0;
		while (true) {
			if (test[0] < 256) {
				nbrEntre++;
				lastNombre = nombre;
				nombre = test[1];
				if (liste.contains(test[1])) {
					System.out.println(test[1] + " - " + nbrEntre);
					break;
				}
				liste.add(test[1]);
				test[0] = test[1] | 65536;
				test[1] = 1250634;
				test[2] = test[0] & 255;
				test[1] = test[2] + test[1];
				test[1] = test[1] & 16777215;
				test[1] = test[1] * 65899;
				test[1] = test[1] & 16777215;
				test[2] = (int) (test[0] / 256.);
			} else {
				test[0] = test[2];
				test[2] = test[0] & 255;
				test[1] = test[2] + test[1];
				test[1] = test[1] & 16777215;
				test[1] = test[1] * 65899;
				test[1] = test[1] & 16777215;
				test[2] = (int) (test[0] / 256.);
			}
			// System.out.println(Arrays.toString(test));
		}
		System.out.println(lastNombre);
	}

}
