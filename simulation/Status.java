package simulation;

import java.util.HashMap;

public enum Status {
	CROSSED,
	WAITING;

	private static HashMap<String, Status> mapping = new HashMap<String, Status>() {{
		put("Crossed", CROSSED);
		put("Waiting", WAITING);
	}};

	public static Status fromString(String str) {
		return mapping.get(str);
	}
}
