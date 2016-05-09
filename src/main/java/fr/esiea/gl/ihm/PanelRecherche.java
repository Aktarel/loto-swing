package fr.esiea.gl.ihm;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.joda.time.LocalDate;

import com.toedter.calendar.JDateChooser;

import fr.esiea.gl.modele.TableModeleTirage;
import fr.esiea.gl.modele.Tirage;

public class PanelRecherche extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private JLabel[] labels;
	private static final String[] titreLabels = { "Filtrer tirage",
			"Date n°1:", "Date n°2:" };
	private JDateChooser dateChooserBefore, dateChooserSup;
	private Font f;
	private JButton buttonMAJ;
	private ComboChoixDate comboChoixDate;
	private TableModeleTirage modele;
	
	public PanelRecherche(TableModeleTirage modele) {
		
		this.modele = modele;
		config();
	}
	
	public void config(){
		
		labels = new JLabel[titreLabels.length];
		dateChooserBefore = new JDateChooser();
		dateChooserSup = new JDateChooser();
		dateChooserSup.setEnabled(false);

		comboChoixDate = new ComboChoixDate(this);

		buttonMAJ = new JButton("Filtrer!");
		buttonMAJ.addActionListener(this);
		dateChooserBefore.setPreferredSize(new Dimension(120, 20));
		dateChooserSup.setPreferredSize(new Dimension(120, 20));

		f = new Font("Arial", Font.PLAIN, 14);

		for (int i = 0; i < titreLabels.length; i++) {
			labels[i] = new JLabel(titreLabels[i]);
			labels[i].setFont(f);
		}

		labels[0].setFont(new Font("Arial", Font.ITALIC, 18));
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		setLayout(gbl);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(10, 10, 10, 10);
		add(labels[0], gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(20, 10, 20, 10);
		add(labels[1], gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(20, 10, 20, 10);
		add(dateChooserBefore, gbc);

		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		add(comboChoixDate, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(20, 10, 10, 10);
		add(labels[2], gbc);

		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(20, 10, 20, 10);
		add(dateChooserSup, gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(0, 10, 20, 10);
		add(buttonMAJ, gbc);

		gbl.setConstraints(this, gbc);
	}

	public JDateChooser getDateChooserBefore() {
		return dateChooserBefore;
	}

	public JDateChooser getDateChooserSup() {
		return dateChooserSup;
	}
	
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == buttonMAJ) {

			LocalDate d = new LocalDate(dateChooserBefore.getDate());
			LocalDate d2 = new LocalDate(dateChooserSup.getDate());
			List<Tirage> list = new ArrayList<>();
			
			/*Ne pas opérer directement sur modele.getTirages() qui m'a pas l'air threadSafe */
			for(Tirage t : modele.getTirages())
				list.add(t);
			
			switch (comboChoixDate.getSelectedIndex()) {
			case 1:
				for(Tirage t : list){
					if(!d.isAfter(t.getDateTirage()))
						modele.supprimerTirage(t);
				}
				break;
			case 2:
				for(Tirage t : list){
					if(!d.isBefore(t.getDateTirage()))
						modele.supprimerTirage(t);
				}
				break;
			case 3:
				for(Tirage t : list){
					if(!d.isEqual(t.getDateTirage()))
						modele.supprimerTirage(t);
				}
				break;
			case 4:
				for(Tirage t : list){
					if(!d.isBefore(t.getDateTirage()) || !d2.isAfter(t.getDateTirage()))
						modele.supprimerTirage(t);
				}
				break;
			case 5:
				modele.nettoyer();
				modele.charger();
				break;
			default:
				break;
			}

			FenetrePrincipale f = (FenetrePrincipale) getTopLevelAncestor();
			f.getDataPanel().getPanelInfo().majNombreLigne(modele);

		}

	}

}
