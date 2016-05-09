package fr.esiea.gl.thread;

import javax.swing.JLabel;

import fr.esiea.gl.charts.GraphiquePerformances;

public class ThreadRuntime extends Thread {

	GraphiquePerformances graphique;
	JLabel label;

	public ThreadRuntime(GraphiquePerformances g, JLabel l) {
		graphique = g;
		label = l;
		start();
	}

	public void run() {

		while (true) {
			// int processeurs = Runtime.getRuntime().availableProcessors();
			// long maxMemoire = Runtime.getRuntime().maxMemory()/1000000;
			// long memoireTotale
			// =Runtime.getRuntime().totalMemory()/1000000;
			// long memoireLibre =
			// Runtime.getRuntime().freeMemory()/1000000;

			// JFreechart n'a pas été design pour maitriser les performances
			// Modifier dynamiquement influe sur les performances!

			graphique
					.ajouterDonne((Runtime.getRuntime().totalMemory() - Runtime
							.getRuntime().freeMemory()) / 1000000);
			label.setText(String
					.valueOf((Runtime.getRuntime().totalMemory() - Runtime
							.getRuntime().freeMemory()) / 1000000)
					+ "MB");

			// Plus j'augmente plus ça mange de la ram
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
