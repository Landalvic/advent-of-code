package annees.annee2020.jour16;

import java.util.List;

public class Infos {

	private String id;
	private int min1;
	private int max1;
	private int min2;
	private int max2;
	private List<Integer> indexPossibles;

	public List<Integer> getIndexPossibles() {
		return indexPossibles;
	}

	public void setIndexPossibles(List<Integer> possibles) {
		this.indexPossibles = possibles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMin1() {
		return min1;
	}

	public void setMin1(int min1) {
		this.min1 = min1;
	}

	public int getMax1() {
		return max1;
	}

	public void setMax1(int max1) {
		this.max1 = max1;
	}

	public int getMin2() {
		return min2;
	}

	public void setMin2(int min2) {
		this.min2 = min2;
	}

	public int getMax2() {
		return max2;
	}

	public void setMax2(int max2) {
		this.max2 = max2;
	}

}
