package hr.fer.zemris.optjava.dz2;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class Funkcija3 implements IHFunction {

	private static final int BROJ_VARIJABLI = 10;
	private static final int INDEKS_VRIJEDNOSTI_FUNKCIJE = 10;
	
	private static final int BROJ_KOEFICIJENATA_U_REDU = 11;
	
	private double[][] koeficijenti;
	
	public Funkcija3(String putDatoteke) {
		CitacSustava citac = new CitacSustava(putDatoteke, BROJ_KOEFICIJENATA_U_REDU);
		koeficijenti = citac.vratiKoeficijente();
		
	}
	
	@Override
	public int vratiBrojVarijabli() {
		return BROJ_VARIJABLI;
	}

	@Override
	public double vratiVrijednostU(RealVector vektor) {
		double[] x = vektor.toArray();
		double vrijednostIteLinJedn;
		double sumaRazlikeKvadrata = 0;
		
		for(int i = 0; i < BROJ_VARIJABLI; i++) {
			vrijednostIteLinJedn = vrijednostIteLinJednZaDanoPoljeXa(i, x);
			sumaRazlikeKvadrata = Math.pow(vrijednostIteLinJedn - koeficijenti[i][INDEKS_VRIJEDNOSTI_FUNKCIJE], 2);
		}
		
		return sumaRazlikeKvadrata;
	}

	private double vrijednostIteLinJednZaDanoPoljeXa(int i, double[] x) {
		int vrijednost = 0;
		
		for(int j = 0; j < BROJ_VARIJABLI; j++) {
			vrijednost += koeficijenti[i][j]*x[j];
		}
		
		return vrijednost;
	}

	@Override
	public RealVector vratiVrijednostGradijentaU(RealVector vector) {
		double[] x = vector.toArray();
		double[] gradijent = new double[BROJ_VARIJABLI];
		
		for (int i = 0; i < BROJ_VARIJABLI; i++) {
			
			for (int j = 0; j < BROJ_VARIJABLI; j++) {
				gradijent[i] += 2 * koeficijenti[j][i] * (vrijednostIteLinJednZaDanoPoljeXa(j, x) -  koeficijenti[j][INDEKS_VRIJEDNOSTI_FUNKCIJE]);
			}
			
		}
		
		return new ArrayRealVector(gradijent);
	}

	@Override
	public RealMatrix vratiVrijednostHesseoveMatriceU(RealVector vector) {
		double[][] hesseovaMatrica = new double[BROJ_VARIJABLI][BROJ_VARIJABLI];
		
		for (int i = 0; i < BROJ_VARIJABLI; i++) {
			for (int j = 0; j < BROJ_VARIJABLI; j++) {
				
				for(int k = 0; k < BROJ_VARIJABLI; k++) {
					hesseovaMatrica[i][j] += 2 * koeficijenti[j][k] * koeficijenti[j][k];
				}
				
			}
		}
		
		return new Array2DRowRealMatrix(hesseovaMatrica);
	}
	
	
	
}
