package hr.fer.zemris.optjava.dz3.decoders;

import static java.lang.Math.pow;

import hr.fer.zemris.optjava.dz3.solutions.BitvectorSolution;

public class NaturalBinaryDecoder extends BitvectorDecoder {

	public NaturalBinaryDecoder(double mins, double maxs, int bits, int n) {
		super(mins, maxs, bits, n);
	}

	public NaturalBinaryDecoder(double[] mins, double[] maxs, int[] bits, int n) {
		super(mins, maxs, bits, n);
	}

	public double[] decode(BitvectorSolution solution) {
		double[] decodedSolution = new double[n];
		int startIndex = 0;
		int endIndex = 0;

		for (int i = 0; i < n; i++) {
			endIndex += bits[i];
			decodedSolution[i] = decodeVariable(solution.bits, i, startIndex, endIndex);
			startIndex = endIndex;
		}

		return decodedSolution;
	}

	private double decodeVariable(byte[] bits, int i, int start, int end) {
		return mins[i] + byteArrayToInt(bits, start, end - 1) * (maxs[i] - mins[i]) / (pow((end - start), 2) - 1);
	}

	private double byteArrayToInt(byte[] bits, int start, int end) {
		int value = 0;
		
		for(int i = start; i <= end; i++) {
			value *= 2;
			if(bits[i] == 1) {
				value++;
			}
		}
		
		return value;
	}

	public void decode(BitvectorSolution bvs, double[] ds) {
	}

}
