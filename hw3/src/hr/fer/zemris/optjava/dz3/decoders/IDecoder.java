package hr.fer.zemris.optjava.dz3.decoders;

public interface IDecoder<T> {

	double[] decode(T t);
	void decode(T t, double[] vector);
	
}
