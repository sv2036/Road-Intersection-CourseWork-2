package simulation;

import java.util.HashMap;

public enum Direction {
	PRIORITY,
	SECOND;
	
	private static HashMap<String, Direction> mapping = new HashMap<String, Direction>() {{
		put("Left", PRIORITY);
		put("Right", SECOND);
		put("Straight", SECOND);
	}};

	public static Direction fromString(String str) {
		return mapping.get(str);
	}
}