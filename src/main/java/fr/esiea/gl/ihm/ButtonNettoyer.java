package fr.esiea.gl.ihm;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ButtonNettoyer extends AbstractAction  {

	
	
	/**
	 * 
	 */
	public ButtonNettoyer(String titre) {

		super(titre);
		
	}
	
	private static final long serialVersionUID = 1L;

	public void actionPerformed(ActionEvent e) {

		System.gc();
		
	}

}
