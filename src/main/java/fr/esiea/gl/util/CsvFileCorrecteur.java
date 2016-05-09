package fr.esiea.gl.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Singleton (faible couplage avec les objets)
 * Correcteur de fichier CSV pour retirer les ";" du fichier originel de la FDJ mal interprété par la blibliothèque SUPERCSV.
 * @author Akta
 *
 */
public class CsvFileCorrecteur {

	private static CsvFileCorrecteur instance;

	public static CsvFileCorrecteur getInstance() {

		if (instance == null)
			return new CsvFileCorrecteur();
		else
			return instance;
	}

	private CsvFileCorrecteur() {
		;
	}

	public File corrigerFichier(File fichierCsvToCorrect) throws IOException {
		
		
		File fichTemp=new File("./fichTemp");
		FileReader fr = new FileReader(fichierCsvToCorrect);
		FileWriter fw = new FileWriter(fichTemp);
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		
		try {
			
			for (String ligne = br.readLine(); ligne != null; ligne = br.readLine()) {
				String dernierCaractere= ligne.substring(ligne.length()-1,ligne.length());
				if(dernierCaractere.trim().equals(";"))
					bw.write(ligne.trim().substring(0,ligne.length()-1)+"\n");
				else
					bw.write(ligne+"\n");
					
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichier csv inconnu");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Lecture du fichier csv impossible");
			e.printStackTrace();
		}
		finally{
			br.close();
			bw.close();
			fw.close();
			fr.close();
			fichierCsvToCorrect.delete();
			fichTemp.renameTo(fichierCsvToCorrect);
		}

		return fichierCsvToCorrect;

	}
}
