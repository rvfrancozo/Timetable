package SoftConstraints;
import java.util.ArrayList;
import InstanceLoader.*;

public class ModuleTimeLimit implements SoftConstraints {

	private SoftConstraints next;
	private int score = 0;

	@Override
	public int calculator(ArrayList<InstanceModel> timetable) {

		
		int[] s = {0,0,0,0,0};
		String docente = null;

		for(InstanceModel m : timetable) {
			
			if(m.getDocente().equals(docente)) {
				for(int i = 0; i <= 4; i++) s[i] += m.getModulo()[i];
			}
			
			else {
				docente = m.getDocente();
				for(int i = 0; i <= 4; i++) {
					if(s[i] > 80)
						score = score + (s[i]-80);
						//score++;
				} 
				for(int i = 0; i <= 4; i++) s[i] = 0;
				for(int i = 0; i <= 4; i++) s[i] = m.getModulo()[i];
			}
		}
		
		return score + next.calculator(timetable);
		
	}

	@Override
	public void setNext(SoftConstraints next) {
		this.next = next;

	}

}
