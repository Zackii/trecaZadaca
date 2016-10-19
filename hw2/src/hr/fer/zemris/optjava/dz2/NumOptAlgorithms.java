package hr.fer.zemris.optjava.dz2;

import java.util.Random;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.SingularMatrixException;


public class NumOptAlgorithms {
	
	private static final double EPSILON = 0.01;
	private static IFunction funkcija;
	private static RealVector rjesenje;
	private static RealVector smjerPretrage;
	private static int brIter;
	
	public static void algoritamGradijentnogSpusta(IFunction funkcija, int brIter, RealVector pocRjesenje) {
		
		NumOptAlgorithms.funkcija = funkcija;
		NumOptAlgorithms.brIter = brIter;
		
		if(pocRjesenje == null) {
			generirajPocetnoRjesenje();
		} else {
			rjesenje = pocRjesenje;
		}
		
		Function fun = new Function() {

			@Override
			public RealVector apply() {
				return funkcija.vratiVrijednostGradijentaU(rjesenje).mapMultiplyToSelf(-1).unitVector();
			}
		};
	
		pretrazivanjeUZadanomSmjeru(fun);

}

	private static double pronadiKorak() {
		double lambdaDonja = 0;
		double lambdaGornja = 1;
		
		while(true) {
			
			if(vratiVrijednostDerivacijeFunkcijeθU(lambdaGornja) > 0) {
				break;
			}
			lambdaGornja *=2;
			
		}
		
		return metodaBisekcije(lambdaDonja, lambdaGornja);
	}

	private static double metodaBisekcije(double lambdaDonja, double lambdaGornja) {
		double lambda;
		double vrijednost;

		while(true) {
			
			lambda = (lambdaDonja + lambdaGornja)/2;
			vrijednost = vratiVrijednostDerivacijeFunkcijeθU(lambda);
			
			if(vrijednost < EPSILON) {
				break;
			} else if(vrijednost > 0) {
				lambdaGornja = lambda;
			} else {
				lambdaDonja = lambda;
			}
			
		}
		
		return lambda;
	}

	private static double vratiVrijednostDerivacijeFunkcijeθU(double lambda) {
		
		return funkcija.vratiVrijednostGradijentaU(rjesenje.add(smjerPretrage.mapMultiply(lambda))).dotProduct(smjerPretrage);
	}
	
	public static void algoritamNewtonoveMetode(IHFunction funkcija, int brIter, RealVector pocRjesenje) {
		
		NumOptAlgorithms.funkcija = funkcija;
		NumOptAlgorithms.brIter = brIter;
		
		if(pocRjesenje == null) {
			generirajPocetnoRjesenje();
		} else {
			rjesenje = pocRjesenje;
		}
		
		Function fun = new Function() {
			
			@Override
			public RealVector apply() {
				
				RealMatrix hesseovaMatrica = funkcija.vratiVrijednostHesseoveMatriceU(rjesenje);
				RealMatrix jedinicnaMatrica = stvoriJedinicnuMatricu(funkcija.vratiBrojVarijabli());
				
				double lambda = 0.001;
				RealVector vektor;
				
				while(true) {
					
					try {
						vektor = new LUDecomposition(hesseovaMatrica.add(jedinicnaMatrica.scalarMultiply(lambda)))
							.getSolver()
							.getInverse()
							.scalarMultiply(-1)
							.preMultiply(funkcija.vratiVrijednostGradijentaU(rjesenje));
					
					} catch(SingularMatrixException sme) {
						lambda *= 2;
						continue;
					}
					
					break;
				}
				
				return vektor;
			}

			private RealMatrix stvoriJedinicnuMatricu(int brojVarijabli) {
				double[][] matrica = new double[brojVarijabli][brojVarijabli];
				for(int i = 0; i < brojVarijabli; i++) {
					matrica[i][i] = 1;
				}
				return new Array2DRowRealMatrix(matrica);
			}
		};
		
		pretrazivanjeUZadanomSmjeru(fun);
		
	}
	
	private static void generirajPocetnoRjesenje() {
		double[] poljeVarijabli = new double[funkcija.vratiBrojVarijabli()];
		Random rand = new Random();
		
		for(int i = 0, n = funkcija.vratiBrojVarijabli(); i < n; i++) {
			poljeVarijabli[i] = rand.nextDouble()*10 - 5;
		}
	
		rjesenje = new ArrayRealVector(poljeVarijabli);
	}

	private static void pretrazivanjeUZadanomSmjeru(Function fun) {
		double lambda;
		
		for(int k = 0; k < brIter; k++) {
			smjerPretrage = fun.apply();
			lambda = pronadiKorak();
			rjesenje = rjesenje.add(smjerPretrage.mapMultiply(lambda));
		}
		
		System.out.println(rjesenje);
		
	}
}
