package fr.esiea.gl.ihm;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.KeyStroke;

import org.supercsv.exception.SuperCSVException;
import org.supercsv.exception.SuperCSVReflectionException;

import fr.esiea.gl.charts.GraphiqueOccurenceNumero;
import fr.esiea.gl.charts.GraphiqueSommeGagnant;
import fr.esiea.gl.charts.NuageNumeroOccurence;
import fr.esiea.gl.modele.TableModeleTirage;
import fr.esiea.gl.modele.TypeOnglet;
import fr.esiea.gl.util.FiltreFichierCsv;

/**
 * Fenetre principale qui regroupe tout les composants swing :
 * <ul>
 * <li>Gestionnaire d'onglet</li>
 * <ul>
 * <li>Tableau de données</li>
 * <li>Statistiques </li>
 * </ul>
 * <ul>
 * <li>Bar de menu principale</li>
 * <ul>
 * <li>Les menus - ouvrir / graphique et options</li>
 * </ul>
 * </ul>
 * 
 * 
 * @author lebec
 * @since 16/02/2012
 */

public class FenetrePrincipale extends JFrame {

	private static final long serialVersionUID = 5613359393456628389L;
	
	// Mes labels
	private static final String[] titresOnglet = { "Données" };
	private static final String[] titresMenu = { "Fichiers", "Graphiques", "Fonctions",
			"Options" };
	private static final String[] titresMenuFichier = { "Importer", "Quitter" };
	private static final String[] titresMenuGraphique = {"Aff somme gagnant par rang", "Fréq d'apparition du n° par rang",
			"Numéros tombés au rang n" };
	private static final String[] titresMenuOption = {
			 "Préférences","A propos de nous" };
	private static final String[] titresMenuFonction = { "Rechercher","Mise à jour des données" };
	// Référence composants
	private JPanel buttonsPanel, panelPrincipal;
	private PanelDonnees dataPanel;
	private OngletsFenPrinci ongletsFenPrinci;
	private BarMenuPrincipale menu;
	private JMenu[] menus;
	private JMenuItem[] menuFichierItems, menuGraphiqueItems, menuOptionItems,menuFonctionItems;
	//private MenuContextTable popup;
	private JTable table;
	private TableModeleTirage modele;

	private JFileChooser chooser;

	public FenetrePrincipale(String title) throws SuperCSVReflectionException,
			SuperCSVException, IOException {

		super(title);
		setIconImage(new ImageIcon(this.getClass().getResource("/mainicon.png")).getImage());
		// Initialisation des composants swings
		initialisation();
		
		// Ajout raccourcis pour le bouton quitter
		menuFichierItems[1].setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_F4, Event.ALT_MASK));
		menu.setMenus(menus);

		// Ajout de n onglets au gestionnaire d'onglet jtp & MAJ des panneaux
		// fermables
		ongletsFenPrinci.add(dataPanel, 0);
		ongletsFenPrinci.setSize(300, 300);
		ongletsFenPrinci.updateTabbed();

		// Chaque onglet prend un titre qui lui correspond
		for (int i = 0; i < titresOnglet.length; i++)
			ongletsFenPrinci.setTitleAt(i, titresOnglet[i]);

		// Ajout des boutons
		buttonsPanel.add(new ComboLookNFeel());

		// Configuration de la fenetre et ajout du gestionnaire de panneau
		panelPrincipal.add(ongletsFenPrinci, BorderLayout.EAST);
		panelPrincipal.add(menu, BorderLayout.NORTH);
		add(panelPrincipal);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
		setResizable(false);

		pack();

	}

	/**
	 * Méthode pour cacher l'instanciation des objets & composants swing
	 * 
	 * @author lebec
	 * @since 16/02/2012
	 * 
	 */

	private void initialisation() throws SuperCSVReflectionException,
			SuperCSVException, IOException {

		panelPrincipal = new JPanel(new BorderLayout());
		dataPanel = new PanelDonnees("Données",new File("loto.csv"),new File("nouveau_loto.csv"));
		table = dataPanel.getTable();
		modele = (TableModeleTirage) table.getModel();
		buttonsPanel = new JPanel();
		ongletsFenPrinci = new OngletsFenPrinci();

		menus = new JMenu[titresMenu.length];
		menuFichierItems = new JMenuItem[titresMenuFichier.length];
		menuGraphiqueItems = new JMenuItem[titresMenuGraphique.length];
		menuFonctionItems = new JMenuItem[titresMenuFonction.length];
		menuOptionItems = new JMenuItem[titresMenuOption.length];
		menu = new BarMenuPrincipale();

		// On set les titre pour tout les menus et on les instancie
		for (int i = 0; i < menus.length; i++)
			menus[i] = new JMenu(titresMenu[i]);
		for (int j = 0; j < menuFichierItems.length; j++)
			menuFichierItems[j] = new JMenuItem(titresMenuFichier[j]);
		for (int j = 0; j < menuGraphiqueItems.length; j++)
			menuGraphiqueItems[j] = new JMenuItem(titresMenuGraphique[j]);
		for (int j = 0; j < menuFonctionItems.length; j++)
			menuFonctionItems[j] = new JMenuItem(titresMenuFonction[j]);
		for (int i = 0; i < menuOptionItems.length; i++)
			menuOptionItems[i] = new JMenuItem(titresMenuOption[i]);

		// On les emboitent
		for (int i = 0; i < menus.length; i++)
			menu.add(menus[i]);
		for (int j = 0; j < menuFichierItems.length; j++)
			menus[0].add(menuFichierItems[j]);
		for (int j = 0; j < menuGraphiqueItems.length; j++)
			menus[1].add(menuGraphiqueItems[j]);
		for (int j = 0; j < menuFonctionItems.length; j++)
			menus[2].add(menuFonctionItems[j]);
		for (int j = 0; j < menuOptionItems.length; j++)
			menus[3].add(menuOptionItems[j]);

		// Système d'image dans les menus - recupération dans l'archive des images PNG
		menuFichierItems[0].setIcon(new ImageIcon(getClass().getResource("/open.png")));
		menuFichierItems[1].setIcon(new ImageIcon(getClass().getResource("/quit.png")));
		menuGraphiqueItems[2].setIcon(new ImageIcon(getClass().getResource("/linechart.png")));
		menuGraphiqueItems[1].setIcon(new ImageIcon(getClass().getResource("/pie.png")));
		menuGraphiqueItems[0].setIcon(new ImageIcon(getClass().getResource("/barplot.png")));
		menuFonctionItems[0].setIcon(new ImageIcon(getClass().getResource("/search.png")));
		menuFonctionItems[1].setIcon(new ImageIcon(getClass().getResource("/update.png")));
		menuOptionItems[0].setIcon(new ImageIcon(getClass().getResource("/options.png")));
		menuOptionItems[1].setIcon(new ImageIcon(getClass().getResource("/about.png")));

		// Configuration Popmenu
		/*popup = new MenuContextTable("MenuContextuel");
		MouseListener popupListener = new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				maybeShowPopup(e);
			}

			private void maybeShowPopup(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		};
		table.addMouseListener(popupListener);*/

	}

	/**
	 * 
	 * Méthode permettant d'ajouter un onglet dans la fenetre principale.
	 * @param titre - titre du composant swing
	 * @param typeOnglet - le type d'onglet venant de l'enumeration TypeOnglet
	 */
	
	public void ajouterOnglet(String titre, TypeOnglet typeOnglet) {

		switch (typeOnglet) {
		case barreplot: {
			String reponse = (String) JOptionPane.showInputDialog(null,
					"Quel rang voulez afficher ? n = [1,7]",
					"Afficher la somme des gagnants au rang n par année",
					JOptionPane.PLAIN_MESSAGE, null, null, "1");
			
			if(reponse!=null){
			ongletsFenPrinci.add(new GraphiqueSommeGagnant(titre + " n°"
					+ reponse, modele, Integer.valueOf(reponse)),
					ongletsFenPrinci.getTabCount());
			ongletsFenPrinci
					.setSelectedIndex(ongletsFenPrinci.getTabCount() - 1);
			}
			break;
		}
		case camembert: {
			String reponse = (String) JOptionPane.showInputDialog(null,
					"Quel numéro voulez vous afficher ? n = [1,49] ",
					"Fréquence d'apparition du numéro n par rang",
					JOptionPane.PLAIN_MESSAGE, null, null, "27");
			if(reponse!=null){
			ongletsFenPrinci.add(new GraphiqueOccurenceNumero(titre + " n°"
					+ reponse, modele, Integer.parseInt(reponse)),
					ongletsFenPrinci.getTabCount());
			ongletsFenPrinci
					.setSelectedIndex(ongletsFenPrinci.getTabCount() - 1);
			}
			break;
		}
		case nuage: {
			String reponse = (String) JOptionPane.showInputDialog(null,
					"Quel rang voulez vous afficher ? n = [1,7] ",
					"Vision globale des numéros tombé au rang n",
					JOptionPane.PLAIN_MESSAGE, null, null, "1");
			if(reponse!=null){
			ongletsFenPrinci.add(new NuageNumeroOccurence(titre + " n°"
					+ reponse, modele, Integer.parseInt(reponse)),
					ongletsFenPrinci.getTabCount());
			ongletsFenPrinci
					.setSelectedIndex(ongletsFenPrinci.getTabCount() - 1);
			}
			break;
		}
		case options: {
			ongletsFenPrinci.add(PanelOption.getInstance(),
					ongletsFenPrinci.getTabCount());
			ongletsFenPrinci
					.setSelectedIndex(ongletsFenPrinci.getTabCount() - 1);
			break;
		}
		case donnees: {
			ongletsFenPrinci.add(new PanelDonnees("Données",new File("loto.csv"),new File("nouveau_loto.csv")),
					ongletsFenPrinci.getTabCount());
			ongletsFenPrinci
					.setSelectedIndex(ongletsFenPrinci.getTabCount() - 1);
			break;
		}
		case importation: {
			chooser = new JFileChooser();
			FiltreFichierCsv filtre = new FiltreFichierCsv();
			chooser.setFileFilter(filtre);
			chooser.setMultiSelectionEnabled(true);
			int returnVal = chooser.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				
				File[] selection = chooser.getSelectedFiles();
				ongletsFenPrinci.add(new PanelDonnees("Données",selection[0], selection[1]), ongletsFenPrinci.getTabCount());
				ongletsFenPrinci.setSelectedIndex(ongletsFenPrinci.getTabCount() - 1);
			}
			break;

		}
		case rechercher: {
			ongletsFenPrinci.add(new PanelDonnees("Rechercher",new File("loto.csv"),new File("nouveau_loto.csv")));
			ongletsFenPrinci.setSelectedIndex(ongletsFenPrinci.getTabCount() - 1);
			break;
		}
		}

		// Mettre a jour les tableaux
		ongletsFenPrinci.updateTabbed();
		pack();
	}
	
	
	public PanelDonnees getDataPanel() {
		return dataPanel;
	}


}
