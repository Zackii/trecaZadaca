package hr.fer.zemris.optjava.dz2;

public class Main {

	public static void main(String args[]) {

		double[] k = new double[] { 5.204383880458222, -2.9365556472780354, 0.8757076526849392, 1.3545278044722402, -0.8030858193999681, 3.091753125311312};

		double[] x = new double[] { -0.160,  2.320, -3.500, -2.660,  4.620 };

		double sum = 0;
//		for (int i = 0; i < 10; i++) {
//			sum += x[i] * k[i];
//		}
		
		sum = k[0]*x[0]+k[1]*x[0]*x[0]*x[0]*x[1]+k[2]*Math.pow(Math.E, k[3]*x[2])*(1+Math.cos(k[4]*x[3]))+k[5]*x[3]*x[4]*x[4];

		System.out.println(sum);

	}

}
