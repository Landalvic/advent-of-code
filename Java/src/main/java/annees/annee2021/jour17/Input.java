package annees.annee2021.jour17;

import commun.annotation.PatternAttribute;
import commun.annotation.PatternClass;

@PatternClass("^target area: x=(.*)\\.\\.(.*), y=(.*)\\.\\.(.*)$")
public class Input {

	@PatternAttribute(1)
	private Integer xMin;
	@PatternAttribute(2)
	private Integer xMax;
	@PatternAttribute(3)
	private Integer yMin;
	@PatternAttribute(4)
	private Integer yMax;

	public Integer getxMin() {
		return xMin;
	}

	public void setxMin(Integer xMin) {
		this.xMin = xMin;
	}

	public Integer getxMax() {
		return xMax;
	}

	public void setxMax(Integer xMax) {
		this.xMax = xMax;
	}

	public Integer getyMin() {
		return yMin;
	}

	public void setyMin(Integer yMin) {
		this.yMin = yMin;
	}

	public Integer getyMax() {
		return yMax;
	}

	public void setyMax(Integer yMax) {
		this.yMax = yMax;
	}

}
