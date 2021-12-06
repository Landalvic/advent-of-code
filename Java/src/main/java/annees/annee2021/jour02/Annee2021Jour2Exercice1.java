package annees.annee2021.jour02;

import commun.Position;
import commun.structure.AdventOfCodeException;

public class Annee2021Jour2Exercice1 extends Annee2021Jour2 {

	public static void main(String[] args) {
		new Annee2021Jour2Exercice1().lancer(true);
	}

	public Annee2021Jour2Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var commandes = inputToStreamObject(input);
		Position position = new Position(0, 0);
		commandes.forEach(commande -> {
			switch (commande.getDirection()) {
				case "forward":
					position.addX(commande.getNombre());
					break;
				case "down":
					position.addY(commande.getNombre());
					break;
				case "up":
					position.addY(-commande.getNombre());
					break;
				default:
					break;
			}
		});
		return String.valueOf((long) (position.getX() * position.getY()));
	}

}
