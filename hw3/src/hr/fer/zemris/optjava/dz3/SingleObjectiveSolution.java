package hr.fer.zemris.optjava.dz3;

public class SingleObjectiveSolution {

	// vrijednost koju vraca fitness funkcija za ovo rjesenje
	private double fitness;
	// neznm
	private double value;

	public SingleObjectiveSolution() {
	}

	public int compareTo(SingleObjectiveSolution anotherSolution) {
		// provjeri jos
		double x = this.fitness;
		double y = anotherSolution.fitness;
		return (x < y) ? -1 : ((x == y) ? 0 : 1);
	}

}