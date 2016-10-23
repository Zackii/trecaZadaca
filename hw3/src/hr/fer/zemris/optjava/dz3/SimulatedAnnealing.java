package hr.fer.zemris.optjava.dz3;

import java.util.Random;

import static java.lang.Math.exp;

import hr.fer.zemris.optjava.dz3.decoders.IDecoder;
import hr.fer.zemris.optjava.dz3.functions.IFunction;
import hr.fer.zemris.optjava.dz3.neighborhoods.INeighborhood;
import hr.fer.zemris.optjava.dz3.schedules.ITempSchedule;
import hr.fer.zemris.optjava.dz3.solutions.SingleObjectiveSolution;

public class SimulatedAnnealing<T extends SingleObjectiveSolution> implements IOptAlgorithm<T> {

	private IDecoder<T> decoder;
	private INeighborhood<T> neighborhood;
	private ITempSchedule schedule;
	private T startWith;
	private IFunction function;
	private boolean minimize;
	private Random rand;

	public SimulatedAnnealing(IDecoder<T> decoder, INeighborhood<T> neighborhood, T startWith, IFunction function,
			boolean minimize, ITempSchedule schedule) {
		this.decoder = decoder;
		this.neighborhood = neighborhood;
		this.startWith = startWith;
		this.function = function;
		this.minimize = minimize;
		this.schedule = schedule;
		this.rand = new Random();
	}

	@Override
	public T run() {
		double tCurrent = schedule.getNextTemperature();
		int innerCounter = schedule.getInnerLoopCounter();
		int outerCounter = schedule.getOuterLoopCounter();

		T currSolution = startWith;
		currSolution.fitness = function.valueAt(decoder.decode(currSolution));
		
		T neighbor;
		double neighborsDiff;

		for (int i = 0; i < outerCounter; i++) {
			for (int j = 0; j < innerCounter; j++) {

				neighbor = neighborhood.randomNeighbor(currSolution);
				neighbor.fitness = function.valueAt(decoder.decode(neighbor));
				
				neighborsDiff = neighbor.compareTo(currSolution);

				if (acceptNeighborAsNewSolution(neighborsDiff, tCurrent)) {
					currSolution = neighbor;
				}
			}

			tCurrent = schedule.getNextTemperature();
		}

		return currSolution;
	}

	private boolean acceptNeighborAsNewSolution(double neighborsDiff, double tCurrent) {
		double probability;
		if (minimize) {
			probability = neighborsDiff > 0 ? exp(-neighborsDiff / tCurrent) : 1;
		} else {
			probability = neighborsDiff > 0 ? 1 : Math.exp(-neighborsDiff / tCurrent);
		}
		return probability > rand.nextDouble();
	}

}
