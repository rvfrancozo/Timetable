import java.util.ArrayList;

public class FitnessCalculator {
	
	public int calculator(ArrayList<InstanceModel> timetable) {
		
		SoftConstraints sf1 = new ModuleTimeLimit();
		SoftConstraints sf2 = new NoConstraint();
		
		sf1.setNext(sf2);
		
		return sf1.calculator(timetable);
		
	}

}
