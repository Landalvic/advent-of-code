package annees.annee2021.jour05;

import commun.annotation.PatternAttribute;
import commun.annotation.PatternClass;

@PatternClass("^(.*),(.*) -> (.*),(.*)$")
public class InfosVecteur {

	@PatternAttribute(1)
	private Integer x1;
	@PatternAttribute(2)
	private Integer y1;
	@PatternAttribute(3)
	private Integer x2;
	@PatternAttribute(4)
	private Integer y2;

	public Integer getX1() {
		return x1;
	}

	public void setX1(Integer x1) {
		this.x1 = x1;
	}

	public Integer getY1() {
		return y1;
	}

	public void setY1(Integer y1) {
		this.y1 = y1;
	}

	public Integer getX2() {
		return x2;
	}

	public void setX2(Integer x2) {
		this.x2 = x2;
	}

	public Integer getY2() {
		return y2;
	}

	public void setY2(Integer y2) {
		this.y2 = y2;
	}

	@Override
	public String toString() {
		return "InfosVecteur [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + "]";
	}

}
