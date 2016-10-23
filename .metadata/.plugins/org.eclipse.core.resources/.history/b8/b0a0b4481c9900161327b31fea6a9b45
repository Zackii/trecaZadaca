package hr.fer.zemris.optjava.dz3;

import hr.fer.zemris.optjava.dz3.decoders.PassThroughDecoder;
import hr.fer.zemris.optjava.dz3.functions.Function1;
import hr.fer.zemris.optjava.dz3.neighborhoods.DoubleArrayUnifNeighborhood;
import hr.fer.zemris.optjava.dz3.schedules.GeometricTempSchedule;
import hr.fer.zemris.optjava.dz3.solutions.DoubleArraySolution;

public class RegresijaSustava {

	public static void main(String[] args) {
		
		if(args[1].equals("decimal")) {
			
			new SimulatedAnnealing<DoubleArraySolution>(new PassThroughDecoder(), new DoubleArrayUnifNeighborhood(new double[]{}), new DoubleArraySolution(6), new Function1(args[0]), true, new GeometricTempSchedule(0.0, 0.0, 0, 0));
			
		} else {
			
		}
		
	}

}
