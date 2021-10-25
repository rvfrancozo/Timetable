import java.util.ArrayList;

import Controls.GetBestSolution;
import Genetics.Ancestors;
import Genetics.CrossOver;
import Genetics.Mutation;
import InstanceLoader.InstanceControl;
import InstanceLoader.InstanceModel;
import SoftConstraints.*;
import Population.*;
import Controls.SaveSolution;

public class AG {
	private static ArrayList<InstanceModel> values;
	private static ArrayList<ArrayList<InstanceModel>> pop;
	private static ArrayList<InstanceModel> best; 
	private static ArrayList<ArrayList<InstanceModel>> ancestors; 
	private static ArrayList<InstanceModel> cross; 

	public static void main(String[] args) {
		
		//int torneio = 30
		long tempoInicial = System.currentTimeMillis();

		//Carrega a Instância ---
		values = new InstanceControl().loader("instancia.csv");

		//Gera População
		pop = new GenPopulation().gen(values, 100);
		
		//Obtém a Melhor solução
		best = new GetBestSolution().getSolution(pop);
		System.out.println("Score Inicial: " + new FitnessCalculator().calculator(best));
		
		do {

		//Seleciona os Ancestrais
		ancestors = new Ancestors().getAncestor(pop);
		
		//Realiza os Cruzamentos
		cross = new CrossOver().cross(ancestors);
		
		//Realiza Mutação
		cross = new Mutation().cross(cross);
		
		//System.out.println("Score Cross: " + new FitnessCalculator().calculator(cross));
		
		//Atualiza a População
		pop = new UpdatePopulation().randomup(pop, cross);
		
		//Show Best Solution
		//new Populate().print(best);
		long decorrido = System.currentTimeMillis() - tempoInicial;
		
		System.out.printf("Score Final: %d : %.3f seconds\n", new FitnessCalculator().calculator(best), (decorrido * 0.001) );
		new SaveSolution(best, "results.csv");
		} while(new FitnessCalculator().calculator(best) > 0);
		
		new Populate().print(best);
	}
}
