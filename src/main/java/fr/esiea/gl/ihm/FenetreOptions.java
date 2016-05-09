package fr.esiea.gl.ihm;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreOptions extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private JPanel panelGauche,panelDroite;
	
	public FenetreOptions(JFrame parent,String titre,boolean modal){
		
		super(parent,titre,modal);
		setLayout(new BorderLayout());
		
		panelGauche=new JPanel();
		panelDroite=new JPanel();
		
		panelGauche.add(new ComboLookNFeel());
		
		add(panelDroite,BorderLayout.EAST);
		add(panelGauche,BorderLayout.WEST);
		
		setLocationRelativeTo(parent);
		setSize(450,300);
		setVisible(true);
	}
	
	

}
