package SoftConstraints;

import java.util.ArrayList;

import InstanceLoader.InstanceModel;

public class SubjectsClassLimit  implements SoftConstraints {

	private SoftConstraints next;

	@Override
	public int calculator(ArrayList<InstanceModel> timetable) {
		int score = 0;
		return score  + next.calculator(timetable);
	}

	@Override
	public void setNext(SoftConstraints next) {
		this.next = next;		
	}

}
