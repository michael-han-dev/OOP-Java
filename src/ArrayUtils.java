
public class ArrayUtils {

	/**
	 * Returns an evenly spaced array of n values starting at xStart where the
	 * spacing between elements is equal to dx. Negative values of dx are allowed.
	 * 
	 * <p>
	 * If n is less than or equal 1, then an exception is thrown.
	 * 
	 * <p>
	 * If dx is equal to 0.0, then an exception is thrown.
	 * 
	 * @param n the number of values in the sequence
	 * @param xStart the starting value of the sequence
	 * @param dx   the spacing between values of the sequence
	 * @return an evenly spaced array of n values starting at xStart having spacing dx
	 * @throws IllegalArgumentException if n is less than or equal to 1
	 * @throws IllegalArgumentException if dx is equal to 0.0
	 */
	public static double[] linspace(int n, double xStart, double dx) {
		
		if (n <= 1) {
			throw new IllegalArgumentException("n <= 1.");
		}
		if (dx == 0) {
			throw new IllegalArgumentException("dx = 0.");
		}
		double [] arr = new double[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = xStart;
			xStart += dx;
		}
		return arr;
		
	}
	
	
	
	/**
	 * Computes the element-wise relative error between two arrays of the same
	 * length. The returned array contains the values (xEst[i] - xTrue[i]) / xTrue[i].
	 * 
	 * @param xTrue an array of values 
	 * @param xEst an array of values of the same length as xTrue
	 * @return an array of the relative errors (xEst[i] - xTrue[i]) / xTrue[i]
	 * @throws IllegalArgumentException if xTrue and xEst have different lengths
	 */
	public static double[] relError(double[] xTrue, double[] xEst) {
		
		if (xTrue.length != xEst.length) {
			throw new IllegalArgumentException("xTrue length != xEst length.");
		}
		
		double [] arr = new double[xTrue.length];
		for (int i = 0; i < xTrue.length; i++) {
			arr[i] = (xEst[i] - xTrue[i]) / xTrue[i];
		}
		return arr;
		
		
	}
	
}
