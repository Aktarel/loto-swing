package fr.esiea.gl.charts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import fr.esiea.gl.modele.TableModeleTirage;
import fr.esiea.gl.modele.Tirage;


/**
 * 
 * Panneau d'affichage d'un camembert qui calcule en pourcentage le nombre de fois qu'un numéro est tombé par rapport au rang .
 * 
 * @author Akta
 * @version 1.1
 * @date 01/05/216 
 */
public class GraphiqueOccurenceNumero extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur 
	 * Ex: je choisis 27 -> je vais voir un camembert qui m'affiche pour chaque rang combien de fois tombe le numéro 27 dans tout les tirages du loto
	 * @param titre - le nom du graphique avec affichage du numéro
	 * @param table - la table de donnée avec l'ensemble des objets Tirage 
	 * @param numero - le numéro que l'on veut afficher
	 */
	public GraphiqueOccurenceNumero(String titre, TableModeleTirage table,int numero ) {
	
	setName("Pie pour n°"+numero);
	DefaultPieDataset dataset = new DefaultPieDataset();
	HashMap<Integer,Integer> nombreOccurenceBoule = new HashMap<Integer, Integer>();
	
	for(Tirage tirage : table.getTirages()){
		
		//combinaison triée :s
		//List<Integer> combinaison = tirage.getNumeros();
		
		List<Integer> combinaison = new ArrayList<Integer>();
		for(int i=1;i<8;i++){
			switch (i) {
			case 1:
				combinaison.add(tirage.getBoule1());
				break;
			case 2:
				combinaison.add(tirage.getBoule2());
				break;
			case 3:
				combinaison.add(tirage.getBoule3());
				break;
			case 4 :
				combinaison.add(tirage.getBoule4());
				break;
			case 5:
				combinaison.add(tirage.getBoule5());
				break;
			}
		
			
		}
		
		if(combinaison.contains(numero)){
			int index = combinaison.indexOf(numero);
			if(nombreOccurenceBoule.containsKey(index)){
				int occ = nombreOccurenceBoule.get(index);
				occ++;
				nombreOccurenceBoule.remove(index);
				nombreOccurenceBoule.put(index,occ);
			}
			else{
				nombreOccurenceBoule.put(index,1);
			}
		}
	
	}
	

	for(Integer clef : nombreOccurenceBoule.keySet())
		dataset.setValue(numero+" est tombé x fois à l'ordre "+(clef+1),nombreOccurenceBoule.get(clef));
		
	
	JFreeChart chart = ChartFactory.createPieChart3D("Combien de fois est tombé "+numero+" par ordre ",dataset, true,false, false);
	add(new ChartPanel(chart));	
		
	}
	
	
	

}
