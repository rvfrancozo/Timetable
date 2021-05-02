package SoftConstraints;
import java.util.ArrayList;
import InstanceLoader.*;

public interface SoftConstraints {
	
	int calculator(ArrayList<InstanceModel> timetable);
	void setNext(SoftConstraints next);

}