package simulation;
import java.util.HashMap;

public class EightPhaseManager extends AVehicleOnlyPhaseManager {

	public EightPhaseManager() {
		for (int i = 0; i < 8; i++)
			phases.add(new Phase());
		for (Segment seg : Segment.values())
			phasesMap.put(seg, new HashMap<Direction, Phase>());
		phasesMap.get(Segment.BOTTOM).put(Direction.PRIORITY, phases.get(0));
		phasesMap.get(Segment.TOP).put(Direction.SECOND, phases.get(1));
		phasesMap.get(Segment.LEFT).put(Direction.PRIORITY, phases.get(2));
		phasesMap.get(Segment.RIGHT).put(Direction.SECOND, phases.get(3));
		phasesMap.get(Segment.TOP).put(Direction.PRIORITY, phases.get(4));
		phasesMap.get(Segment.BOTTOM).put(Direction.SECOND, phases.get(5));
		phasesMap.get(Segment.RIGHT).put(Direction.PRIORITY, phases.get(6));
		phasesMap.get(Segment.LEFT).put(Direction.SECOND, phases.get(7));
	}
}
