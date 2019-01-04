package annee.annee2018.jour4;

public class Ligne implements Comparable<Ligne> {

	private String date;
	private int minute;
	private String texte;
	private Integer idGarde;

	public Ligne(String date, int minute, String texte, Integer idGarde) {
		super();
		this.date = date;
		this.minute = minute;
		this.texte = texte;
		this.idGarde = idGarde;
	}

	public Integer getIdGarde() {
		return idGarde;
	}

	public void setIdGarde(Integer idGarde) {
		this.idGarde = idGarde;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	@Override
	public int compareTo(Ligne o) {
		return date.compareTo(o.date);
	}

}
