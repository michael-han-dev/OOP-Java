import java.util.Arrays;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class TestDiff1 {

	public static void test() {
		// compute 10 points on the line y = 0.5x + 1.333
		// at x values 0, 1, 2, ..., 9
		double[] x = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		double[] y = new double[x.length];
		for (int i = 0; i < y.length; i++) {
			y[i] = 0.5 * x[i] + 1.333;
		}

		// compute derivative of line
		double[] dy = Diff.fdiff(y, 1);

		// print the array dy
		System.out.println(Arrays.toString(dy));
		

		// create a plot having:
		XYChart chart = QuickChart.getChart("finite differences",    // title 
				"x",                                                 // x label
				"y",                                                 // y label
				"y = 0.5x + 1.333",                                  // legend entry
				x, y);                                               // values to plot
		
		// changes the x axis tick labels to use integer values
		chart.getStyler().setXAxisDecimalPattern("##");
		
		// sets the y axis limits to -1.0 and 7.0
		chart.getStyler().setYAxisMin(-1.0);
		chart.getStyler().setYAxisMax(7.0);

		// add the derivative to the plot
		//
		// legend entry "dy/dx"
		// the array x holds the x values of the plotted points
		// the array dy holds the y values of the plotted points
		chart.addSeries("dy/dx",                                       // legend entry
				x, dy);                                                // values to plot 

		// Show it
		new SwingWrapper(chart).displayChart();
	}
	

	public static void main(String[] args) {
		// two points on the line y = 0.5x
		double f_x1 = 0.0; // x1 = 0.0
		double f_x2 = 0.5; // x2 = 1.0
		double h = 1.0;
		double df = Diff.fdiff(f_x1, f_x2, h);
		System.out.println("df/dx = " + df);

		TestDiff1.test();
	}

}
