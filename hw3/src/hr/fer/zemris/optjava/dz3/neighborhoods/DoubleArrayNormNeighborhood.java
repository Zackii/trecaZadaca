package hr.fer.zemris.optjava.dz3.neighborhoods;

import java.util.Arrays;
import java.util.Random;

import hr.fer.zemris.optjava.dz3.solutions.DoubleArraySolution;

public class DoubleArrayNormNeighborhood implements INeighborhood<DoubleArraySolution> {

	private double[] deltas;
	protected Random rand;
	
	public DoubleArrayNormNeighborhood(double[] deltas) {
		deltas = Arrays.copyOf(deltas, deltas.length);
	}

	@Override
	public DoubleArraySolution randomNeighbor(DoubleArraySolution solution) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
