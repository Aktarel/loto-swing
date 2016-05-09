package fr.esiea.gl.test;

import java.io.IOException;

import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

import org.supercsv.exception.SuperCSVException;
import org.supercsv.exception.SuperCSVReflectionException;

import fr.esiea.gl.ihm.FenetrePrincipale;

public class Test {

	
	
	public static void main(String[] args) throws SuperCSVReflectionException,
			SuperCSVException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
	
		
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	try {
					new FenetrePrincipale("Projet Loto - 3A-CFA");
				} catch (SuperCSVReflectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SuperCSVException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
	
	
		
		
	}
}
