package fr.esiea.gl.ihm;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.esiea.gl.modele.AncienTirage;
import fr.esiea.gl.modele.TableModeleTirage;
import fr.esiea.gl.modele.Tirage;

public class PanelInfoTable extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nombreLigneTotal;
	private JLabel nbLigneAncienT;
	private JLabel nbLigneNouveauT;
	private Font fontLabel;
	
	public PanelInfoTable() {
		
		fontLabel = new Font("Arial",Font.PLAIN,18);
		
		setLayout(new GridLayout(3,2));
		
		nombreLigneTotal = new JLabel();
		nbLigneAncienT = new JLabel();
		nbLigneNouveauT = new JLabel();
		
		nombreLigneTotal.setFont(fontLabel);
		nbLigneAncienT.setFont(fontLabel);
		nbLigneNouveauT.setFont(fontLabel);
		
		
		add(new JLabel("   Nombre Ligne    :"));
		add(nombreLigneTotal);
		add(new JLabel("   Ancien Tirage    :"));
		add(nbLigneAncienT);
		add(new JLabel("   Nouveau Tirage   :"));
		add(nbLigneNouveauT);
		
	}


	

	public void majNombreLigne(TableModeleTirage modele){
		
		int nbAncienTirage = 0 ,nbNouveauTirage = 0;
		for(Tirage t : modele.getTirages()){
			if(t.getClass().equals(AncienTirage.class))
				nbAncienTirage++;
			else
				nbNouveauTirage++;
		}
		
		nombreLigneTotal.setText(String.valueOf(modele.getRowCount()));
		nbLigneAncienT.setText(String.valueOf(nbAncienTirage));
		nbLigneNouveauT.setText(String.valueOf(nbNouveauTirage));
	}
	
}
