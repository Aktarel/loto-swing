package fr.esiea.gl.dao;

import java.util.List;

import fr.esiea.gl.modele.Tirage;


/**
 * Interface pour manipuler les objets Tirage (Loto & NouveauLoto)
 * 
 * @author Nicolas Lebec
 * @since 15/02/2012
 */

public interface LotoDao {

	public List<?> getAllTirages();
	public Object getTirage(double id, Class<Tirage> c);
}
