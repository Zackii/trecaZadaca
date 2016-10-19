package hr.fer.zemris.optjava.dz2;

public class Sustav {

	public static void main(String[] args) {
		
		if(args.length != 3) {
			System.err.println("Program ocekuje 3 argumenta");
		}
		 
		if(args[0].equals("grad")) {
			NumOptAlgorithms.algoritamGradijentnogSpusta(new Funkcija3(args[2]), Integer.parseInt(args[1]), null);
		} else {
			NumOptAlgorithms.algoritamNewtonoveMetode(new Funkcija3(args[2]), Integer.parseInt(args[1]), null);
		}
		
	}
	
}
