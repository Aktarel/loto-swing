package fr.esiea.gl.charts;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class GraphiquePerformances extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TimeSeries memoireUtilise;

	public GraphiquePerformances() {

		memoireUtilise = new TimeSeries("Memoire Utilise", Second.class);

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(memoireUtilise);

		JFreeChart chart = ChartFactory.createTimeSeriesChart("Performances",
				"Temps T", "Megabyte MB", dataset, true, true, false);

		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot
				.getRenderer();
		renderer.setShapesVisible(true);

		ChartPanel c = new ChartPanel(chart);
		add(c);
	}

	public void ajouterDonne(long memoire) {
		memoireUtilise.add(new Second(), memoire);
	}



}
