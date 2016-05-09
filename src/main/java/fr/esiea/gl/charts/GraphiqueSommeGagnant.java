package fr.esiea.gl.charts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import fr.esiea.gl.modele.TableModeleTirage;
import fr.esiea.gl.modele.AncienTirage;
import fr.esiea.gl.modele.Tirage;

/**
 * 
 * Panneau qui regroupe un graphique de barre. Ce graphique represente
 * la somme pour un rang n des gagnants par année.
 * @author Akta
 *
 */

public class GraphiqueSommeGagnant extends JPanel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2781272303346122440L;
	private HashMap<Double, Double> sommeParAnnee;
	private double anneePrecedente;
	private double sommeX;
	
	
/**
 * 
 * Constructeur
 * @param titre - intitulé du graphique
 * @param modele - la table avec les objets de type Tirage
 * @param rang - le rang dont on souhaite connaitre le nombre de gagnant par année.
 */
	
	public GraphiqueSommeGagnant(String titre,TableModeleTirage modele,int rang)  {

		setLayout(new BorderLayout());
		setName(titre);
		List<Tirage> tirages = modele.getTirages();
		sommeParAnnee = new HashMap<Double, Double>();
		XYSeries serie = new XYSeries("Nb Gagnant R"+rang);
		
		
		
		for (Tirage tirage : tirages){
			
			double anneeTirage=tirage.getDateTirage().getYear();
			
			switch (rang) {
			case 1:
				sommeX=sommeX+tirage.getNbGagnantRang1();
				break;
			case 2:
				sommeX=sommeX+tirage.getNbGagnantRang2();
				break;
			case 3:
				sommeX=sommeX+tirage.getNbGagnantRang3();
				break;
			case 4:
				sommeX=sommeX+tirage.getNbGagnantRang4();
				break;
			case 5:
				sommeX=sommeX+tirage.getNbGagnantRang5();
				break;
			case 6:
				sommeX=sommeX+tirage.getNbGagnantRang6();
				break;
			case 7:
				if(tirage.getClass().equals(AncienTirage.class))
					sommeX=sommeX+((AncienTirage) tirage).getNbGagnantRang7();
				break;
			}
			
			if(anneePrecedente!=anneeTirage){
				sommeParAnnee.put(anneeTirage,sommeX);
				anneePrecedente=anneeTirage;
				sommeX=0;
				
			}
			else{
				anneePrecedente=tirage.getDateTirage().getYear();
			}
				
			
		}
			
			
		for (Double clef : sommeParAnnee.keySet())
			serie.add(clef,sommeParAnnee.get(clef));
	
		XYSeriesCollection collection = new XYSeriesCollection(serie);
		JFreeChart barMoyenneGagnant = ChartFactory.createXYBarChart(
				"Somme des gagnants rang "+rang+" par année", "Années", 
				true, "Nombre Gagnant", collection, PlotOrientation.VERTICAL, true,
				true, false);
		
		XYPlot plot = barMoyenneGagnant.getXYPlot();
		//XYItemRenderer renderer = plot.getRenderer();
		//renderer.setBaseSeriesVisible(false);
		
		
		plot.setBackgroundPaint(Color.LIGHT_GRAY);
		plot.setRangeGridlinePaint(Color.WHITE);
		
		
		ChartPanel p = new ChartPanel(barMoyenneGagnant);
		add(p,BorderLayout.CENTER);
	}





	
}
