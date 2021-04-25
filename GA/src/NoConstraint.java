import java.util.ArrayList;

public class NoConstraint implements SoftConstraints {

	@Override
	public int calculator(ArrayList<InstanceModel> timetable) {
		return 0;
	}

	@Override
	public void setNext(SoftConstraints next) {
		
	}

}
