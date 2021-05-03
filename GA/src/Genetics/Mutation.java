package Genetics;

import java.security.SecureRandom;
import java.util.ArrayList;

import InstanceLoader.InstanceModel;
import SoftConstraints.FitnessCalculator;

public class Mutation {
	SecureRandom random = new SecureRandom();

	public ArrayList<InstanceModel> cross(ArrayList<InstanceModel> cross) {
		
		int score = new FitnessCalculator().calculator(cross);
		
		do {
			int i = random.nextInt(cross.size());
			int[] m = { 0, 0, 0, 0, 0 };
			
			switch (cross.get(i).getDiv()) {
			case 1:
				int j = random.nextInt(5);
				m[j] = cross.get(i).getCh();
				break;
			case 2:
				j = random.nextInt(4);
				m[j] = m[++j] = cross.get(i).getCh() / cross.get(i).getDiv();
				break;
			case 3:
				j = random.nextInt(3);
				m[j] = m[++j] = m[++j] = cross.get(i).getCh() / cross.get(i).getDiv();
				break;
			case 4:
				j = random.nextInt(2);
				m[j] = m[++j] = m[++j] = m[++j] = cross.get(i).getCh() / cross.get(i).getDiv();
				break;
			default:
				m[0] = m[1] = m[2] = m[3] = m[4] = cross.get(i).getCh() / cross.get(i).getDiv();
				break;
			}
			cross.get(i).setModulo(m);
		} while(new FitnessCalculator().calculator(cross) >= score);
		
		

		//System.out.println(docente + " ScOre: " + score);
		return cross;
	}
}