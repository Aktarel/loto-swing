package fr.esiea.gl.util;

import java.io.File;

import javax.swing.filechooser.FileFilter;


/**
 * 
 * To finish
 * @author Akta
 *
 */
public class FiltreFichierCsv extends FileFilter{

	public boolean accept(File f) {
		String nom = f.getName();
		//String ext =nom.substring(nom.indexOf("."),nom.length());
		System.out.println(nom);
		return true;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
