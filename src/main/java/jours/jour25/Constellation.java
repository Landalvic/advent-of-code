package jours.jour25;

import java.util.ArrayList;
import java.util.List;

public class Constellation {

	private List<PointFixe> points;

	public Constellation(Constellation constellation1, Constellation constellation2) {
		super();
		points = new ArrayList<>(constellation1.points.size() + constellation2.points.size());
		points.addAll(constellation1.points);
		points.addAll(constellation2.points);
	}

	public Constellation() {
		super();
		this.points = new ArrayList<>();
	}

	public List<PointFixe> getPoints() {
		return points;
	}

	public void setPoints(List<PointFixe> points) {
		this.points = points;
	}

}
