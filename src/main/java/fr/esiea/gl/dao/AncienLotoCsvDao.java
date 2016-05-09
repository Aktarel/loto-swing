package fr.esiea.gl.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.Token;
import org.supercsv.cellprocessor.Trim;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import fr.esiea.gl.modele.AncienTirage;
import fr.esiea.gl.modele.Tirage;

/**
 * Classe permettant de récuperer les tirages de l'ancien loto.
 * 
 * @author Nicolas Lebec
 * @since 15/02/2012
 * 
 * 
 */

public class AncienLotoCsvDao implements LotoDao {

	private List<AncienTirage> tirages = new ArrayList<AncienTirage>();
	private BufferedReader br;
	private CsvBeanReader lecteur;
	private String[] header = { "id", "premierOuDeuxiemeTirage", "jourTirage",
			"dateTirage", "dateForclusion", "boule1", "boule2", "boule3",
			"boule4", "boule5", "boule6", "bouleComplementaire", "numeros",
			"numeroJoker", "nbGagnantRang1", "rapportRang1",
			"nbGagnantRang2", "rapportRang2", "nbGagnantRang3",
			"rapportRang3", "nbGagnantRang4", "rapportRang4",
			"nbGagnantRang5", "rapportRang5", "nbGagnantRang6",
			"rapportRang6", "nbGagnantRang7", "rapportRang7",
			"numeroJokerPlus", "devise" };
	private CellProcessor[] cellules;
	
	
	public AncienLotoCsvDao(File fichier) {

		try {
			//Recup a l'intérieur
			//br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(nomFichier)));
			br = new BufferedReader(new FileReader(fichier));
			// Evitez le debut du fichier
			br.skip(544);
			cellules = new CellProcessor[] { new ParseDouble(),
					new ParseInt(), null, null, new Token("", "00000000"),
					new ParseInt(), new ParseInt(), new ParseInt(), new ParseInt(),
					new ParseInt(), new ParseInt(), new ParseInt(), new Trim(17),
					new Token("", "0"), new ParseDouble(), null, new ParseDouble(),
					null, new ParseDouble(), null, new ParseDouble(), null,
					new ParseDouble(), null, new ParseDouble(), null,
					new ParseDouble(), null, new Token("", "0"), null };

			lecteur = new CsvBeanReader(br,CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);
			for (AncienTirage t = lecteur.read(AncienTirage.class, header, cellules); t != null; t = lecteur.read(AncienTirage.class, header, cellules))
				tirages.add(t);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			try {
				lecteur.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

	public AncienLotoCsvDao() {
		
		try {
			//Recup a l'intérieur
			//br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(nomFichier)));
			br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/loto.csv")));
			// Evitez le debut du fichier
			br.skip(546);
			cellules = new CellProcessor[] { new ParseDouble(),
					new ParseInt(), null, null, new Token("", "00000000"),
					new ParseInt(), new ParseInt(), new ParseInt(), new ParseInt(),
					new ParseInt(), new ParseInt(), new ParseInt(), new Trim(17),
					new Token("", "0"), new ParseDouble(), null, new ParseDouble(),
					null, new ParseDouble(), null, new ParseDouble(), null,
					new ParseDouble(), null, new ParseDouble(), null,
					new ParseDouble(), null, new Token("", "0"), null };

			lecteur = new CsvBeanReader(br,CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);
			for (AncienTirage t = lecteur.read(AncienTirage.class, header, cellules); t != null; t = lecteur.read(AncienTirage.class, header, cellules))
				tirages.add(t);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			try {
				lecteur.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<?> getAllTirages(){

		return tirages;
	}

	private AncienTirage getTirage(double id) {
		for(AncienTirage t : tirages){
			if(t.getId()==id)
				return t;
		}
		
		return null;
		
	}

	public Object getTirage(double id,Class<Tirage> c) {
		if(c.equals(this))
			return getTirage(id);
		else
			return  new Object();
	
	}

}
