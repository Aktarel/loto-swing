package fr.esiea.gl.modele;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import org.joda.time.LocalDate;
import org.supercsv.exception.SuperCSVException;
import org.supercsv.exception.SuperCSVReflectionException;

import fr.esiea.gl.dao.AncienLotoCsvDao;
import fr.esiea.gl.dao.LotoDao;
import fr.esiea.gl.dao.NouveauLotoCsvDao;
import fr.esiea.gl.util.ToolBox;

/**
 * 
 * Table de l'interface homme-machine qui regroupe tout les tirages (Ancien+Nouveau loto)
 * @author Akta
 *
 */
public class TableModeleTirage extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7558826546249028482L;
	private Vector<Tirage> tirages = new Vector<>();
	private String[] header = { "Id", "N°T", "Jour du tirage",
			"Date du tirage", "Date de forclusion","Numéros","Gagnant R1" };
	private LotoDao olcd,nlcd;
	
	public TableModeleTirage(File file,File file2) throws SuperCSVReflectionException,
			SuperCSVException, IOException {
		
		
		ToolBox.getInstance().miseEnPlaceFichier("https://media.fdj.fr/generated/game/loto/loto.zip",new File(""),new File(""), "loto");
		ToolBox.getInstance().miseEnPlaceFichier("https://media.fdj.fr/generated/game/loto/nouveau_loto.zip",new File(""),new File(""),"nouveau_loto");
		
		olcd = new AncienLotoCsvDao(file);
		nlcd = new NouveauLotoCsvDao(file2);
		
		charger();
		
	
	}
	


	public void charger(){
		
		for(AncienTirage t : (List<AncienTirage>) olcd.getAllTirages()){
			this.tirages.add(t);
		}
		for(NouveauTirage t : (List<NouveauTirage>) nlcd.getAllTirages()){
			this.tirages.add(t);
		}
		
		fireTableDataChanged();
	}
	
	public String getColumnName(int column) {
		return header[column];
	}

	public int getRowCount() {
		return tirages.size();
	}

	public int getColumnCount() {
		return header.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Tirage t =  tirages.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return t.getId();
		case 1:
			return t.getPremierOuDeuxiemeTirage();
		case 2:
			return t.getJourTirage();
		case 3:
			return t.getDateTirage().toString("dd-MM-yyyy");
		case 4:
			return t.getDateForclusion().toString("dd-MM-yyyy") ;
		case 5:
			StringBuffer sb = new StringBuffer();
			sb.append(t.getBoule1()+"-");
			sb.append(t.getBoule2()+"-");
			sb.append(t.getBoule3()+"-");
			sb.append(t.getBoule4()+"-");
			sb.append(t.getBoule5()+"-");
			
			if(t.getClass().equals(AncienTirage.class)){
				sb.append(((AncienTirage)t).getBoule6()+"-");
				sb.append(((AncienTirage)t).getBouleComplementaire());
			}
			else{
				sb.replace(sb.length()-1, sb.length(), "#"+((NouveauTirage)t).getNumero_chance());
			}
			return sb.toString();
		case 6 :
			return t.getNbGagnantRang1();
		default:
			return null;
		}
		
	

	}

	public Class<?> getColumnClass(int columnIndex) {

		switch (columnIndex) {
		case 0:
			return Double.class;
		case 1:
			return Integer.class;
		case 2:
			return JourSemaine.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		case 5:
			return String.class;
		case 6:
			return Double.class;
		default:
			return null;
		}
		
	}

	public List<Tirage> getTirages() {
		return tirages;
	}
	
	public void ajouterTirage(Tirage t) {
		if(t!=null){
			tirages.add(t);
			fireTableDataChanged();
			fireTableRowsInserted(this.getRowCount()-1, this.getRowCount()-1);
		}

	}
	public void supprimerTirage(Tirage t) {
		tirages.remove(t);
		fireTableDataChanged();
		fireTableRowsDeleted(this.getRowCount()-1, this.getRowCount()-1);

	}

	

	
	public void ajouterCritères(LocalDate date, LocalDate localDate) {
		
		
	}
	
	
	public void nettoyer(){
		tirages.clear();
		
	}
	


	@Override
	public void fireTableDataChanged() {
		
		super.fireTableDataChanged();
	}
	
	
}
