package hr.fer.zemris.optjava.dz3;

import java.util.Random;

public class DoubleArraySolution extends SingleObjectiveSolution {

	// polje vrijednosti varijabli
	private double[] values;
	
	public DoubleArraySolution(int numOfVariables) {
		values = new double[numOfVariables];
	}
	
	public DoubleArraySolution newLikeThis() {
		return null;
	}
	
	public DoubleArraySolution duplicate() {
		return null;
	}
	
	public void randomize(Random rand, double[] d1, double[] d2) {
		
	}
	
}