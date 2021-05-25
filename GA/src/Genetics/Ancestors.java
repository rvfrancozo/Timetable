package Genetics;

import java.security.SecureRandom;
import java.util.ArrayList;

import InstanceLoader.InstanceModel;

public class Ancestors {
	
	SecureRandom random = new SecureRandom();
	
	public ArrayList<ArrayList<InstanceModel>> getAncestor(ArrayList<ArrayList<InstanceModel>> pop) {
		
		ArrayList<ArrayList<InstanceModel>> ancestors = new ArrayList<ArrayList<InstanceModel>>();
		
		ancestors.add(pop.get(random.nextInt(pop.size())));
		ancestors.add(pop.get(random.nextInt(pop.size())));
		
		return ancestors;
	}
}