package hr.fer.zemris.optjava.dz3.schedules;

public interface ITempSchedule {

	double getNextTemperature();
	int getInnerLoopCounter();
	int getOuterLoopCounter();
	
}
