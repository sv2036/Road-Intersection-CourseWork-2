package simulation;

import java.util.HashMap;

public enum Segment {
	TOP,
	BOTTOM,
	LEFT,
	RIGHT;

	private static HashMap<String, Segment> mapping = new HashMap<String, Segment>() {{
		put("S1", BOTTOM);
		put("S2", TOP);
		put("S3", LEFT);
		put("S4", RIGHT);
	}};

	public static Segment fromString(String str) {
		return mapping.get(str);
	}
}