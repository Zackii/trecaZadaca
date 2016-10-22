package hr.fer.zemris.optjava.dz3;

import java.util.Random;

public class SimulatedAnnealing<T> implements IOptAlgorithm<T> {

	private IDecoder<T> decoder;
	private INeighborhood<T> neighborhood;
	private T startWith;
	private IFunction function;
	private boolean minimize;
	private Random rand;
	
	public SimulatedAnnealing(IDecoder<T> decoder, INeighborhood<T> neighborhood, IFunction function, boolean minimize) {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public T run() {
		// TODO Auto-generated method stub
		return null;
	}

}
