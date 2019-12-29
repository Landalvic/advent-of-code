package annees.annee2019.jour10;

import java.util.List;
import java.util.stream.Collectors;

import commun.Position;

public class Asteroid {

	private Position position;
	private Integer vision;

	public Asteroid(Position position) {
		super();
		this.position = position;
		vision = null;
	}

	public int calculerVision(List<Asteroid> asteroids) {
		if (vision == null) {
			vision = asteroids.stream().map(asteroid -> asteroid.angle(this)).collect(Collectors.toSet()).size();
		}
		return vision;
	}

	public List<Asteroid> listeVision(List<Asteroid> asteroids) {
		return asteroids.stream().filter(asteroid -> asteroid != this && !asteroid.vuBloquee(asteroids, this)).collect(Collectors.toList());
	}

	private boolean vuBloquee(List<Asteroid> asteroids, Asteroid centre) {
		return asteroids.stream().anyMatch(asteroid -> asteroid != this && asteroid != centre && angle(centre) == asteroid.angle(centre)
				&& asteroid.getPosition().distance(centre.getPosition()) < position.distance(centre.getPosition()));
	}

	public double angle(Asteroid centre) {
		var angle = Math.atan2(-(position.getY() - centre.position.getY()), position.getX() - centre.position.getX()) * (180 / Math.PI);
		angle = (angle + 270) % 360;
		if (angle == 0) {
			angle = 360;
		}
		return angle;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Integer getVision() {
		return vision;
	}

	public void setVision(Integer vision) {
		this.vision = vision;
	}

}
