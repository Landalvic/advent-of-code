package annees.annee2018.jour24;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public enum TypeAttaque {

	FEU("fire"), FROID("cold"), COUPANT("slashing"), CONTONDANT("bludgeoning"), RADIATION("radiation");

	private String id;

	private TypeAttaque(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public static List<TypeAttaque> fromId(String[] ids) {
		List<TypeAttaque> typesAttaque = new ArrayList<>();
		for (String id : ids) {
			typesAttaque.add(fromId(id));
		}
		return typesAttaque;
	}

	public static TypeAttaque fromId(String id) {
		for (TypeAttaque type : TypeAttaque.values()) {
			if (StringUtils.equalsIgnoreCase(id.trim(), type.id)) {
				return type;
			}
		}
		return null;
	}

}
