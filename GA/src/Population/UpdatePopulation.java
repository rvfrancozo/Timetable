package Population;

import java.security.SecureRandom;
import java.util.ArrayList;

import InstanceLoader.InstanceModel;
import SoftConstraints.FitnessCalculator;

public class UpdatePopulation {
	int tmp = Integer.MAX_VALUE;
	int worst = 0;

	// Adiciona a nova solução no lugar da pior
	public ArrayList<ArrayList<InstanceModel>> up(ArrayList<ArrayList<InstanceModel>> pop,
			ArrayList<InstanceModel> cross) {

		for (int i = 0; i < pop.size(); i++) {
			int score = new FitnessCalculator().calculator(pop.get(i));
			if (score < tmp) {
				tmp = score;
				worst = i;
			}
		}

		pop.remove(worst);
		pop.add(cross);

		return pop;
	}

	// Adiciona a nova solução no lugar de uma qualquer
	public ArrayList<ArrayList<InstanceModel>> randomup(ArrayList<ArrayList<InstanceModel>> pop,
			ArrayList<InstanceModel> cross) {

		for (int i = 0; i < pop.size(); i++) {
			int score = new FitnessCalculator().calculator(pop.get(i));
			if (score < tmp) {
				tmp = score;
				worst = i;
			}
		}

		pop.remove(new SecureRandom().nextInt(pop.size()));
		pop.add(cross);

		return pop;
	}

	// Apenas adiciona a nova solução
	public ArrayList<ArrayList<InstanceModel>> increase(ArrayList<ArrayList<InstanceModel>> pop,
			ArrayList<InstanceModel> cross) {

		for (int i = 0; i < pop.size(); i++) {
			int score = new FitnessCalculator().calculator(pop.get(i));
			if (score < tmp) {
				tmp = score;
				worst = i;
			}
		}

		pop.add(cross);

		return pop;
	}

}
