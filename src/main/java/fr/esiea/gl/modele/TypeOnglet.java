package fr.esiea.gl.modele;

/**
 * 
 * Enum pour typer les actions possible lors d'ajout d'onglets
 * 
 * @author Akta
 * 
 */
public enum TypeOnglet {

	nuage("Nuage de point"), camembert("Camembert"), barreplot(
			"Graphique de barre"), options("Préférences"), donnees("Données"), importation(
			"Données"), rechercher("Rechercher");
	private final String label;

	private TypeOnglet(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
