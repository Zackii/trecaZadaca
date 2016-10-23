package hr.fer.zemris.optjava.dz3.decoders;

import hr.fer.zemris.optjava.dz3.solutions.BitvectorSolution;

public class GreyBinaryDecoder extends BitvectorDecoder {
	
	public GreyBinaryDecoder(double[] mins, double[] maxs, int[] bits, int n) {
		super(mins, maxs, bits, n);
	}

	public GreyBinaryDecoder(double min, double max, int bit, int n) {
		super(min, max, bit, n);
	}

	public double[] decode(BitvectorSolution bvs) {
		return null;
	}

	public void decode(BitvectorSolution bvs, double[] ds) {
		
	}

}
