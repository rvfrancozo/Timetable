package SoftConstraints;
import java.util.ArrayList;
import InstanceLoader.*;

public class FitnessCalculator {
	
	public int calculator(ArrayList<InstanceModel> timetable) {
		
		SoftConstraints sf1 = new ModuleTimeLimit();
		SoftConstraints sf2 = new SubjectsTeacherLimit();
		SoftConstraints sf3 = new SubjectsClassLimit();
		SoftConstraints terminator = new NoConstraint();
		
		sf1.setNext(sf2);
		sf2.setNext(sf3);
		sf3.setNext(terminator);
		
		return sf1.calculator(timetable);
		
	}

}
