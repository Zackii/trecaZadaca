package hr.fer.zemris.optjava.dz2;

import org.apache.commons.math3.linear.RealVector;

public class Sustav {

	public static void main(String[] args) {

		if (args.length != 3) {
			System.err.println("Program ocekuje 3 argumenta");
			System.exit(1);
		}

		RealVector rjesenje = null;

		if (args[0].equals("grad")) {
			rjesenje = NumOptAlgorithms.algoritamGradijentnogSpusta(new Funkcija3(args[2]), Integer.parseInt(args[1]),
					null);
		} else if (args[0].equals("newton")) {
			rjesenje = NumOptAlgorithms.algoritamNewtonoveMetode(new Funkcija3(args[2]), Integer.parseInt(args[1]),
					null);
		}

		System.out.println("rjesenje:" + rjesenje);
		System.out.println();

		double[] poljeXeva = rjesenje.toArray();
		double[] poljeKonstanti = new double[] { -1.000, -1.000, 0.000, -3.000, 2.000, -2.000, 2.000, 3.000, 0.000,
				2.000 };

		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += poljeKonstanti[i] * poljeXeva[i];
		}
		// ovaj iznos pogreske je za prvu jednadzbu sustava
		System.out.println("iznos pogreške:" + Math.abs(sum + 38.000));

	}

}
