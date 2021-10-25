package Controls;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

import InstanceLoader.InstanceModel;

public class SaveSolution {
	
	private static Formatter output;

	public SaveSolution(ArrayList<InstanceModel> best, String file) {
		
		try {
			output = new Formatter(file);
			output.format("%s", "Prof.;Disc.;Curso;Turma;M1;M2;M3;M4;M5\n");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(InstanceModel data : best) {
			
			output.format("%s;%s;%s;%s;%d;%d;%d;%d;%d;%d\n", 
					data.getDocente(),
					data.getArea(),
					data.getDisciplina(),
					data.getTurma(),
					data.getCh(),
					data.getModulo()[0],
					data.getModulo()[1],
					data.getModulo()[2],
					data.getModulo()[3],
					data.getModulo()[4]);
		}
		if(output != null)
			output.close();
	}

}
