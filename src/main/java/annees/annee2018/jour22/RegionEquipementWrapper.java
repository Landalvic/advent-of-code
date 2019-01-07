package annees.annee2018.jour22;

public class RegionEquipementWrapper {

	private Region region;
	private Equipement equipement;
	private int minute;

	public RegionEquipementWrapper(Region region, Equipement equipement, int minute) {
		super();
		this.region = region;
		this.equipement = equipement;
		this.minute = minute;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Equipement getEquipement() {
		return equipement;
	}

	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}

}
