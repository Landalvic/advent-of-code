package annees.annee2018.jour4;

public class Garde {

	private int id;
	private int[] sommeil = new int[60];

	public Garde(int id) {
		super();
		this.id = id;
	}

	public int[] getSommeil() {
		return sommeil;
	}

	public void setSommeil(int[] sommeil) {
		this.sommeil = sommeil;
	}

	public void dormir(int minuteDepart, int minuteArrivee) {
		for (int i = minuteDepart; i < minuteArrivee; i++) {
			sommeil[i]++;
		}
	}

	public int totalSommeil() {
		int total = 0;
		for (int i : sommeil) {
			total += i;
		}
		return total;
	}

	public int minuteLaPire() {
		int plusGrand = 0;
		int pireMinute = -1;
		for (int i = 0; i < sommeil.length; i++) {
			if (sommeil[i] > plusGrand) {
				plusGrand = sommeil[i];
				pireMinute = i;
			}
		}
		return pireMinute;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
