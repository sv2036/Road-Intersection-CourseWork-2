package simulation;
import java.util.ArrayList;
import java.util.List;

public abstract class APhaseManager {
	
	protected List<Phase> phases = new ArrayList<Phase>();

	public abstract void addVehicle(Vehicle vehicle);

	public List<Phase> getPhases() {
		return phases;
	}
}