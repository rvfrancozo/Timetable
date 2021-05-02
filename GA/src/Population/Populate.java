package Population;
import java.security.SecureRandom;
import java.util.ArrayList;
import InstanceLoader.*;
import SoftConstraints.*;

public class Populate {
	SecureRandom random = new SecureRandom();

	public ArrayList<InstanceModel> Populate(ArrayList<InstanceModel> valores) {

		int i = 0;

		try {

			for (int c = 0; c < valores.size(); c++) {
				do {
					int[] m = { 0, 0, 0, 0, 0 };

					switch (valores.get(i).getDiv()) {
					case 1:
						int j = random.nextInt(5);
						m[j] = valores.get(i).getCh();
						break;
					case 2:
						j = random.nextInt(4);
						m[j] = m[++j] = valores.get(i).getCh() / valores.get(i).getDiv();
						break;
					case 3:
						j = random.nextInt(3);
						m[j] = m[++j] = m[++j] = valores.get(i).getCh() / valores.get(i).getDiv();
						break;
					case 4:
						j = random.nextInt(2);
						m[j] = m[++j] = m[++j] = m[++j] = valores.get(i).getCh() / valores.get(i).getDiv();
						break;
					default:
						m[0] = m[1] = m[2] = m[3] = m[4] = valores.get(i).getCh() / valores.get(i).getDiv();
						break;
					}

					valores.get(i).setModulo(m);
					

					i++;
				} while (valores.get(i - 1).getDocente().equals(valores.get(i).getDocente()));
			}

		} catch (Exception e) {
		}
		
		//print(valores);
		
		return valores;
	}

	private void print(ArrayList<InstanceModel> valores) {
		try {
			System.out.println("Prof.\tDisc.\tM1\tM2\tM3\tM4\tM5");
			for (InstanceModel m : valores) {
				System.out.println(
						m.getDocente().substring(0, m.getDocente().length() > 6 ? 6 : m.getDocente().length()) + "\t"
						+ m.getDisciplina().substring(0, m.getDisciplina().length() > 6 ? 6 : m.getDisciplina().length())
						+ "\t" + m.getModulo()[0] 
					    + "\t" + m.getModulo()[1] 
					    + "\t" + m.getModulo()[2] 
					    + "\t" + m.getModulo()[3] 
					    + "\t" + m.getModulo()[4] + "\t");
			}
		} catch(Exception e) {}
		
	}
}
