package hr.fer.zemris.optjava.dz2;

public class Main {

	public static void main(String args[]) {

		double[] k = new double[] { 7.148453048, -2.9804685025, 0.8384317564, 1.4368144913, -5.8710268405, 2.9961489804 };

		double[] x = new double[] { -0.160,  2.320, -3.500, -2.660,  4.620 };

		double sum = 0;
//		for (int i = 0; i < 10; i++) {
//			sum += x[i] * k[i];
//		}
		
		sum = k[0]*x[0]+k[1]*x[0]*x[0]*x[0]*x[1]+k[2]*Math.pow(Math.E, k[3]*x[2])*(1+Math.cos(k[4]*x[3]))+k[5]*x[3]*x[4]*x[4];

		System.out.println(sum);

	}

}
