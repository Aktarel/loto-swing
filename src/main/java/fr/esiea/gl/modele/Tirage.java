package fr.esiea.gl.modele;

import java.io.Serializable;
import java.util.List;

import org.joda.time.LocalDate;

import fr.esiea.gl.exception.JourSemaineInconnuException;

/**
 * Objet abstrait Tirage
 * @author Akta
 *
 */
public abstract class Tirage  {

	
	protected double id;
	protected JourSemaine jourTirage;
	protected LocalDate dateForclusion;
	protected LocalDate dateTirage;
	protected int boule1;
	protected int boule2;
	protected int boule3;
	protected int boule4;
	protected int boule5;
	protected List<Integer> numeros;
	protected double nbGagnantRang1;
	protected double rapportRang1;
	protected double nbGagnantRang2;
	protected double rapportRang2;
	protected double nbGagnantRang3;
	protected double rapportRang3;
	protected double nbGagnantRang4;
	protected double rapportRang4;
	protected double nbGagnantRang5;
	protected double rapportRang5;
	protected double nbGagnantRang6;
	protected double rapportRang6;
	protected double numeroJokerPlus;
	protected Devise devise;
	
	public abstract int getPremierOuDeuxiemeTirage();
	public abstract void setPremierOuDeuxiemeTirage(int premierOuDeuxiemeTirage);
	public abstract double getId();
	public abstract void setId(double id) ;
	public abstract JourSemaine getJourTirage() ;
	public abstract void setJourTirage(JourSemaine jourTirage) ;
	public abstract void setJourTirage(String jourTirage) throws JourSemaineInconnuException;
	public abstract LocalDate getDateTirage() ;
	public abstract void setDateTirage(String dateTirage) ;
	public abstract LocalDate getDateForclusion() ;
	public abstract void setDateForclusion(String dateForclusion) ;
	public abstract int getBoule1() ;
	public abstract void setBoule1(int boule1) ;
	public abstract int getBoule2() ;
	public abstract void setBoule2(int boule2) ;
	public abstract int getBoule3() ;
	public abstract void setBoule3(int boule3) ;
	public abstract int getBoule4() ;
	public abstract void setBoule4(int boule4) ;
	public abstract int getBoule5() ;
	public abstract void setBoule5(int boule5) ;
	public abstract List<Integer> getNumeros() ;
	public abstract void setNumeros(String listeNumeroChaine) ;
	public abstract double getNbGagnantRang1() ;
	public abstract void setNbGagnantRang1(double nbGagnantRang1) ;
	public abstract double getRapportRang1() ;
	public abstract void setRapportRang1(String rapportRang1) ;
	public abstract double getNbGagnantRang2() ;
	public abstract void setNbGagnantRang2(double nbGagnantRang2) ;
	public abstract double getRapportRang2() ;
	public abstract void setRapportRang2(String rapportRang2) ;
	public abstract double getNbGagnantRang3() ;
	public abstract void setNbGagnantRang3(double nbGagnantRang3) ;
	public abstract double getRapportRang3() ;
	public abstract void setRapportRang3(String rapportRang3) ;
	public abstract double getNbGagnantRang4() ;
	public abstract void setNbGagnantRang4(double nbGagnantRang4) ;
	public abstract double getRapportRang4() ;
	public abstract void setRapportRang4(String rapportRang4) ;
	public abstract double getNbGagnantRang5() ;
	public abstract void setNbGagnantRang5(double nbGagnantRang5) ;
	public abstract double getRapportRang5();
	public abstract void setRapportRang5(String rapportRang5);
	public abstract double getNbGagnantRang6();
	public abstract void setNbGagnantRang6(double nbGagnantRang6);
	public abstract double getRapportRang6();
	public abstract void setRapportRang6(String rapportRang6);
	public abstract double getNumeroJokerPlus();
	public abstract void setNumeroJokerPlus(String numeroJokerPlus);
	public abstract Devise getDevise();
	public abstract void setDevise(String devise);
	
}
