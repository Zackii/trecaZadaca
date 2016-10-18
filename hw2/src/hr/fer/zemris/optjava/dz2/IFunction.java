package hr.fer.zemris.optjava.dz2;

import org.apache.commons.math3.linear.RealVector;

public interface IFunction {

	int vratiBrojVarijabli();
	double vratiVrijednostU(RealVector vektor);
	RealVector vratiVrijednostGradijentaU(RealVector vektor);
	
}