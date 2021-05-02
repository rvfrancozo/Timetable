package SoftConstraints;
import java.util.ArrayList;
import InstanceLoader.*;
import Population.*;

public class FitnessCalculator {
	
	public int calculator(ArrayList<InstanceModel> timetable) {
		
		SoftConstraints sf1 = new ModuleTimeLimit();
		SoftConstraints sf2 = new AvoidIdleModules();
		SoftConstraints terminator = new NoConstraint();
		
		sf1.setNext(terminator);
		//sf2.setNext(terminator);
		
		return sf1.calculator(timetable);
		
	}

}
