package fr.esiea.gl.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * 
 * Classe representant la barre principale du menu 
 * @author Akta
 *
 */
public class BarMenuPrincipale extends JMenuBar implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu[] menus;

	public BarMenuPrincipale() {

	}

	public void actionPerformed(ActionEvent e) {

		for (int j = 0; j < this.menus.length; j++) {
			for (int i = 0; i < this.menus[j].getMenuComponents().length; i++) {
				JMenuItem item = (JMenuItem) menus[j].getMenuComponents()[i];
				if (e.getSource().equals(item))
					ActionPanelFacade.getInstance().traiterAction(
							item.getText(),
							(FenetrePrincipale) getTopLevelAncestor());

			}
		}
	}

	public JMenu[] getMenus() {
		return menus;
	}

	public void setMenus(JMenu[] menus) {

		// Ajouter le listener.
		this.menus = menus;

		for (int j = 0; j < this.menus.length; j++) {
			for (int i = 0; i < this.menus[j].getMenuComponents().length; i++) {

				JMenuItem item = (JMenuItem) menus[j].getMenuComponents()[i];
				item.addActionListener(this);
			}
		}

	}

}
