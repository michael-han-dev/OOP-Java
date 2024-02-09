import java.util.Arrays;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class TestDiff2 {
	
	//how does the spacing affect the error of the estimated derivatives?
	public static void test() {
		double w = 0.5;
		double z = Math.exp(w);

		double rad = Math.PI / 3.0;     // angle in radians
		double s = Math.sin(rad);       // sine
		double c = Math.cos(rad);       // cosine
		
		// compute 1000 points
		// at x values starting at 0 and incrementing by 0.1
		double[] x = ArrayUtils.linspace(1000, 0, 0.1);
		double[] y = new double[x.length];
		for (int i = 0; i < y.length; i++) {
			y[i] = 2*Math.exp(-x[i])*Math.cos(8*x[i]);
		}
		
		//find the first true derivative
		double[] realDerivativeFirst = new double[x.length];
		for (int i = 0; i < x.length; i++) {
			realDerivativeFirst[i] = -16*Math.sin(8*x[i])*Math.exp(-x[i])- 2*Math.cos(8*x[i])*Math.exp(-x[i]);
		}
		
		//////////// Second Spacing /////////////
		// compute 1000 points
		// at x values starting at 0 and incrementing by 0.2
		double[] xX = ArrayUtils.linspace(1000, 0, 0.2);
		double[] yY = new double[xX.length];
		for (int i = 0; i < yY.length; i++) {
			yY[i] = 2*Math.exp(-xX[i])*Math.cos(8*xX[i]);
		}
		
		
		//find the second true derivative
		double[] realDerivativeSecond = new double[xX.length];
		for (int i = 0; i < xX.length; i++) {
			realDerivativeSecond[i] = -16*Math.sin(8*xX[i])*Math.exp(-xX[i])- 2*Math.cos(8*xX[i])*Math.exp(-xX[i]);
		}
		
		
		// compute derivative of both arrays for each spacing, this is the estimated derivative
		//0.1 spacing
		double[] dy = Diff.fdiff(y, 1);
		//0.2 spacing
		double[] dyY = Diff.fdiff(yY, 1);

		// compare the derivative differences using relError method
		double [] relativeDiff1 = ArrayUtils.relError(realDerivativeFirst, dy);
		double [] relativeDiff2 = ArrayUtils.relError(realDerivativeSecond, dyY);
		
		
		// print the array dy for testing purposes
		System.out.println(Arrays.toString(dy));
		System.out.println(Arrays.toString(dyY));

		// create a plot having:
		XYChart chart = QuickChart.getChart("Spacing Differences",    // title 
				"x",                                                 // x label
				"y",													// y label
				"y = 2e^(-x)*cos(8x)",                                  
				x, relativeDiff1);                                     
		
		// changes the x axis tick labels to use integer values
		chart.getStyler().setXAxisMin(0.0);
		chart.getStyler().setXAxisMax(2*Math.PI);
		
		// sets the y axis limits to -2.0 and 2.0
		chart.getStyler().setYAxisMin(-2.0);
		chart.getStyler().setYAxisMax(2.0);

		// add the relative errors to the plot
		chart.addSeries("Relative diff for 0.1",                                       
				x, relativeDiff1);			 
		
		//Print the second series onto the graph
		chart.addSeries("Relative diff for 0.2",                                       
				xX, relativeDiff2);
		
		
		// Display the graph
		new SwingWrapper(chart).displayChart();
	}
	
	
	public static void main(String[] args) {
		
		// two points on the line y = 0.5x
		double f_x1 = 0.0; // x1 = 0.0
		double f_x2 = 0.5; // x2 = 1.0
		double h = 1.0;
		double df = Diff.fdiff(f_x1, f_x2, h);
		System.out.println("df/dx = " + df);

		TestDiff2.test();
		
	}
}
