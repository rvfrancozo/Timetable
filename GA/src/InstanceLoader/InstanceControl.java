package InstanceLoader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class InstanceControl {
	
	private static Scanner input;
	private static ArrayList<InstanceModel> valores = new ArrayList<InstanceModel>();
	
	public ArrayList<InstanceModel> loader(String file) {
		
		try {
			
			input = new Scanner(Paths.get(file));
			
			input.nextLine();
			
			while(input.hasNext()) {
				String[] data = input.nextLine().split(";");
				InstanceModel dados = new InstanceModel();
				
				dados.setDisciplina(data[0]);
				dados.setDocente(data[1]);
				dados.setCh(Integer.parseInt(data[2]));
				dados.setDiv(Integer.parseInt(data[3]));
				dados.setTurma(data[4]);
				dados.setArea(data[5]);
				
				valores.add(dados);
				
			}
			
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return valores;
		
	}

}
