package fr.esiea.gl.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

public class ComboChoixDate extends JComboBox<String> implements
		ItemListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] comboItems = {	"Choisissez !"," < - Inférieur"," > - Supérieur"," = - Equivalent","< > - Entre les deux","Recharger"};
	private PanelRecherche parent;
	
	public ComboChoixDate(PanelRecherche panelRecherche) {

		for (String s : comboItems) {
			addItem(s);
		}
		addItemListener(this);
		addActionListener(this);
		parent = panelRecherche;
	}

	public void itemStateChanged(ItemEvent e) {
		

	}
	public void actionPerformed(ActionEvent e) {
		
	
		if(getSelectedItem()==comboItems[0]){
			parent.getDateChooserSup().setEnabled(false);
			parent.getDateChooserBefore().setEnabled(false);
		}
		if(getSelectedItem()==comboItems[1]){
			parent.getDateChooserSup().setEnabled(false);
			parent.getDateChooserBefore().setEnabled(true);
		}
		if(getSelectedItem()==comboItems[2]){
			parent.getDateChooserSup().setEnabled(false);
			parent.getDateChooserBefore().setEnabled(true);
		}
		if(getSelectedItem()==comboItems[3]){
			parent.getDateChooserSup().setEnabled(false);
			parent.getDateChooserBefore().setEnabled(true);
		}
		if(getSelectedItem()==comboItems[4]){
			parent.getDateChooserBefore().setEnabled(true);
			parent.getDateChooserSup().setEnabled(true);
		}
		if(getSelectedItem()==comboItems[5]){
			parent.getDateChooserBefore().setEnabled(false);
			parent.getDateChooserSup().setEnabled(false);
		}
	}

}
