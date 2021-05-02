package Controls;

import java.util.ArrayList;

import InstanceLoader.InstanceModel;
import SoftConstraints.FitnessCalculator;

public class GetBestSolution {
	int tmp = Integer.MAX_VALUE;

	public ArrayList<InstanceModel> getSolution(ArrayList<ArrayList<InstanceModel>> pop) {
		ArrayList<InstanceModel> best = new ArrayList<InstanceModel>();
		for(ArrayList<InstanceModel> n : pop) {
			int score = new FitnessCalculator().calculator(n);
			if(score < tmp)
				best = n;
		}
		
		return best;
	}

}
