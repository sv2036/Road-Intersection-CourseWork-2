package simulation;
import java.util.ArrayList;
import java.util.List;

public class Phase {

	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private int crossTime = 10;
	private int vehicleCrossed = 0;

	void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}

	List<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public int getCrossTime() {
		return crossTime;
	}

	public void setCrossTime(int duration) {
		this.crossTime = duration;
	}
}