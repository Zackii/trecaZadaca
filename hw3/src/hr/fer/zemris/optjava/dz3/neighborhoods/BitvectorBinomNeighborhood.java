package hr.fer.zemris.optjava.dz3.neighborhoods;

import java.util.Arrays;
import java.util.Random;

import hr.fer.zemris.optjava.dz3.solutions.BitvectorSolution;

public class BitvectorBinomNeighborhood implements INeighborhood<BitvectorSolution> {

	private int[] changeBitsPerVariable;
	private int[] bitsPerVariable;
	private Random rand;
	private RandIntegerGenerator generator;

	public BitvectorBinomNeighborhood(int[] changeBitsPerVariable, int[] bitsPerVariable) {
		
		this.changeBitsPerVariable = Arrays.copyOf(changeBitsPerVariable, changeBitsPerVariable.length);
		this.bitsPerVariable = Arrays.copyOf(bitsPerVariable, bitsPerVariable.length);
		this.rand = new Random();
		this.generator = new RandIntegerGenerator();
	}
	
	@Override
	public BitvectorSolution randomNeighbor(BitvectorSolution solution) {
		BitvectorSolution neighbor = solution.duplicate();
		int variableBitsStart = 0;

		for (int i = 0; i < bitsPerVariable.length; i++) {
			
			int bitsChanging = rand.nextInt(changeBitsPerVariable[i] + 1);
			generator.setGenerator(i);

			for (int j = 0; j < bitsChanging; j++) {
				int shift = generator.nextInt();
				
				if(neighbor.bits[variableBitsStart + shift] == 1) {
					neighbor.bits[variableBitsStart + shift] = 0;
					
				} else {
					neighbor.bits[variableBitsStart + shift] = 1;
					
				}
			}

			variableBitsStart += bitsPerVariable[i];
		}

		
		return neighbor;
	}
	
	private class RandIntegerGenerator {
		private int numOfInts;
		private int[] intArray;
		
		private void setGenerator(int i) {
			this.numOfInts = bitsPerVariable[i];
			for(int j = 0; j < numOfInts; j++) {
				intArray[j] = j;
			}
		}
		
		private int nextInt() {
			int i = rand.nextInt(numOfInts);
			int randInt = intArray[i];
			int j = intArray[numOfInts - 1];
			intArray[i] = j;
			
			numOfInts--;
			
			return randInt;
		}
		
	}

}
