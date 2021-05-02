import java.util.ArrayList;

import InstanceLoader.InstanceControl;
import InstanceLoader.InstanceModel;
import SoftConstraints.*;
import Population.*;
import SoftConstraints.*;

public class AG {

	public static void main(String[] args) {
		
		//Carrega a Instância
		ArrayList<InstanceModel> values = new InstanceControl().loader("instancia.csv");
		
		//Gera População
		ArrayList<ArrayList<InstanceModel>> pop = new GenPopulation().gen(values);

		//Seleciona os Ancestrais
		
		//Realiza os Cruzamentos
		
		//Avalia a Solução
		
	}

}
