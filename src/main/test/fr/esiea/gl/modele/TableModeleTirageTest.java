package fr.esiea.gl.modele;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.supercsv.exception.SuperCSVException;


/**
 * 
 * Classe de test sur la table des tirages 
 * >Tester les dates si on réalise bien nos tests entre 2 dates (1976 -> 2008) 
 * @author Akta
 *
 */
public class TableModeleTirageTest extends Assert{
	
	
	private TableModeleTirage t;
	private File ancienLoto,nouveauLoto;
	
	@Before
	public void initialisation(){
		
		ancienLoto = new File("loto.csv");
		nouveauLoto = new File("nouveau_loto.csv");
		
		try {
			t = new TableModeleTirage(ancienLoto, nouveauLoto);
		} catch (SuperCSVException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	@Test
	public void rangeMinAtteinte(){
		
		LocalDate dateAttendue = new LocalDate(1976,05,19);
		List<LocalDate> list = new ArrayList<>();
		
		for(Tirage tirage : t.getTirages())
			list.add(tirage.getDateTirage());
				
		assertTrue(list.contains(dateAttendue));	
	}
	
	@Test
	public void rangeMaxAtteinte(){
		
		LocalDate dateAttendue = new LocalDate(2008,10,04);
		List<LocalDate> list = new ArrayList<>();
		
		for(Tirage tirage : t.getTirages())
			list.add(tirage.getDateTirage());
				
		assertTrue(list.contains(dateAttendue));	
	}
	
	@After
	public void nettoyage(){
		
	}
	
	

}
