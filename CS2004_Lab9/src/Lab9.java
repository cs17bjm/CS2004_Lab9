import java.util.ArrayList;

public class Lab9 {
	public static void main(String[]args) {
		//ScalesSolution s = new ScalesSolution("1111111");
		//s.println();
		//s.SmallChange();
		//s.println();
		
		//ScalesSolution s1 = new ScalesSolution(10);
		//s1.println();
		//ScalesSolution s2 = new ScalesSolution(s1.GetSol());
		//s2.println();
		System.out.println("---------------");
		ArrayList<Double> listA = new ArrayList<Double>();
		listA.add(1.0);
		listA.add(2.0);
		listA.add(3.0);
		listA.add(4.0);
		listA.add(10.0);
		
		ScalesSolution a = new ScalesSolution(listA.size());
		System.out.println("RMHC");
		
		a = RMHC(listA, listA.size(), 5);
		System.out.println("---------------");

		ScalesSolution b = new ScalesSolution(1000);
		b = RMHC(CS2004.ReadNumberFile("C:\\Users\\Brandon\\eclipse-workspace\\CS2004_Lab8\\src\\1000_Primes.txt"), 1000, 1000);

	}
	public static ScalesSolution RMHC(ArrayList<Double> weights,int n,int iter)
	{
		/*
		 * for loop that iterates for specified number of iterations (iter) 
		 * create initial random solution of size n
		 * evaluate the fitness of our current solution within the loop
		 * copy the current solution (say oldsol)
		 * smallchange to the current solution and evaluate the fitness to another variable
		 * if new fitness is worse than the old, copy the oldsol back to current sol
		 * after for loop has completed we return the current solution
		 * */
		
		ScalesSolution currentSol = new ScalesSolution(n);
		Double currentFitness = currentSol.ScalesFitness(weights);
		
		System.out.print("Initial Solution: " );
		currentSol.println();
		System.out.println("Initial Fitness: " + currentFitness);
		
		for (int i = 0; i < iter ; i++) {
			ScalesSolution newSol = new ScalesSolution(currentSol.GetSol());
			newSol.SmallChange();
			Double newFitness = newSol.ScalesFitness(weights);
			if (currentFitness > newFitness ) {
				currentSol = newSol;
				currentFitness = newFitness;
			}
			
			
			//Printing test solutions
			//System.out.print("SOLUTION: " );
			//newSol.print();
			//System.out.println(" (Solution Fitness = " + newFitness + ")");
			//System.out.println("Best Fitness: " + currentFitness);

			
		}
		System.out.print("Best Solution: " );
		currentSol.println();
		System.out.println("Best Fitness: " + currentFitness + " (in " + iter + " runs)");
		
		return(currentSol);
	}
}
