package fr.esiea.gl.dao;

import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.EmbeddedObjectContainer;
import com.db4o.query.Predicate;

import fr.esiea.gl.modele.AncienTirage;
import fr.esiea.gl.modele.Tirage;


/**
 * 
 * Classe permettant de recupérer d'une base de donnée DB4O des objets de l'ancien loto
 * @author Akta
 * @deprecated Abandonné
 */
public class LotoDbDao implements LotoDao {
	
	private Db4oEmbedded dbEmbarque;
	private EmbeddedObjectContainer dataBase;
	
	public LotoDbDao() {
		dbEmbarque = new Db4oEmbedded();
		dataBase = dbEmbarque.openFile("dbo");
	}
	
	public List<?> getAllTirages() {
		return dataBase.query(Tirage.class);
	}

	public List<AncienTirage> getTirage(final double id, Class<Tirage> c) {
		return dataBase.query(new Predicate<AncienTirage>() {
			
			private static final long serialVersionUID = 1L;

			public boolean match(AncienTirage t) {
				return t.getId()==id;
			}
		});
	}
	
	public void insertTirage(Tirage t){
		dataBase.store(t);
	}

}
