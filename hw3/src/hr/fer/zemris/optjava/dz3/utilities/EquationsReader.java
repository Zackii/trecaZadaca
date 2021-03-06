package hr.fer.zemris.optjava.dz3.utilities;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class EquationsReader {
	
	// svaki redak je oblika: [n1, n2, ..., n10, y]
	private static final String LINE_SPLIT_REGEX = ", +";
	private static final String SQUARE_BRACKETS_REGEX = "\\[|\\]";
	
	private double[][] coeffs;
	private String filePath;

	private int numOfValuesPerLine;
	private int numOfEquations = 20;

	public EquationsReader(String filePath, int numOfEquations, int numOfValuesPerLine) {
		this.filePath = filePath;
		this.numOfEquations = numOfEquations;
		this.numOfValuesPerLine = numOfValuesPerLine;
		
		coeffs = new double[numOfEquations][numOfValuesPerLine];
		
		extractCoeff();
	}

	private void extractCoeff() {
		BufferedReader fileReader = openFile();
		
		String line;
		int i = 0;
		while (true) {
			line = readLine(fileReader);
			if (line == null)
				return;

			line = line.trim();

			if (line.isEmpty())
				return;

			if (line.startsWith("#")) //komentar
				continue;

			coeffs[i] = getCoeffsFromLine(line);
			i++;
		}
		
	}
	
	private BufferedReader openFile() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(filePath.toString())), StandardCharsets.UTF_8));
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Citanje datoteke nije uspjelo");
		}
		return br;
	}

	private String readLine(BufferedReader fileReader) {
		String line = null;
		
		try {
			line = fileReader.readLine();
		} catch (IOException e) {
			throw new RuntimeException("Citanje datoteke nije uspjelo");
		}
		
		return line;
	}

	private double[] getCoeffsFromLine(String line) {
		line = line.replaceAll(SQUARE_BRACKETS_REGEX, ""); //makni uglate zagrade
		
		String[] splitCoeffs = line.split(LINE_SPLIT_REGEX); //odvoji koeficijente

		double[] coeffs = new double[numOfValuesPerLine];

		for (int i = 0; i < numOfValuesPerLine; i++) {
			coeffs[i] = Double.parseDouble(splitCoeffs[i]);
		}

		return coeffs;
	}
	
	public double[][] getCoeffs() {
		return coeffs;
	}
	
	public int getNumOfEquations() {
		return numOfEquations;
	}
	
	
}
