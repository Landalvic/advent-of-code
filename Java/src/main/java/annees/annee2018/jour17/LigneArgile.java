package annees.annee2018.jour17;

public class LigneArgile {

	private int startX;
	private int endX;
	private int startY;
	private int endY;

	public LigneArgile(int startX, int endX, int startY, int endY) {
		super();
		this.startX = startX;
		this.endX = endX;
		this.startY = startY;
		this.endY = endY;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getEndX() {
		return endX;
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public int getEndY() {
		return endY;
	}

	public void setEndY(int endY) {
		this.endY = endY;
	}

	@Override
	public String toString() {
		return "LigneArgile [startX=" + startX + ", endX=" + endX + ", startY=" + startY + ", endY=" + endY + "]";
	}

}
