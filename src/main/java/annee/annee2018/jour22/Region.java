package annee.annee2018.jour22;

import java.util.ArrayList;
import java.util.List;

public class Region {

	private int positionX;
	private int positionY;
	private int indiceGeologique;
	private int niveauErosion;
	private int niveauRisque;
	private List<Region> regionsAdjacentes;

	public Region(int positionX, int positionY, int indiceGeologique, int niveauErosion) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.indiceGeologique = indiceGeologique;
		this.niveauErosion = niveauErosion;
		niveauRisque = niveauErosion % 3;
		regionsAdjacentes = new ArrayList<>(4);
	}

	public List<Region> getRegionsAdjacentes() {
		return regionsAdjacentes;
	}

	public void setRegionsAdjacentes(List<Region> regionsAdjacentes) {
		this.regionsAdjacentes = regionsAdjacentes;
	}

	public int getNiveauRisque() {
		return niveauRisque;
	}

	public void setNiveauRisque(int niveauRisque) {
		this.niveauRisque = niveauRisque;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getIndiceGeologique() {
		return indiceGeologique;
	}

	public void setIndiceGeologique(int indiceGeologique) {
		this.indiceGeologique = indiceGeologique;
	}

	public int getNiveauErosion() {
		return niveauErosion;
	}

	public void setNiveauErosion(int niveauErosion) {
		this.niveauErosion = niveauErosion;
	}

	@Override
	public String toString() {
		return "Region [positionX=" + positionX + ", positionY=" + positionY + "]";
	}

}
