package Population;

import java.util.ArrayList;

import InstanceLoader.InstanceModel;

public class GenPopulation {
	
public ArrayList<ArrayList<InstanceModel>> gen(ArrayList<InstanceModel> values, int TAM_POP) {
	
	ArrayList<ArrayList<InstanceModel>> pop = new ArrayList<ArrayList<InstanceModel>>();
	ArrayList<InstanceModel> individuo;
	
	for(int i = 0; i < TAM_POP; i++) {
		individuo = new Populate().Pop(values);
		pop.add(individuo);
	}
		

		return pop;
		
	}

}
