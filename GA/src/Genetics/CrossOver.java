package Genetics;

import java.security.SecureRandom;
import java.util.ArrayList;
import InstanceLoader.InstanceModel;

public class CrossOver {
	SecureRandom random = new SecureRandom();

	public ArrayList<InstanceModel> cross(ArrayList<ArrayList<InstanceModel>> ancestors) {
		
		ArrayList<InstanceModel> cross = new ArrayList<InstanceModel>();
		
		int start = random.nextInt(ancestors.get(0).size());
				
		for(int i = 0; i < start; i++) 
			cross.add(ancestors.get(0).get(i));
		for(int i = start; i < ancestors.get(1).size(); i++)
			cross.add(ancestors.get(1).get(i));
		
		return cross;
	}

}
