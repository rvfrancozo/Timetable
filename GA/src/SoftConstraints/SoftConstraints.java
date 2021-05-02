package SoftConstraints;
import java.util.ArrayList;
import InstanceLoader.*;
import Population.*;

public interface SoftConstraints {
	
	int calculator(ArrayList<InstanceModel> timetable);
	void setNext(SoftConstraints next);

}