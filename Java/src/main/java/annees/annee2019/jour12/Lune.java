package annees.annee2019.jour12;

import java.util.ArrayList;
import java.util.List;

public class Lune {

	private int x;
	private int y;
	private int z;
	private int vx;
	private int vy;
	private int vz;
	private List<Integer> cycleX = new ArrayList<>();
	private List<Integer> cycleY = new ArrayList<>();
	private List<Integer> cycleZ = new ArrayList<>();
	private boolean finX = false;
	private boolean finY = false;
	private boolean finZ = false;

	public Lune(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.vx = 0;
		this.vy = 0;
		this.vz = 0;
		cycleX.add(x);
		cycleY.add(y);
		cycleZ.add(z);
	}

	public void calculerVitesse(List<Lune> lunes) {
		for (Lune lune : lunes) {
			if (lune != this) {
				if (lune.x > x) {
					vx++;
				} else if (lune.x < x) {
					vx--;
				}
				if (lune.y > y) {
					vy++;
				} else if (lune.y < y) {
					vy--;
				}
				if (lune.z > z) {
					vz++;
				} else if (lune.z < z) {
					vz--;
				}
			}
		}
	}

	public void deplacer() {
		x += vx;
		y += vy;
		z += vz;
		if (!finX) {
			cycleX.add(x);
			finX = verifierCycle(cycleX);
		}
		if (!finY) {
			cycleY.add(y);
			finY = verifierCycle(cycleY);
		}
		if (!finZ) {
			cycleZ.add(z);
			finZ = verifierCycle(cycleZ);
		}
	}

	public boolean fin() {
		return finX && finY && finZ;
	}

	private boolean verifierCycle(List<Integer> cycle) {
		if (cycle.size() % 2 == 0) {
			for (int i = 0; i < cycle.size() / 2; i++) {
				if (cycle.get(i).intValue() != cycle.get((cycle.size() / 2) + i).intValue()) {
					return false;
				}
			}
			int taille = cycle.size() / 2;
			for (int i = 0; i < taille; i++) {
				cycle.remove(0);
			}
			return true;
		}
		return false;
	}

	public int calculerEnergie() {
		return (Math.abs(x) + Math.abs(y) + Math.abs(z)) * (Math.abs(vx) + Math.abs(vy) + Math.abs(vz));
	}

	public List<Integer> getCycleX() {
		return cycleX;
	}

	public void setCycleX(List<Integer> cycleX) {
		this.cycleX = cycleX;
	}

	public List<Integer> getCycleY() {
		return cycleY;
	}

	public void setCycleY(List<Integer> cycleY) {
		this.cycleY = cycleY;
	}

	public List<Integer> getCycleZ() {
		return cycleZ;
	}

	public void setCycleZ(List<Integer> cycleZ) {
		this.cycleZ = cycleZ;
	}

	public boolean isFinX() {
		return finX;
	}

	public void setFinX(boolean finX) {
		this.finX = finX;
	}

	public boolean isFinY() {
		return finY;
	}

	public void setFinY(boolean finY) {
		this.finY = finY;
	}

	public boolean isFinZ() {
		return finZ;
	}

	public void setFinZ(boolean finZ) {
		this.finZ = finZ;
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

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}

	public int getVz() {
		return vz;
	}

	public void setVz(int vz) {
		this.vz = vz;
	}

	@Override
	public String toString() {
		return "Lune [x=" + x + ", y=" + y + ", z=" + z + ", vx=" + vx + ", vy=" + vy + ", vz=" + vz + "]";
	}

}
