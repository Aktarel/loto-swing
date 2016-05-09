package fr.esiea.gl.charts;

import java.util.HashMap;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import fr.esiea.gl.modele.TableModeleTirage;
import fr.esiea.gl.modele.Tirage;

/**
 * 
 * Panneau qui s'occupe d'afficher un nuage de point du nombre de fois où sont tombé les 50 n° du loto pour un rang n
 * @author Akta
 *
 */
public class NuageNumeroOccurence extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Constructeur
	 * @param titre - intitulé du graphique
	 * @param table - table avec l'ensemble des Tirages
	 * @param ordreNum - le rang n  
	 */
	public NuageNumeroOccurence(String titre, TableModeleTirage table,int ordreNum) {
		setName(titre);
	XYSeries serie = new XYSeries("Numéros");

	HashMap<Integer,Integer> nombreOccurenceBoule = new HashMap<Integer, Integer>();
	int b=0;
	for(Tirage tirage : table.getTirages()){
		
		switch (ordreNum) {
		case 1:
			b = tirage.getBoule1();
			break;
		case 2:
			b = tirage.getBoule2();
			break;
		case 3:
			b = tirage.getBoule3();
			break;
		case 4:
			b = tirage.getBoule4();
			break;
		case 5:
			b = tirage.getBoule5();
			break;
		}
		if(nombreOccurenceBoule.containsKey(b)){
			int occ = nombreOccurenceBoule.get(b);
			occ=occ+1;
			nombreOccurenceBoule.remove(b);
			nombreOccurenceBoule.put(b, occ);
		}
		else{
			nombreOccurenceBoule.put(b, 1);
		}
		
	}
	

	for(Integer clef : nombreOccurenceBoule.keySet())
		serie.add(nombreOccurenceBoule.get(clef),clef);
		
	XYSeriesCollection collection = new XYSeriesCollection(serie);
	JFreeChart chart = ChartFactory.createScatterPlot("Nuage de point des n° d'ordre "+ordreNum,"Occurrence du numéro "+ordreNum,"Numéros tombé à l'ordre "+ordreNum,collection,PlotOrientation.HORIZONTAL,true,true,false);
	add(new ChartPanel(chart));	
		
	}
	
}
