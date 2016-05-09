package fr.esiea.gl.ihm;

import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fr.esiea.gl.modele.TypeOnglet;
import fr.esiea.gl.util.ToolBox;

/**
 * 
 * 
 * Fa�ade permettant de g�rer les actions du menu.
 * @author lebec
 * 
 *
 */
public class ActionPanelFacade {

	
	public static ActionPanelFacade instance;
	
	public static ActionPanelFacade getInstance(){
		if(instance!=null)
			return instance;
		else
			return new ActionPanelFacade();
	}

	private ActionPanelFacade(){;}
	
	public void traiterAction(String text,FenetrePrincipale fenetrePrincipale) {
		switch (text) {
		case "Quitter":
			System.exit(0);
			break;
		case "Aff somme gagnant par rang":
			fenetrePrincipale.ajouterOnglet("Bar plot", TypeOnglet.barreplot);
			break;
		case "Fr�q d'apparition du n� par rang":
			fenetrePrincipale.ajouterOnglet("Pie", TypeOnglet.camembert);
			break;	
		case "Num�ros tomb�s au rang n":
			fenetrePrincipale.ajouterOnglet("Nuage", TypeOnglet.nuage);
			break;	
		case "Pr�f�rences":
			fenetrePrincipale.ajouterOnglet("Options", TypeOnglet.options );
			break;	
		case "Mise � jour des donn�es":
			try {
				
				/*
				 * Operationnel : permet de recup�rer sur le serv le tirage du loto + d�zipper
				 * J'evite de l'utiliser en entreprise car le proxy se v�rrouille sur les tests.
				 * Le nom des fichiers =  loto.zip & loto.csv
				 * Nico
				 */
				
				System.setProperty("java.net.useSystemProxies", "true");
				ToolBox.getInstance().miseEnPlaceFichier("https://media.fdj.fr/generated/game/loto/loto.zip",new File(""),new File(""), "loto");
				ToolBox.getInstance().miseEnPlaceFichier("https://media.fdj.fr/generated/game/loto/nouveau_loto.zip",new File(""),new File(""),"nouveau_loto");
				
				fenetrePrincipale.ajouterOnglet("Donn�es", TypeOnglet.donnees );
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "Importer":
			    fenetrePrincipale.ajouterOnglet("Donn�es",TypeOnglet.importation);
			break;	
		case "Rechercher":
		    fenetrePrincipale.ajouterOnglet("Rechercher",TypeOnglet.rechercher);
		break;
		case "A propos de nous" :
			
			StringBuffer html = new StringBuffer();
			html.append("<html>");
			html.append("<h1>");
			html.append("Projet r�alis� par 6 �tudiants passionn�s de l'ESIEA 3A-CFA");
			html.append("</h1>");
			html.append("<hr>");
			html.append("<br>");
			html.append("<h2><center>");
			html.append("Nicolas LEBEC - lebec@et.esiea.fr");
			html.append("<br>");
			html.append("Lino AUGEARD - augeard@et.esiea.fr");
			html.append("<br>");
			html.append("Yacine RESSAD - ressad@et.esiea.fr");
			html.append("<br>");
			html.append("Remy OUADAH - ouadah@et.esiea.fr");
			html.append("<br>");
			html.append("Mathieu GUILPIN - guilpin@et.esiea.fr");
			html.append("<br>");
			html.append("Allan AHRES - ahres@et.esiea.fr");
			html.append("</h2></center>");
			html.append("</html>");
			
			JOptionPane.showMessageDialog(null,
					html.toString(),
				    "A propos de nous",
				    JOptionPane.INFORMATION_MESSAGE,
				    new ImageIcon(getClass().getResource("/esiea.png")));
			break;
		
		default:
			break;

		}
	}

}
