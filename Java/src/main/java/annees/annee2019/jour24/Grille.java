package annees.annee2019.jour24;

public class Grille extends Case {

	private Case[][] map;
	private Grille parent;
	private Grille enfant;
	private int position;

	public Grille() {
		super(2, 2);
		map = new Case[5][5];
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 5; i++) {
				Case c = new Case(i, j);
				map[j][i] = c;
				if (i > 0) {
					c.setOuest(map[j][i - 1]);
				}
				if (j > 0) {
					c.setNord(map[j - 1][i]);
				}
			}
		}
	}

	public Grille ajouterGrille() {
		boolean insecte = false;
		a: for (int i = 0; i < getMap().length; i++) {
			for (int j = 0; j < getMap()[i].length; j++) {
				if (!map[i][j].isGrille() && map[i][j].isInsecte()) {
					insecte = true;
					break a;
				}
			}
		}
		if (insecte) {
			if (parent == null) {
				return ajouterGrilleExterieur();
			}
			if (enfant == null) {
				return ajouterGrilleCentrale();
			}
		}
		return null;
	}

	public Grille ajouterGrilleCentrale() {
		Grille grille = new Grille();
		map[2][2] = grille;
		grille.parent = this;
		enfant = grille;
		grille.position = position - 1;
		for (int i = 0; i < map.length; i++) {
			grille.map[i][0].getCasesAdjacentes().add(map[2][1]);
			map[2][1].getCasesAdjacentes().add(grille.map[i][0]);
		}
		for (int i = 0; i < map.length; i++) {
			grille.map[i][4].getCasesAdjacentes().add(map[2][3]);
			map[2][3].getCasesAdjacentes().add(grille.map[i][4]);
		}
		for (int i = 0; i < map[0].length; i++) {
			grille.map[0][i].getCasesAdjacentes().add(map[1][2]);
			map[1][2].getCasesAdjacentes().add(grille.map[0][i]);
		}
		for (int i = 0; i < map[0].length; i++) {
			grille.map[4][i].getCasesAdjacentes().add(map[3][2]);
			map[3][2].getCasesAdjacentes().add(grille.map[4][i]);
		}
		return grille;
	}

	public Grille ajouterGrilleExterieur() {
		Grille grille = new Grille();
		parent = grille;
		grille.enfant = this;
		grille.map[2][2] = this;
		grille.position = position + 1;
		for (int i = 0; i < map.length; i++) {
			map[i][0].getCasesAdjacentes().add(grille.map[2][1]);
			grille.map[2][1].getCasesAdjacentes().add(map[i][0]);
		}
		for (int i = 0; i < map.length; i++) {
			map[i][4].getCasesAdjacentes().add(grille.map[2][3]);
			grille.map[2][3].getCasesAdjacentes().add(map[i][4]);
		}
		for (int i = 0; i < map[0].length; i++) {
			map[0][i].getCasesAdjacentes().add(grille.map[1][2]);
			grille.map[1][2].getCasesAdjacentes().add(map[0][i]);
		}
		for (int i = 0; i < map[0].length; i++) {
			map[4][i].getCasesAdjacentes().add(grille.map[3][2]);
			grille.map[3][2].getCasesAdjacentes().add(map[4][i]);
		}
		return grille;
	}

	public boolean isGrille() {
		return true;
	}

	public Case[][] getMap() {
		return map;
	}

	public void setMap(Case[][] map) {
		this.map = map;
	}

	public void visualiserMap() {
		System.out.println(position);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				Case case1 = map[i][j];
				if (case1.isInsecte()) {
					System.out.print("#");
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	@Override
	public int compareTo(Case o) {
		if (o instanceof Grille) {
			return -Integer.compare(position, ((Grille) o).position);
		}
		return -1;
	}

}
