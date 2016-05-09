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
 * Façade permettant de gérer les actions du menu.
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
		case "Fréq d'apparition du n° par rang":
			fenetrePrincipale.ajouterOnglet("Pie", TypeOnglet.camembert);
			break;	
		case "Numéros tombés au rang n":
			fenetrePrincipale.ajouterOnglet("Nuage", TypeOnglet.nuage);
			break;	
		case "Préférences":
			fenetrePrincipale.ajouterOnglet("Options", TypeOnglet.options );
			break;	
		case "Mise à jour des données":
			try {
				
				/*
				 * Operationnel : permet de recupérer sur le serv le tirage du loto + dézipper
				 * J'evite de l'utiliser en entreprise car le proxy se vérrouille sur les tests.
				 * Le nom des fichiers =  loto.zip & loto.csv
				 * Nico
				 */
				
				System.setProperty("java.net.useSystemProxies", "true");
				ToolBox.getInstance().miseEnPlaceFichier("https://media.fdj.fr/generated/game/loto/loto.zip",new File(""),new File(""), "loto");
				ToolBox.getInstance().miseEnPlaceFichier("https://media.fdj.fr/generated/game/loto/nouveau_loto.zip",new File(""),new File(""),"nouveau_loto");
				
				fenetrePrincipale.ajouterOnglet("Données", TypeOnglet.donnees );
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "Importer":
			    fenetrePrincipale.ajouterOnglet("Données",TypeOnglet.importation);
			break;	
		case "Rechercher":
		    fenetrePrincipale.ajouterOnglet("Rechercher",TypeOnglet.rechercher);
		break;
		case "A propos de nous" :
			
			StringBuffer html = new StringBuffer();
			html.append("<html>");
			html.append("<h1>");
			html.append("Projet réalisé par 6 étudiants passionnés de l'ESIEA 3A-CFA");
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
