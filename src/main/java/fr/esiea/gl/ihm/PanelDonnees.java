package fr.esiea.gl.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.supercsv.exception.SuperCSVException;

import fr.esiea.gl.modele.TableModeleTirage;
import fr.esiea.gl.modele.Tirage;
import fr.esiea.gl.renderer.CombinaisonCellRenderer;
import fr.esiea.gl.renderer.DateTirageComparator;
import fr.esiea.gl.renderer.TypeTirageCellRenderer;

/**
 * 
 * Ce panneau permet l'affichage de la table des données.
 * 
 * @author Akta
 * 
 */
public class PanelDonnees extends JPanel {

	private static final long serialVersionUID = 1L;
	private TableModeleTirage modele;
	private JTable table;
	private JScrollPane scrollTable;
	private TableRowSorter<TableModel> sorter;
	private JPanel panneauEst;
	private PanelInfoTable panelInfo;
	
	public PanelDonnees(String titre, File ancienLoto, File nouveauLoto) {

		setLayout(new BorderLayout());
		try {
			modele = new TableModeleTirage(ancienLoto, nouveauLoto);

		} catch (SuperCSVException | IOException e) {
			e.printStackTrace();
		}
		table = new JTable(modele);
		scrollTable = new JScrollPane(table);
		sorter = new TableRowSorter<TableModel>(modele);

		config();
		setName(titre);
		add(panneauEst, BorderLayout.EAST);
		add(scrollTable, BorderLayout.CENTER);
	}

	public PanelDonnees(String titre, Tirage tirageVoulu) {

		setLayout(new BorderLayout());
		try {
			modele = new TableModeleTirage(new File("loto.csv"), new File(
					"nouveau_loto.csv"));

		} catch (SuperCSVException | IOException e) {
			e.printStackTrace();
		}
		table = new JTable(modele);
		scrollTable = new JScrollPane(table);
		sorter = new TableRowSorter<TableModel>(modele);

		
		config();
		setName(titre);
		add(panneauEst, BorderLayout.EAST);
		add(scrollTable, BorderLayout.CENTER);

	}

	private void config() {

		
		
		panelInfo = new PanelInfoTable();
		
		panneauEst = new JPanel(new BorderLayout());
		panneauEst.add(new PanelRecherche(modele),BorderLayout.SOUTH);
		panneauEst.add(panelInfo,BorderLayout.NORTH);
		
		table.getColumnModel().getColumn(0).setMinWidth(80);
		table.getColumnModel().getColumn(0)
				.setCellRenderer(new TypeTirageCellRenderer());
		table.getColumnModel().getColumn(5).setMinWidth(100);
		table.getColumnModel().getColumn(5)
				.setCellRenderer(new CombinaisonCellRenderer());
		table.setSelectionForeground(Color.WHITE);
		table.setSelectionBackground(Color.BLACK);
		// table.setColumnSelectionAllowed(true);
		table.setRowSelectionAllowed(true);
		table.setRowSorter(sorter);
		table.setPreferredScrollableViewportSize(new Dimension(800, 600));
		sorter.setComparator(3, new DateTirageComparator());
		sorter.setComparator(4, new DateTirageComparator());
		
		panelInfo.majNombreLigne(modele);
	}


	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	public PanelInfoTable getPanelInfo() {
		return panelInfo;
	}

	public void setPanelInfo(PanelInfoTable panelInfo) {
		this.panelInfo = panelInfo;
	}

}
