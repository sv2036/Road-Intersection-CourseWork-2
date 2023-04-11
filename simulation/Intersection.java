package simulation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Intersection {

	private APhaseManager phaseManager = new EightPhaseManager();
	private int totalWaitingTime = 0;
	private float totalEmission = 0;
	private int crossedVehicles = 0;
	private int cycleTime = 0;
	private List<Integer> phaseVehicles = new ArrayList<Integer>();

	public void cycle() {
		int phaseIndex = 0;

		for (Phase phase : phaseManager.getPhases()) {
			int timeLeft = phase.getCrossTime();

			phaseVehicles.add(0);
			for (Vehicle vehicle : phase.getVehicles()) {
				if (vehicle.isCrossedStatus() == Status.CROSSED) continue;
				if (timeLeft - vehicle.getCrossingTime() < 0) {
					cycleTime += timeLeft;
					break;
				}

				totalEmission += (float)(vehicle.getCrossingTime() + cycleTime)/60 * vehicle.getEmission();
				totalWaitingTime += cycleTime;
				crossedVehicles++;
				cycleTime += vehicle.getCrossingTime();
				timeLeft -= vehicle.getCrossingTime();
				phaseVehicles.set(phaseIndex, phaseVehicles.get(phaseIndex)+1);
			}
			phaseIndex++;
		}
		generateReport();
	}
	
	private void generateReport() {
        try {
            FileWriter writer = new FileWriter("./report", false);
            writer.write(	"Simulation Report" + "\n"
            		+ 		"Total vehicles crossed: " + crossedVehicles + "\n"
            		+		"Average Waiting Time: " + totalWaitingTime / crossedVehicles + "\n"
            		+ 		"Total Emission generated: " + totalEmission + "\n"
            		+		"Vehicle By Phase: \n");
            for (int i = 0; i < this.phaseVehicles.size(); i++)
            	writer.write("P" + (i + 1) + ": " + this.phaseVehicles.get(i) + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void addVehicle(Vehicle vehicle) {
		phaseManager.addVehicle(vehicle);
	}
	
	public void setPhaseCrossTime(int phase, int duration) {
		this.phaseManager.getPhases().get(phase).setCrossTime(duration);
	}
}