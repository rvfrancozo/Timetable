import java.util.ArrayList;

public interface SoftConstraints {
	
	int calculator(ArrayList<InstanceModel> timetable);
	void setNext(SoftConstraints next);

}