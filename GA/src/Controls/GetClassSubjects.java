package Controls;

import java.util.ArrayList;

import InstanceLoader.InstanceModel;
import Models.Entities;

public class GetClassSubjects {
	
	public ArrayList<Entities> summary(ArrayList<InstanceModel> timetable) {
		ArrayList<Entities> t = new ArrayList<Entities>();
		ArrayList<String> names = new ArrayList<String>();
		Entities tmp = new Entities();
		int count = 0;
		
		for(InstanceModel n : timetable) {
			if(!names.contains(n.getTurma()))
				names.add(n.getTurma());
		}
		
		for(String n : names) {
			for(InstanceModel m : timetable) {
				if(n.equals(m.getTurma())) {
					count += m.getDiv(); 
				}
			}
			tmp.setName(n);
			tmp.setTotalOfSubjects(count);
			t.add(tmp);
			count = 0;
		}
		
		return t;
	}

}
