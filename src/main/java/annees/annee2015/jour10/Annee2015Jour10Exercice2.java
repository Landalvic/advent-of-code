package annees.annee2015.jour10;

public class Annee2015Jour10Exercice2 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour10Exercice2();
	}

	@Override
	public void run() {
		String input = "1321131112";

		for (int iteration = 0; iteration < 50; iteration++) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				int nbr = 1;
				for (int j = i + 1; j < input.length(); j++) {
					if (c == input.charAt(j)) {
						nbr++;
					} else {
						break;
					}
				}
				builder.append(nbr + "" + c);
				i += nbr - 1;
			}
			input = builder.toString();
		}
		System.out.println(input.length());
	}

}
