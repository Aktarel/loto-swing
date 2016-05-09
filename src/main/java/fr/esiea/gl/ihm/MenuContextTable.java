package fr.esiea.gl.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


/**
 * 
 * Menu contextuel encore inutile
 * @author Akta
 *
 */
public class MenuContextTable extends JPopupMenu implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JMenuItem menu1,menu2,menu3,menu4,menu5,menu6;
	
	public MenuContextTable(String label) {
		super(label);
		menu1 = new JMenuItem("Mathieu GUILPIN");
		menu2 = new JMenuItem("Lino AUGEARD");
		menu3 = new JMenuItem("Yacine RESSAD");
		menu4 = new JMenuItem("Remy OUADHAH");
		menu5 = new JMenuItem("Allan AHRES");
		menu6 = new JMenuItem("Nicolas LEBEC");
		add(menu1);
		add(menu2);
		add(menu3);
		add(menu4);
		add(menu5);
		add(menu6);
		menu1.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(menu1)){
			//FenetrePrincipale f = (FenetrePrincipale) getTopLevelAncestor();
			
			
		}
		
	}

}
