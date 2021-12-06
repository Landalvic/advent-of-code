package annees.annee2021.jour02;

import commun.Position;
import commun.structure.AdventOfCodeException;

public class Annee2021Jour2Exercice2 extends Annee2021Jour2 {

	public static void main(String[] args) {
		new Annee2021Jour2Exercice2().lancer(true);
	}

	public Annee2021Jour2Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var commandes = inputToStreamObject(input);
		Position position = new Position(0, 0, 0);
		commandes.forEach(commande -> {
			switch (commande.getDirection()) {
				case "forward":
					position.addX(commande.getNombre());
					position.addY(commande.getNombre() * position.getZ());
					break;
				case "down":
					position.addZ(commande.getNombre());
					break;
				case "up":
					position.addZ(-commande.getNombre());
					break;
				default:
					break;
			}
		});
		return String.valueOf((long) (position.getX() * position.getY()));
	}

}
