package hr.fer.zemris.optjava.dz2;

import Jama.Matrix;

public class NumOptAlgorithms {
	
	private static final double EPSILON = 1;
	private static IFunction funkcija;
	private static double[] rjesenje;
	private static double[] smjerPretrage;
	private static Matrix rjesenje1;
	private static Matrix smjerPretrage1;
	

	public static void algoritamGradijentnogSpusta(final IFunction funkcija, int brIter) {
		
		NumOptAlgorithms.funkcija = funkcija;
		rjesenje = new double[funkcija.vratiBrojVarijabli()]; //fali jos inicijalizacija

		double lambda;
		
		for(int k = 0; k < brIter; k++) {
			
			smjerPretrage = utvrdiSmjerPretrage(); //...
			lambda = pronadiKorak();
			
//			for(int i = 0; i < rjesenje.length; i++) {
//				rjesenje[i] = rjesenje[i] + lambda*smjerPretrage[i];
//			}
			
			rjesenje1.plusEquals(smjerPretrage1.times(lambda));
			
		}
		
	}

	private static double pronadiKorak() {
		
		double lambdaDonja = 0;
		double lambdaGornja = 1;
		double lambda;
		
		while(true) {
			
			lambda = (lambdaDonja + lambdaGornja)/2;
			
			if(vratiVrijednostDerivacijeFunkcijeθU(lambda) > 0) {
				break;
			}
			lambdaGornja *=2;
			
		}
		
		return metodaBisekcije(lambdaDonja, lambdaGornja);
	}

	//θ(λ) = f(x + λ·d)
	private static double vratiVrijednostDerivacijeFunkcijeθU(double lambda) {
		
		double[] rjesenje = new double[funkcija.vratiBrojVarijabli()];
		
		for(int i = 0, n = funkcija.vratiBrojVarijabli(); i < n; i++) {
			rjesenje[i] = NumOptAlgorithms.rjesenje[i] + lambda*smjerPretrage[i];
		}
		
		double vrijednost = 0;
		double[] gradijent = funkcija.vratiVrijednostGradijentaU(rjesenje);
		
		for(int i = 0, n = funkcija.vratiBrojVarijabli(); i < n; i++) {
			vrijednost += gradijent[i]*smjerPretrage[i];
		}
		
		return vrijednost;
	}

	private static double metodaBisekcije(double lambdaDonja, double lambdaGornja) {
		
		double lambda;
		double  derivacijaFunkcijeθ;
		return 0;
	}

	private static double[] utvrdiSmjerPretrage() {
		
//		Matrix gradijent1 = new Matrix(funkcija.vratiVrijednostGradijentaU(rjesenje), m);
//		double[] gradijent = funkcija.vratiVrijednostGradijentaU(rjesenje1.getColumnPackedCopy());
//		for(int i = 0; i < gradijent.length; i++) {
//			gradijent[i] = -gradijent[i];
//		}
//		return gradijent;
		return null;
	}
	
	public static void algoritamNewtonoveMetode(IHFunction funkcija, int brIter) {
		
	}
	
}
