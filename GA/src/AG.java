import java.util.ArrayList;

import Controls.GetBestSolution;
import Genetics.Ancestors;
import Genetics.CrossOver;
import Genetics.Mutation;
import InstanceLoader.InstanceControl;
import InstanceLoader.InstanceModel;
import SoftConstraints.*;
import Population.*;

public class AG {
	private static ArrayList<InstanceModel> values;
	private static ArrayList<ArrayList<InstanceModel>> pop;
	private static ArrayList<InstanceModel> best; 
	private static ArrayList<ArrayList<InstanceModel>> ancestors; 
	private static ArrayList<InstanceModel> cross; 
	private static int score;

	public static void main(String[] args) {
		
		//Carrega a Instância
		values = new InstanceControl().loader("instancia.csv");
		
		//Gera População
		pop = new GenPopulation().gen(values);
		
		//Obtém a Melhor solução
		best = new GetBestSolution().getSolution(pop);

		//Seleciona os Ancestrais
		ancestors = new Ancestors().getAncestor(pop);
		
		//Realiza os Cruzamentos
		cross = new CrossOver().cross(ancestors);
		
		//Realiza Mutação
		cross = new Mutation().cross(cross);
		
		//Avalia a Solução
		score = new FitnessCalculator().calculator(cross);
		
		//Atualiza a População
		pop = new UpdatePopulation().up(pop, cross);

		//Show Best Solution
		new Populate().print(best);
		
	}
}
