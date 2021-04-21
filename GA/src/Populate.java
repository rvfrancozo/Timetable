import java.security.SecureRandom;
import java.util.ArrayList;

public class Populate {
	SecureRandom random = new SecureRandom();

	public Populate() {
		
		ArrayList<InstanceModel> valores = new InstanceControl().loader("instancia.csv");
		
		int i = 0;
		
		System.out.println("Prof.\tDisc.\tM1\tM2\tM3\tM4\tM5");
		
		try {
			
			for(int c = 0; c < valores.size(); c++) {
							
				int[] s = {0,0,0,0,0};
				do {
					int[] m = {0,0,0,0,0};
					
					switch(valores.get(i).getDiv()) {
					case 1:
						int j = random.nextInt(5);
						m[j] = valores.get(i).getCh();
						break;
					case 2:
						j = random.nextInt(4);
						m[j] = m[++j] = valores.get(i).getCh()/valores.get(i).getDiv();
						break;
					case 3:
						j = random.nextInt(3);
						m[j] = m[++j] = m[++j] = valores.get(i).getCh()/valores.get(i).getDiv();
						break;
					case 4:
						j = random.nextInt(2);
						m[j] = m[++j] = m[++j] = m[++j] = valores.get(i).getCh()/valores.get(i).getDiv();
						break;
					default:
						m[0] = m[1] = m[2] = m[3] = m[4] = valores.get(i).getCh()/valores.get(i).getDiv();
						break;
					}
					
					valores.get(i).setModulo(m);
					s[0] += m[0];
					s[1] += m[1];
					s[2] += m[2];
					s[3] += m[3];
					s[4] += m[4];
					System.out.println(valores.get(i).getDocente().substring(0, valores.get(i).getDocente().length() > 6 ? 6 : 
						valores.get(i).getDocente().length()) + "\t" +
					valores.get(i).getDisciplina().substring(0, valores.get(i).getDisciplina().length() > 6 ? 6 : 
						valores.get(i).getDisciplina().length()) + "\t" +
					valores.get(i).getModulo()[0] + "\t" +
					valores.get(i).getModulo()[1] + "\t" +
					valores.get(i).getModulo()[2] + "\t" +
					valores.get(i).getModulo()[3] + "\t" +
					valores.get(i).getModulo()[4] + "\t");
					
					//avalia(valores.get(i).getDocente());
					
					i++;
				} while(valores.get(i-1).getDocente().equals(valores.get(i).getDocente()));
				
				if(s[0] > 80) System.out.print("M1: " + s[0] + "\t");
				if(s[1] > 80) System.out.print("M2: " + s[1] + "\t");
				if(s[2] > 80) System.out.print("M3: " + s[2] + "\t");
				if(s[3] > 80) System.out.print("M4: " + s[3] + "\t");
				if(s[4] > 80) System.out.print("M5: " + s[4] + "\t");
				System.out.println();
			}
			
		} catch(Exception e) {}

	}
	
	public int avalia (String docente) {
		
		return 0;
	}

}
