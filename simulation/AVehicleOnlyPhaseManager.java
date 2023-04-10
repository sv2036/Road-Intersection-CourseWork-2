package simulation;
import java.util.HashMap;

public abstract class AVehicleOnlyPhaseManager extends APhaseManager {

	protected HashMap<Segment, HashMap<Direction, Phase>> phasesMap = new HashMap<Segment, HashMap<Direction, Phase>>();

	public void addVehicle(Vehicle vehicle) {
		phasesMap.get(vehicle.getSegment()).get(vehicle.getDirection()).addVehicle(vehicle);
	}
}

