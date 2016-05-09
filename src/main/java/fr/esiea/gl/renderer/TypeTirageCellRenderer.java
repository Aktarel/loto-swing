package fr.esiea.gl.renderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TypeTirageCellRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		Double d = new Double((double) value);
		setText(String.valueOf(d.intValue()));
		
		if(d<2008081)
			setBackground(new Color(102,102,205));
		else
			setBackground(new Color(153,102,204));
		
		
		return this;
	}
	
	

}
