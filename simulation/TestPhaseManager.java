package simulation;

public class TestPhaseManager extends APhaseManager {

	private int counter = 0;

	@Override
	public void addVehicle(Vehicle vehicle) {
		this.phases.get(counter).addVehicle(vehicle);
		counter = (counter + 1) % 6;
	}

}