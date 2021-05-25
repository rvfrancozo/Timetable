package Population;

import java.util.ArrayList;

import InstanceLoader.InstanceModel;
import SoftConstraints.FitnessCalculator;

public class UpdatePopulation {
	int tmp = Integer.MAX_VALUE;
	int worst = 0;

	public ArrayList<ArrayList<InstanceModel>> up(ArrayList<ArrayList<InstanceModel>> pop, ArrayList<InstanceModel> cross) {
		
		for(int i = 0; i < pop.size(); i++) {
			int score = new FitnessCalculator().calculator(pop.get(i));
			if(score < tmp) {
				tmp = score;
				worst = i;
			}
		}
		
		pop.add(cross);
		pop.remove(worst);
		
		return pop;
	}

}
