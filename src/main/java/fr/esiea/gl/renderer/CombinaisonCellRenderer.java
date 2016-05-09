package fr.esiea.gl.renderer;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CombinaisonCellRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Component getTableCellRendererComponent(JTable table,
			Object numeros, boolean isSelected, boolean hasFocus, int row,
			int column) {
		List<Integer> n = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer((String) numeros, "-");
		
		while (st.hasMoreElements()) {
			String numero = (String) st.nextElement();
			if(!numero.contains("#"))
				n.add(Integer.parseInt(numero));
			else{
				n.add(Integer.parseInt(numero.substring(0,numero.indexOf("#"))));
				n.add(Integer.parseInt(numero.substring(numero.indexOf("#")+1,numero.length())));
			}
				
		}

		StringBuffer sb = new StringBuffer();
		//Collections.sort(n);
		
		
		//6 numéros = nouveau loto - 7 numéro = ancien loto
		if(n.size()==6){
			int numerochance = n.get(5);
			sb.append("<html>Nouveau Loto : 5 numéros # numéro chance  <br><center>");
			for (int i = 0; i < 5; i++)
				sb.append(n.get(i) + " - ");
			
			sb.replace( sb.length()-2, sb.length(), " # "+numerochance);
			sb.append("</center></html>");
		}
		else{
			sb.append("<html>Ancien Loto : 6 numéros - numéro complémentaire <br><center>");
			for (int i = 0; i < n.size(); i++)
				sb.append(n.get(i) + " - ");
			
			sb.delete(sb.length() - 2, sb.length());
			sb.append("</center></html>");
		}
		
		setToolTipText(sb.toString());
		setText((String) numeros);
		
		return this;
	}
	

}
