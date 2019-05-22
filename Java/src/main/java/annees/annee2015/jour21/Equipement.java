package annees.annee2015.jour21;

public class Equipement {

	private Arme arme;
	private Armure armure;
	private Anneau anneau1;
	private Anneau anneau2;

	public void equiper(Item item, int manque) {
		if (item instanceof Arme) {
			arme = (Arme) item;
		} else if (item instanceof Armure) {
			armure = (Armure) item;
		} else if (item instanceof Anneau) {
			equiperAnneau((Anneau) item, manque);
		}
	}

	public int cout() {
		int cout = 0;
		if (arme != null) {
			cout += arme.getCout();
		}
		if (armure != null) {
			cout += armure.getCout();
		}
		if (anneau1 != null) {
			cout += anneau1.getCout();
		}
		if (anneau2 != null) {
			cout += anneau2.getCout();
		}
		return cout;
	}

	public int getDegats() {
		int degats = 0;
		if (arme != null) {
			degats += arme.getDommages();
		}
		if (armure != null) {
			degats += armure.getDommages();
		}
		if (anneau1 != null) {
			degats += anneau1.getDommages();
		}
		if (anneau2 != null) {
			degats += anneau2.getDommages();
		}
		return degats;
	}

	public int getMontantArmure() {
		int montantArmure = 0;
		if (arme != null) {
			montantArmure += arme.getArmure();
		}
		if (armure != null) {
			montantArmure += armure.getArmure();
		}
		if (anneau1 != null) {
			montantArmure += anneau1.getArmure();
		}
		if (anneau2 != null) {
			montantArmure += anneau2.getArmure();
		}
		return montantArmure;
	}

	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}

	public Armure getArmure() {
		return armure;
	}

	public void setArmure(Armure armure) {
		this.armure = armure;
	}

	public Anneau getAnneau1() {
		return anneau1;
	}

	public void equiperAnneau(Anneau anneau, int manque) {
		if (anneau1 == null) {
			this.anneau1 = anneau;
		} else if (anneau2 == null) {
			this.anneau2 = anneau;
		} else {
			if (anneau.getDommages() > 0 && anneau1.getDommages() > 0
					|| anneau.getArmure() > 0 && anneau1.getArmure() > 0) {
				if (manque > 1) {
					this.anneau1 = anneau;
				} else {
					this.anneau2 = anneau;
				}
			}
		}
	}

	public void setAnneau1(Anneau anneau1) {
		this.anneau1 = anneau1;
	}

	public Anneau getAnneau2() {
		return anneau2;
	}

	public void setAnneau2(Anneau anneau2) {
		this.anneau2 = anneau2;
	}

}
