package simulation;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class VehicleParser {
	
	private VehicleParser() {};

	public static List<Vehicle> parseVehiclesFile(String path) {
		List<Vehicle> vehicleList = new ArrayList<>();
		String file = (path);
		Path pathToFile = Paths.get(file);

		try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
			// skip the first line in CSV file as it has attribute names
			br.readLine();

			String row = br.readLine();
			while (row != null) {
				String[] attributes = row.split(",");
				if (attributes.length != 8) {
					System.err.println("Error : Incorrect number of values in row :" + row);

				} else {
					try {
						Vehicle vehicle = parseVehicleAttributes(attributes);
						vehicleList.add(vehicle);
					} catch (NumberFormatException e) {
						System.err.println("Error : Could not parse integer value in row" + row);
						e.printStackTrace();
					}
				}
				row = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return vehicleList;
	}

	public static Vehicle parseVehicleAttributes(String[] attributes) {
		// put attributes from CSV file into Vehicle class in correct order
		String vehicleNumber = attributes[0];// Strings do not need parse function
		String vehicleType = attributes[1];
		int vehicleCrossingTime = Integer.parseInt(attributes[2]);
		Direction vehicleDirection = Direction.fromString(attributes[3]);
		int vehicleLength = Integer.parseInt(attributes[4]);
		int vehicleEmission = Integer.parseInt(attributes[5]);
		Status vehicleStatus = Status.fromString(attributes[6]);
		Segment vehicleSegment = Segment.fromString(attributes[7]);

		return new Vehicle(vehicleNumber, vehicleType, vehicleCrossingTime, vehicleDirection, vehicleLength,
				vehicleEmission, vehicleStatus, vehicleSegment);
	}
}