package hr.fer.zemris.optjava.dz3.decoders;

import java.util.Arrays;

import hr.fer.zemris.optjava.dz3.solutions.DoubleArraySolution;

public class PassThroughDecoder implements IDecoder<DoubleArraySolution> {

	public PassThroughDecoder() {

	}

	public double[] decode(DoubleArraySolution solution) {
		return Arrays.copyOf(solution.values, solution.values.length);
	}

	public void decode(DoubleArraySolution solution, double[] decodedSolution) {
		decodedSolution = solution.values;
	}

}
