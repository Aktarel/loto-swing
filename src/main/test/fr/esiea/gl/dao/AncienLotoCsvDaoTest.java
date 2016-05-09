package fr.esiea.gl.dao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.gl.dao.AncienLotoCsvDao;
import fr.esiea.gl.modele.AncienTirage;
import fr.esiea.gl.modele.Tirage;


public class AncienLotoCsvDaoTest extends Assert{

	private AncienLotoCsvDao dao ;
	
	
	@Before
	public void init(){
		
		dao = new AncienLotoCsvDao();
		
	}
	
	@Test
	public void minRange(){
		
		LocalDate dateMinAttendue = new LocalDate(1976,05,19);
		List<AncienTirage> tirages = (List<AncienTirage>) dao.getAllTirages();
		List<LocalDate> listDate = new ArrayList<>();
		
		for(Tirage t : tirages)
			listDate.add(t.getDateTirage());
		
		assertTrue(listDate.contains(dateMinAttendue));
		
		
	}
	
	@Test
	public void maxRange(){
		
		LocalDate dateAttendue = new LocalDate(2008,10,04);
		List<LocalDate> list = new ArrayList<>();
		List<AncienTirage> tirages = (List<AncienTirage>) dao.getAllTirages();
		
		for(Tirage tirage : tirages)
			list.add(tirage.getDateTirage());
				
		assertTrue(list.contains(dateAttendue));	
	}
	
	
}
