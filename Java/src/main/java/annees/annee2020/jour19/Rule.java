package annees.annee2020.jour19;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;

public class Rule {

	private Integer id;
	private String value;
	private List<List<Integer>> idRules;

	public Rule() {
		super();
		this.idRules = new ArrayList<>();
	}

	public boolean accepterMessage(Map<Integer, Rule> rules, String message) {
		var index = new AtomicInteger();
		boolean test = accepterMessage(rules, message, index);
		if (test) {
			return index.get() == message.length();
		}
		return false;
	}

	public boolean accepterMessage(Map<Integer, Rule> rules, String message, AtomicInteger index) {
		if (value != null) {
			boolean test = StringUtils.equals(String.valueOf(message.charAt(index.get())), value);
			if (test) {
				index.incrementAndGet();
			}
			return test;
		}
		for (List<Integer> list : idRules) {
			boolean tout = true;
			int memoire = index.get();
			for (int i = 0; i < list.size(); i++) {
				Integer integer = list.get(i);
				if (!rules.get(integer).accepterMessage(rules, message, index)) {
					index.set(memoire);
					tout = false;
					break;
				}
			}
			if (tout) {
				return true;
			}
		}
		return false;
	}

	public List<List<Integer>> getIdRules() {
		return idRules;
	}

	public void setIdRules(List<List<Integer>> idRules) {
		this.idRules = idRules;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
