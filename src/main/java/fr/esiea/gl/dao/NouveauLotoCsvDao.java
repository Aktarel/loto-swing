package fr.esiea.gl.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.Token;
import org.supercsv.cellprocessor.Trim;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import fr.esiea.gl.modele.NouveauTirage;
import fr.esiea.gl.modele.Tirage;


/**
 * Data Access Object du csv nouveau loto
 * @author lebec
 *
 */

public class NouveauLotoCsvDao implements LotoDao {

	private List<NouveauTirage> tirages = new ArrayList<NouveauTirage>();
	private BufferedReader br;
	private CsvBeanReader lecteur;
	private String[] header = { "id", "jourTirage",
			"dateTirage","dateForclusion","boule1", "boule2", "boule3",
			"boule4", "boule5", "numero_chance", "numeros",
			"nbGagnantRang1", "rapportRang1",
			"nbGagnantRang2", "rapportRang2", "nbGagnantRang3",
			"rapportRang3", "nbGagnantRang4", "rapportRang4",
			"nbGagnantRang5", "rapportRang5", "nbGagnantRang6",
			"rapportRang6",	"numeroJokerPlus", "devise" };
	private CellProcessor[] cellules;
	
	

	public NouveauLotoCsvDao(File fichier) {
		try {
			
			br = new BufferedReader(new FileReader(fichier));
			//br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(nomFichier)));
			// Evitez le debut du fichier (en tête)
			br.skip(454);
			cellules = new CellProcessor[] { new ParseDouble(),
					null,null, new Token("", "00000000"),
					new ParseInt(), new ParseInt(), new ParseInt(), 
					new ParseInt(), new ParseInt(),new ParseInt(),  new Trim(18),
					new ParseDouble(), null, new ParseDouble(),
					null, new ParseDouble(), null, new ParseDouble(), null,
					new ParseDouble(), null, new ParseDouble(), null, new Token("", "0"), null };

			lecteur = new CsvBeanReader(br,CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);
			for (NouveauTirage t = lecteur.read(NouveauTirage.class, header, cellules); t != null; t = lecteur.read(NouveauTirage.class, header, cellules))
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


	public NouveauLotoCsvDao() {
		
	try {
				
				br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/nouveau_loto.csv")));
				//br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(nomFichier)));
				// Evitez le debut du fichier (en tête)
				br.skip(454);
				cellules = new CellProcessor[] { new ParseDouble(),
						null,null, new Token("", "00000000"),
						new ParseInt(), new ParseInt(), new ParseInt(), 
						new ParseInt(), new ParseInt(),new ParseInt(),  new Trim(18),
						new ParseDouble(), null, new ParseDouble(),
						null, new ParseDouble(), null, new ParseDouble(), null,
						new ParseDouble(), null, new ParseDouble(), null, new Token("", "0"), null };
	
				lecteur = new CsvBeanReader(br,CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);
				for (NouveauTirage t = lecteur.read(NouveauTirage.class, header, cellules); t != null; t = lecteur.read(NouveauTirage.class, header, cellules))
					tirages.add(t);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
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

	public NouveauTirage getTirage(double id) {
		for(NouveauTirage t : tirages){
			if(t.getId()==id)
				return t;
		}
		
		return null;
		
	}


	public Object getTirage(double id, Class<Tirage> c) {
		if(c.equals(NouveauTirage.class))
			return getTirage(id);
		return new Object();
	}
}
