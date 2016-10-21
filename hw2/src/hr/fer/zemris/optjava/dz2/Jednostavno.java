package hr.fer.zemris.optjava.dz2;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

public class Jednostavno {

	public static void main(String[] args) {
		
		int brojteracija = Integer.parseInt(args[1]);
		
		RealVector rjesenje = null;
		
		if(args.length == 2) {
			switch(args[0]) {
				case "1a":
					rjesenje = NumOptAlgorithms.algoritamGradijentnogSpusta(new Function1(), brojteracija, null);
					break;
				case "1b":
					rjesenje = NumOptAlgorithms.algoritamNewtonoveMetode(new Function1(), brojteracija, null);
					break;
				case "2a":
					rjesenje = NumOptAlgorithms.algoritamGradijentnogSpusta(new Function2(), brojteracija, null);
					break;
				case "2b":
					rjesenje = NumOptAlgorithms.algoritamGradijentnogSpusta(new Function2(), brojteracija, null);
			}
		} else {
			double[] pocVrijednostiVarijabli = new double[2];
			pocVrijednostiVarijabli[0] = Double.parseDouble(args[2]);
			pocVrijednostiVarijabli[0] = Double.parseDouble(args[3]);
			RealVector vector = new ArrayRealVector(pocVrijednostiVarijabli);
			switch(args[0]) {
			case "1a":
				rjesenje = NumOptAlgorithms.algoritamGradijentnogSpusta(new Function1(), brojteracija, vector);
				break;
			case "1b":
				rjesenje = NumOptAlgorithms.algoritamNewtonoveMetode(new Function1(), brojteracija, vector);
				break;
			case "2a":
				rjesenje = NumOptAlgorithms.algoritamGradijentnogSpusta(new Function2(), brojteracija, vector);
				break;
			case "2b":
				rjesenje = NumOptAlgorithms.algoritamGradijentnogSpusta(new Function2(), brojteracija, vector);
			}
			
		}
		
		System.out.println("rjesenje:" + rjesenje);
		
	}
	
}
