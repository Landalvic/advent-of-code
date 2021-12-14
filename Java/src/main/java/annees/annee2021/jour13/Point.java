package annees.annee2021.jour13;

import java.util.Set;

import commun.Position;
import commun.annotation.PatternAttribute;
import commun.annotation.PatternClass;

@PatternClass("^(.*),(.*)$")
public class Point extends Input {

	@PatternAttribute(1)
	private Integer x;
	@PatternAttribute(2)
	private Integer y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public Set<Position> run(Set<Position> positions) {
		positions.add(new Position(x, y));
		return positions;
	}

}
