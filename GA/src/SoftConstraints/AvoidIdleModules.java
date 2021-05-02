package SoftConstraints;
import java.util.ArrayList;
import InstanceLoader.*;
import Population.*;

public class AvoidIdleModules implements SoftConstraints {
	
	private SoftConstraints next;
	
	@Override
	public int calculator(ArrayList<InstanceModel> timetable) {
		
		return next.calculator(timetable);
	}

	@Override
	public void setNext(SoftConstraints next) {
		this.next = next;
		
	}

}
