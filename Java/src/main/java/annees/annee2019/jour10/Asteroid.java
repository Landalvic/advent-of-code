package annees.annee2019.jour10;

import java.util.ArrayList;
import java.util.List;

public class Asteroid implements Comparable<Asteroid> {

	private int x;
	private int y;
	private int x2;
	private int y2;

	public Asteroid(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public int calculerVision(Asteroid[][] asteroids) {
		int calcul = 0;
		for (int i = 0; i < asteroids.length; i++) {
			for (int j = 0; j < asteroids[0].length; j++) {
				if (asteroids[i][j] != null && asteroids[i][j] != this) {
					boolean test = true;
					int newX = asteroids[i][j].x - x;
					int newY = asteroids[i][j].y - y;
					boolean newXPositif = true;
					boolean newYPositif = true;
					if (newX < 0) {
						newXPositif = false;
					}
					if (newY < 0) {
						newYPositif = false;
					}
					a: for (int k = 0; k <= Math.abs(newX); k++) {
						for (int k2 = 0; k2 <= Math.abs(newY); k2++) {
							if ((k != Math.abs(newX) || k2 != Math.abs(newY)) && (k != 0 || k2 != 0)
									&& (newX == 0 || newY == 0 || Math.abs(rapport(newX, k)) == Math.abs(rapport(newY, k2)))) {
								int posX;
								if (newXPositif) {
									posX = x + k;
								} else {
									posX = x - k;
								}
								int posY;
								if (newYPositif) {
									posY = y + k2;
								} else {
									posY = y - k2;
								}
								if (asteroids[posX][posY] != null) {
									test = false;
									break a;
								}
							}
						}
					}
					if (test) {
						calcul++;
					}
				}
			}
		}
		return calcul;
	}

	public List<Asteroid> listeVision(Asteroid[][] asteroids) {
		List<Asteroid> liste = new ArrayList<>();
		for (int i = 0; i < asteroids.length; i++) {
			for (int j = 0; j < asteroids[0].length; j++) {
				if (asteroids[i][j] != null && asteroids[i][j] != this) {
					boolean test = true;
					int newX = asteroids[i][j].x - x;
					int newY = asteroids[i][j].y - y;
					boolean newXPositif = true;
					boolean newYPositif = true;
					if (newX < 0) {
						newXPositif = false;
					}
					if (newY < 0) {
						newYPositif = false;
					}
					a: for (int k = 0; k <= Math.abs(newX); k++) {
						for (int k2 = 0; k2 <= Math.abs(newY); k2++) {
							if ((k != Math.abs(newX) || k2 != Math.abs(newY)) && (k != 0 || k2 != 0)
									&& (newX == 0 || newY == 0 || Math.abs(rapport(newX, k)) == Math.abs(rapport(newY, k2)))) {
								int posX;
								if (newXPositif) {
									posX = x + k;
								} else {
									posX = x - k;
								}
								int posY;
								if (newYPositif) {
									posY = y + k2;
								} else {
									posY = y - k2;
								}
								if (asteroids[posX][posY] != null) {
									test = false;
									break a;
								}
							}
						}
					}
					if (test) {
						liste.add(asteroids[i][j]);
					}
				}
			}
		}
		return liste;
	}

	private static double rapport(int a, int b) {
		return ((double) a) / b;
	}

	public double angle() {
		var angle = Math.atan2(-y2, x2) * (180 / Math.PI);
		angle = (angle + 270) % 360;
		if (angle == 0) {
			angle = 360;
		}
		return angle;
	}

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
	public String toString() {
		return "Asteroid [x=" + x + ", y=" + y + "]" + angle();
	}

	@Override
	public int compareTo(Asteroid o) {
		return -Double.compare(angle(), o.angle());
	}

}
