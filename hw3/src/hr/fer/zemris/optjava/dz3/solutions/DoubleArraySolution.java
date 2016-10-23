package hr.fer.zemris.optjava.dz3.solutions;

import java.util.Arrays;
import java.util.Random;

public class DoubleArraySolution extends SingleObjectiveSolution {

	public double[] values;
	
	public DoubleArraySolution(int numOfVariables) {
		values = new double[numOfVariables];
	}
	
	public DoubleArraySolution newLikeThis() {
		return null;
	}
	
	public DoubleArraySolution duplicate() {
		DoubleArraySolution duplicate = new DoubleArraySolution(this.values.length);

		duplicate.values = Arrays.copyOf(this.values, this.values.length);

		return duplicate;
	}
	
	public void randomize(Random rand, double[] mins, double[] maxs) {
		
	}
	
}