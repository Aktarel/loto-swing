package fr.esiea.gl.modele;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.gl.util.ToolBox;

public class ToolBoxTest extends Assert{
	
	private ToolBox tools;
	private File zip =new File("loto.zip");
	private File zip2 =new File("nouveau_loto.zip");
	
	@Before
	public void init(){
		tools = ToolBox.getInstance();
		
	}

	@Test
	public void ancienLotoInternet(){
		tools.getFichierFromServeur("https://media.fdj.fr/generated/game/loto/loto.zip", new File(""));
		assertTrue(zip.exists());
	}
	
	@Test
	public void nouveauLotoInternet(){
		tools.getFichierFromServeur("https://media.fdj.fr/generated/game/loto/nouveau_loto.zip", new File(""));
		assertTrue(zip2.exists());
	}
	
	@Test
	public void unzippingAncienLoto() throws IOException{
		System.out.println(zip.getAbsolutePath());
		tools.unzipFichier(zip, new File(""), false);
		assertTrue(zip2.exists());
	}
	
	@Test
	public void unzippingNouveauLoto() throws IOException{
		System.out.println(zip2.getAbsolutePath());
		tools.unzipFichier(zip2, new File(""), false);
		assertTrue(zip2.exists());
	}
	
	@After
	public void clean(){
		
		//zip.delete();
		//zip2.delete();
		
	}
	
}
