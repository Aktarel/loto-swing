package fr.esiea.gl.modele;


/**
 * 
 * Enum des templates en Swing 
 * @author Akta
 *
 */
public enum LookNFeel {

	smartFeel("com.jtattoo.plaf.smart.SmartLookAndFeel"), nimbus("javax.swing.plaf.nimbus.NimbusLookAndFeel"), jgoodies01(
			"com.jgoodies.looks.windows.WindowsLookAndFeel"), jgoodies02(
			"com.jgoodies.looks.plastic.PlasticLookAndFeel"), jgoodies03(
			"com.jgoodies.looks.plastic.Plastic3DLookAndFeel"), jgoodies04(
			"com.jgoodies.looks.plastic.PlasticXPLookAndFeel"), windowsSeven("Windows seven looknFeel");

	private final String label;

	private LookNFeel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
