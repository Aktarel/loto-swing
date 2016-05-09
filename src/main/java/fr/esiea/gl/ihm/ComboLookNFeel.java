package fr.esiea.gl.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import fr.esiea.gl.modele.LookNFeel;

/**
 * Classe qui represente la combobox des options et qui permet de modifier le look Swing de l'application
 * 
 * @author Akta
 *
 */

public class ComboLookNFeel extends JComboBox<LookNFeel> implements
		ItemListener, ActionListener {
	
	private static final long serialVersionUID = 1L;
	public ComboLookNFeel() {

		LookNFeel[] comboItems = { LookNFeel.smartFeel, LookNFeel.nimbus,
				LookNFeel.jgoodies01, LookNFeel.jgoodies02,
				LookNFeel.jgoodies03, LookNFeel.jgoodies04,  LookNFeel.windowsSeven};

		for (LookNFeel s : comboItems) {
			addItem(s);
		}

		addItemListener(this);
		addActionListener(this);

	}

	public void itemStateChanged(ItemEvent e) {

	}

	public void actionPerformed(ActionEvent e) {

		if (this.getSelectedItem() == LookNFeel.smartFeel) {
			try {
				UIManager.setLookAndFeel(LookNFeel.smartFeel.getLabel());
				SwingUtilities
						.updateComponentTreeUI((FenetrePrincipale) getTopLevelAncestor());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}

		} else if (this.getSelectedItem() == LookNFeel.nimbus) {
			try {
				UIManager.setLookAndFeel(LookNFeel.nimbus.getLabel());
				SwingUtilities
						.updateComponentTreeUI((FenetrePrincipale) getTopLevelAncestor());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
		} else if (this.getSelectedItem() == LookNFeel.jgoodies01) {
			try {
				UIManager.setLookAndFeel(LookNFeel.jgoodies01.getLabel());
				SwingUtilities
						.updateComponentTreeUI((FenetrePrincipale) getTopLevelAncestor());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
		} else if (this.getSelectedItem() == LookNFeel.jgoodies02) {
			try {
				UIManager.setLookAndFeel(LookNFeel.jgoodies02.getLabel());
				SwingUtilities
						.updateComponentTreeUI((FenetrePrincipale) getTopLevelAncestor());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
		} else if (this.getSelectedItem() == LookNFeel.jgoodies03) {
			try {
				UIManager.setLookAndFeel(LookNFeel.jgoodies03.getLabel());
				SwingUtilities
						.updateComponentTreeUI((FenetrePrincipale) getTopLevelAncestor());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (this.getSelectedItem() == LookNFeel.jgoodies04) {
			try {
				UIManager.setLookAndFeel(LookNFeel.jgoodies04.getLabel());
				SwingUtilities
						.updateComponentTreeUI((FenetrePrincipale) getTopLevelAncestor());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (this.getSelectedItem() == LookNFeel.windowsSeven){
			try {
				UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
			SwingUtilities.updateComponentTreeUI((FenetrePrincipale) getTopLevelAncestor());
		}
	}

}
