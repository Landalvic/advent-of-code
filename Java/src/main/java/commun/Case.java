package commun;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Case<T extends Case<T>> {

	private static final String AFFICHAGE = ".";

	protected Position position;
	protected MapCases<T> map;
	protected String id;
	protected boolean mur;

	protected Case(MapCases<T> map, Position position) {
		super();
		this.map = map;
		this.position = position;
		mur = false;
	}

	protected Case(MapCases<T> map, Position position, String id) {
		super();
		this.map = map;
		this.position = position;
		this.id = id;
		mur = false;
	}

	public abstract T getThis();

	public boolean isMur() {
		return mur;
	}

	public void setMur(boolean mur) {
		this.mur = mur;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String afficher() {
		return AFFICHAGE;
	}

	public T bougerOuRester(Direction direction) {
		T bouger = bouger(direction);
		return bouger == null ? getThis() : bouger;
	}

	public T bouger(Direction direction) {
		switch (direction) {
			case HAUT:
				return map.getCase(position.getX(), position.getY() - 1);
			case BAS:
				return map.getCase(position.getX(), position.getY() + 1);
			case GAUCHE:
				return map.getCase(position.getX() - 1, position.getY());
			case DROITE:
				return map.getCase(position.getX() + 1, position.getY());
			case HAUT_GAUCHE:
				return map.getCase(position.getX() - 1, position.getY() - 1);
			case HAUT_DROITE:
				return map.getCase(position.getX() + 1, position.getY() - 1);
			case BAS_GAUCHE:
				return map.getCase(position.getX() - 1, position.getY() + 1);
			case BAS_DROITE:
				return map.getCase(position.getX() + 1, position.getY() + 1);
			default:
				return null;
		}
	}

	public Set<T> getCasesAdjacentesNew() {
		Set<T> cases = new HashSet<>();
		for (int i = 0; i < position.getCoordonnees().length; i++) {
			Position p = new Position(position);
			p.getCoordonnees()[i] += 1;
			cases.add(map.getCase(p));
			p.getCoordonnees()[i] -= 2;
			cases.add(map.getCase(p));
		}
		return cases;
	}

	public Set<T> getCasesAdjacentesDiagNDim() {
		return getCasesAdjacentesDiagNDim(null);
	}

	public Set<T> getCasesAdjacentesDiagNDim(Function<Position, T> creation) {
		Set<Position> positions = new HashSet<>();
		positions.add(position);
		for (int i = 0; i < position.getCoordonnees().length; i++) {
			Set<Position> newPositions = new HashSet<>();
			for (int j = -1; j <= 1; j++) {
				for (Position p1 : positions) {
					Position p = new Position(p1);
					p.getCoordonnees()[i] += j;
					newPositions.add(p);
				}
			}
			positions.clear();
			positions.addAll(newPositions);
		}
		positions.remove(position);
		return positions.stream().map(p -> map.getOrAddCase(p, creation)).filter(Objects::nonNull).collect(Collectors.toSet());
	}

	public List<T> getCasesAdjacentes() {
		List<T> cases = new ArrayList<>();
		for (Direction direction : Direction.listeAxes()) {
			T c = bouger(direction);
			if (c != null) {
				cases.add(c);
			}
		}
		return cases;
	}

	public List<T> getCasesAdjacentesDiag() {
		List<T> cases = new ArrayList<>();
		for (Direction direction : Direction.liste8Directions()) {
			T c = bouger(direction);
			if (c != null) {
				cases.add(c);
			}
		}
		return cases;
	}

	public List<T> deplacement(T destination) {
		List<List<T>> chemins = new ArrayList<>();
		List<T> cheminDepart = new ArrayList<>();
		cheminDepart.add(getThis());
		chemins.add(cheminDepart);

		List<List<T>> bonChemin = new ArrayList<>();
		boolean trouve = false;
		while (!trouve && !chemins.isEmpty()) {
			List<List<T>> newChemins = new ArrayList<>();
			for (List<T> chemin : chemins) {
				for (T case1 : chemin.get(chemin.size() - 1).getCasesAdjacentes()) {
					if (destination == case1) {
						List<T> newChemin = new ArrayList<>(chemin);
						newChemin.add(case1);
						bonChemin.add(newChemin);
						trouve = true;
					} else if (!case1.isMur() && !chemin.contains(case1)) {
						boolean cheminInutile = false;
						for (T adj : case1.getCasesAdjacentes()) {
							if (adj != chemin.get(chemin.size() - 1) && chemin.contains(adj)) {
								cheminInutile = true;
								break;
							}
						}
						if (!cheminInutile) {
							for (List<T> cheminAutre : chemins) {
								if (cheminAutre.contains(case1)) {
									cheminInutile = true;
									break;
								}
							}
						}
						if (!cheminInutile) {
							for (List<T> cheminAutre : newChemins) {
								if (cheminAutre.get(cheminAutre.size() - 1) == case1) {
									cheminInutile = true;
									break;
								}
							}
						}
						if (!cheminInutile) {
							List<T> newChemin = new ArrayList<>(chemin);
							newChemin.add(case1);
							newChemins.add(newChemin);
						}
					}
				}
			}
			chemins = newChemins;
		}
		if (trouve) {
			return bonChemin.get(0);
		}
		return null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Case<?> other = (Case<?>) obj;
		return Objects.equals(position, other.position);
	}

	@Override
	public String toString() {
		return "Case [position=" + position + "]";
	}

}
