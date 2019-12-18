package annees.annee2019.jour18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Dieu implements Comparable<Dieu> {

	private List<Nous> robots = new ArrayList<Nous>();

	public Dieu() {
		super();
	}

	public Dieu(Dieu dieu, Nous nousExclu) {
		super();
		for (Nous nous : dieu.getRobots()) {
			if (nousExclu != nous) {
				var nouveauNous = new Nous(nous.getEmplacement(), nous.getCles());
				nouveauNous.setDistance(nous.getDistance());
				nouveauNous.setZone(nous.getZone());
				nouveauNous.setLastKey(nous.getLastKey());
				robots.add(nouveauNous);
			}
		}
	}

	public List<Nous> getRobots() {
		return robots;
	}

	public void setRobots(List<Nous> robots) {
		this.robots = robots;
	}

	public boolean avoirCle(String porte) {
		if (porte == null) {
			return true;
		} else {
			for (Nous nous : robots) {
				if (nous.getCles().stream().filter(cle -> StringUtils.equals(cle.getId(), porte.toLowerCase()))
						.findAny().isPresent()) {
					return true;
				}
			}
			return false;
		}
	}

	public int tailleCles() {
		return robots.stream().mapToInt(robot -> robot.getCles().size()).sum();
	}

	public String id() {
		var id = new StringBuilder();
		for (Nous nous : robots) {
			id.append(nous.id());
		}
		return id.toString();
	}

	public String id2() {
		var id = new StringBuilder();
		for (Nous nous : robots) {
			id.append(nous.id2());
		}
		return id.toString();
	}

	public int getDistance() {
		return robots.stream().mapToInt(robot -> robot.getDistance()).sum();
	}

	@Override
	public int compareTo(Dieu o) {
		return id().compareTo(o.id());
	}

	@Override
	public String toString() {
		List<String> cles = new ArrayList<String>();
		for (Nous nous : robots) {
			for (Cle cle : nous.getCles()) {
				cles.add(cle.getId());
			}
		}
		Collections.sort(cles);
		return "Dieu [cles=" + cles + "]" + getDistance() + "-" + id();
	}

}
