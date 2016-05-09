package fr.esiea.gl.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.joda.time.LocalDate;

import fr.esiea.gl.exception.JourSemaineInconnuException;

/**
 * Representation java d'un tirage du nouveau loto
 * 
 * @author Nicolas LEBEC
 * @since 12/02/2012
 * 
 **/


public class NouveauTirage extends Tirage {

	private int numero_chance;

	public NouveauTirage() {
		// TODO Auto-generated constructor stub
	}


	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}


	public JourSemaine getJourTirage() {
		return jourTirage;
	}

	public void setJourTirage(JourSemaine jourTirage) {
		this.jourTirage = jourTirage;
	}

	public void setJourTirage(String jourTirage)
			throws JourSemaineInconnuException {

		switch (jourTirage) {
		case "LUNDI":
			this.jourTirage = JourSemaine.LUNDI;
			break;
		case "MERCREDI":
			this.jourTirage = JourSemaine.MERCREDI;
			break;
		case "JEUDI":
			this.jourTirage = JourSemaine.JEUDI;
			break;
		case "SAMEDI":
			this.jourTirage = JourSemaine.SAMEDI;
			break;
		default:
			break;
		}
		
		
	}

	public LocalDate getDateForclusion() {
		return dateForclusion;
	}

	public void setDateForclusion(String dateForclusion) {

		if (dateForclusion == "00000000") {
			this.dateForclusion = new LocalDate(1,1,1);
		} else {
			this.dateForclusion = new LocalDate(Integer.parseInt(dateForclusion
					.substring(0, 4)), Integer.parseInt(dateForclusion
					.substring(4, 6)), Integer.parseInt(dateForclusion
					.substring(6, 8)));
		}
	}
	
	public LocalDate getDateTirage() {
		return dateTirage;
	}

	public void setDateTirage(String dateTirage) {
		this.dateTirage = new LocalDate(Integer.parseInt(dateTirage.substring(
				0, 4)), Integer.parseInt(dateTirage.substring(4, 6)),
				Integer.parseInt(dateTirage.substring(6, 8)));

	}

	public int getBoule1() {
		return boule1;
	}

	public void setBoule1(int boule1) {
		this.boule1 = boule1;
	}

	public int getBoule2() {
		return boule2;
	}

	public void setBoule2(int boule2) {
		this.boule2 = boule2;
	}

	public int getBoule3() {
		return boule3;
	}

	public void setBoule3(int boule3) {
		this.boule3 = boule3;
	}

	public int getBoule4() {
		return boule4;
	}

	public void setBoule4(int boule4) {
		this.boule4 = boule4;
	}

	public int getBoule5() {
		return boule5;
	}

	public void setBoule5(int boule5) {
		this.boule5 = boule5;
	}


	public List<Integer> getNumeros() {
		return numeros;
	}

	public void setNumeros(String listeNumeroChaine) {
		numeros = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(listeNumeroChaine.substring(0,listeNumeroChaine.indexOf("+")), "-");
		while (st.hasMoreTokens()) {
			numeros.add(Integer.parseInt(st.nextToken()));
		}
		
		numeros.add(numero_chance);
	}
	public double getNbGagnantRang1() {
		return nbGagnantRang1;
	}

	public void setNbGagnantRang1(double nbGagnantRang1) {
		this.nbGagnantRang1 = nbGagnantRang1;
	}

	public double getRapportRang1() {
		return rapportRang1;
	}

	public void setRapportRang1(String rapportRang1) {
		this.rapportRang1 = Double.parseDouble(rapportRang1.replace(",", "."));
	}

	public double getNbGagnantRang2() {
		return nbGagnantRang2;
	}

	public void setNbGagnantRang2(double nbGagnantRang2) {
		this.nbGagnantRang2 = nbGagnantRang2;
	}

	public double getRapportRang2() {
		return rapportRang2;
	}

	public void setRapportRang2(String rapportRang2) {
		this.rapportRang2 = Double.parseDouble(rapportRang2.replace(",", "."));
	}

	public double getNbGagnantRang3() {
		return nbGagnantRang3;
	}

	public void setNbGagnantRang3(double nbGagnantRang3) {
		this.nbGagnantRang3 = nbGagnantRang3;
	}

	public double getRapportRang3() {
		return rapportRang3;
	}

	public void setRapportRang3(String rapportRang3) {
		this.rapportRang3 = Double.parseDouble(rapportRang3.replace(",", "."));
	}

	public double getNbGagnantRang4() {
		return nbGagnantRang4;
	}

	public void setNbGagnantRang4(double nbGagnantRang4) {
		this.nbGagnantRang4 = nbGagnantRang4;
	}

	public double getRapportRang4() {
		return rapportRang4;
	}

	public void setRapportRang4(String rapportRang4) {
		this.rapportRang4 = Double.parseDouble(rapportRang4.replace(",", "."));
	}

	public double getNbGagnantRang5() {
		return nbGagnantRang5;
	}

	public void setNbGagnantRang5(double nbGagnantRang5) {
		this.nbGagnantRang5 = nbGagnantRang5;
	}

	public double getRapportRang5() {
		return rapportRang5;
	}

	public void setRapportRang5(String rapportRang5) {
		this.rapportRang5 = Double.parseDouble(rapportRang5.replace(",", "."));
	}

	public double getNbGagnantRang6() {
		return nbGagnantRang6;
	}

	public void setNbGagnantRang6(double nbGagnantRang6) {
		this.nbGagnantRang6 = nbGagnantRang6;
	}

	public double getRapportRang6() {
		return rapportRang6;
	}

	public void setRapportRang6(String rapportRang6) {
		this.rapportRang6 = Double.parseDouble(rapportRang6.replace(",", "."));
	}


	public double getNumeroJokerPlus() {
		return numeroJokerPlus;
	}

	public void setNumeroJokerPlus(String numeroJokerPlus) {
		String sansEspace = numeroJokerPlus.replaceAll(" ", "");
		sansEspace.trim();
		this.numeroJokerPlus = Double.parseDouble(sansEspace);
	}

	public Devise getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		
		if (devise.trim().equals("eur"))
			this.devise = Devise.EURO;
		else if (devise.trim().equals("frf"))
			this.devise = Devise.FRANCSFRANCAIS;
	}


	public int getNumero_chance() {
		return numero_chance;
	}


	public void setNumero_chance(int numero_chance) {
		this.numero_chance = numero_chance;
	}


	public int getPremierOuDeuxiemeTirage() {
		return 0;
	}

	public void setPremierOuDeuxiemeTirage(int premierOuDeuxiemeTirage) {
		
	}


	


}
