package fr.esiea.gl.ihm;

import javax.swing.JTabbedPane;

/**
 *Representation du menu d'onglet customizé pour ajouter la petite croix et fermer un onglet à la fois. 
 *@author Akta
 **/
public class OngletsFenPrinci extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	public OngletsFenPrinci() {
	}

	  private void initTabComponent(int i) {
	        setTabComponentAt(i, new ButtonTabComponent(this));
	  
	 }
	  
	 public void updateTabbed(){
		  for (int i = 0; i < getTabCount(); i++) {
              initTabComponent(i);
		  }
	  }



	    
	  
	       
}
