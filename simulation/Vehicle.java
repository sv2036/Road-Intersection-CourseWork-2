package simulation;

public class Vehicle {

	private Segment segment;
	private String plate;
	private String type;
	private int crossingTime;
	private Direction direction;
	private Status crossedStatus;
	private int length;
	private int emission;
	
	public Vehicle(String plate, String type, int crossingTime, Direction direction, int length, int emission, Status crossedStatus, Segment segment) {
		this.plate = plate;
		this.type = type;
		this.crossingTime = crossingTime;
		this.direction = direction;
		this.length = length;
		this.emission = emission;
		this.crossedStatus = crossedStatus;
		this.segment = segment;
	}

	public Segment getSegment() {
		return segment;
	}

	public String getPlate() {
		return plate;
	}

	public String getType() {
		return type;
	}

	public int getCrossingTime() {
		return crossingTime;
	}

	public Direction getDirection() {
		return direction;
	}

	public Status isCrossedStatus() {
		return crossedStatus;
	}

	public int getLength() {
		return length;
	}

	public int getEmission() {
		return emission;
	}
}