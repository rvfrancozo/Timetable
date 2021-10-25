package SoftConstraints;
import java.util.ArrayList;

import Controls.GetTeachersSubjects;
import InstanceLoader.*;
import Models.Entities;

public class SubjectsTeacherLimit implements SoftConstraints {
	
	private SoftConstraints next;
	
	@Override
	public int calculator(ArrayList<InstanceModel> timetable) {
		
		ArrayList<Entities> t = new GetTeachersSubjects().summary(timetable);
		int[] s = { 0, 0, 0, 0, 0 };
		int score = 0;
		
		for(Entities n : t) {
			for(InstanceModel m : timetable) {
				if(n.getName().equals(m.getDocente())) {
					for(int i = 0; i < 5; i++) {
						if(m.getModulo()[i] > 0) s[i] = s[i]+1;
					}
				}
			}
			
			for(int i = 0; i < 5; i++) {
				if(s[i] > n.getTotalOfSubjects() * 0.3 ) {
					score += s[i]*10;
					//score++;
				}
			}
			for(int i = 0; i < 5; i++) s[i] = 0;
			
		}
	
		
		return score + next.calculator(timetable);
	}

	@Override
	public void setNext(SoftConstraints next) {
		this.next = next;
		
	}

}
