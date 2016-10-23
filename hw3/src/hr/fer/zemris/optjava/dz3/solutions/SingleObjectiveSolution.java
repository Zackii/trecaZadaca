package hr.fer.zemris.optjava.dz3.solutions;

public class SingleObjectiveSolution {

	public double fitness;
	public double value;

	public SingleObjectiveSolution() {
	}

	public double compareTo(SingleObjectiveSolution anotherSolution) {
		
		double x = this.fitness;
		double y = anotherSolution.fitness;
		return x - y;
	}

}