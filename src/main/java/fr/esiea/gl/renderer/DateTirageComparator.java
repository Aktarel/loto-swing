package fr.esiea.gl.renderer;

import java.util.Comparator;

public class DateTirageComparator implements Comparator<String> {

	public int compare(String o1, String o2) {

		String[] date1 = o1.split("-");
		int jour1 = Integer.valueOf(date1[0]);
		int mois1 = Integer.valueOf(date1[1]);
		int annee1 = Integer.valueOf(date1[2]);

		String[] date2 = o2.split("-");
		int jour2 = Integer.valueOf(date2[0]);
		int mois2 = Integer.valueOf(date2[1]);
		int annee2 = Integer.valueOf(date2[2]);
		
		if (annee1 > annee2) {
			return 1;
		} else if (annee1 < annee2) {
			return -1;
		}
		else {

			if (mois1 > mois2) {
				return 1;
			} else if (mois1 < mois2) {
				return -1;
			}
			else{
				
				if (jour1 > jour2) {
					return 1;
				} else if (jour1 < jour2) {
					return -1;
				}
				else {
					return 0;
				}
			}
		}

	}
}
