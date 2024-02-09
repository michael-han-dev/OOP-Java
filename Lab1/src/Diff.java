
public class Diff {
	/**
	 * Computes the forward finite difference approximation of the derivative of a
	 * function f at the point x1.
	 * 
	 * @param f_x1 the value of f at x1
	 * @param f_x2 the value of f at x2
	 * @param h    the positive distance between x1 and x2
	 * @return the forward finite difference approximation of the derivative of a
	 *         function f at the point x1
	 * @throws IllegalArgumentException if h is not positive
	 */
	public static double fdiff(double f_x1, double f_x2, double h) {
	    if (h <= 0.0) {
	        throw new IllegalArgumentException("h <= 0.0");
	    }
	    return (f_x2 - f_x1) / h;
	}

	/**
	 * Computes the forward finite difference approximation of the derivative of a
	 * function f at multiple points x0, x1, x2, ..., xn-1. The positive distance
	 * between points is assumed to be a constant value h.
	 * 
	 * <p>
	 * The array y contains the function evaluations f(x0), f(x1), ..., f(xn-1).
	 * The length of y must be greater than or equal to 2.
	 * 
	 * <p>
	 * The returned array has the same length as y and contains the forward finite
	 * differences approximating the derivatives of f evaluated at x0, x1, ... xn-1
	 * 
	 * <p>
	 * The last element of the returned array is set to 0.0 as the forward
	 * difference is not computable.
	 * 
	 * @param y an array of function evaluations f(x0), f(x1), ..., f(xn-1)
	 * @param h the positive distance between function evaluations
	 * @return an array of length y.length containing the forward finite differences
	 * @throws IllegalArgumentException if h is not positive
	 * @throws IllegalArgumentException if n is less than 2
	 */
	public static double[] fdiff(double[] y, double h) {
	    int n = y.length;
	    if (n < 2) {
	        throw new IllegalArgumentException("y.length < 2");
	    }
	    double[] dy = new double[n];
	    for (int i = 0; i < n - 1; i++) {
	        dy[i] = Diff.fdiff(y[i], y[i + 1], h);
	    }
	    return dy;
	}
	
	



	/**
	 * Computes the backward finite difference approximation of the derivative of a
	 * function f at the point x1. It is assumed that x1 < x2 is true.
	 * 
	 * @param f_x1 the value of f at x1
	 * @param f_x2 the value of f at x2
	 * @param h    the positive distance between x1 and x2
	 * @return the backward finite difference approximation of the derivative of a
	 *         function f at the point x1
	 * @throws IllegalArgumentException if h is not positive
	 */
	public static double bdiff(double f_x1, double f_x2, double h) {
		if (h <= 0.0) {
	        throw new IllegalArgumentException("h <= 0.0");
	    }
	    return (f_x2 - f_x1) / h;
	}
	
	/**
	 * Computes the backward finite difference approximation of the derivative of a
	 * function f at multiple points x0, x1, x2, ..., xn-2. The positive distance
	 * between points is assumed to be a constant value h.
	 * 
	 * <p>
	 * The array y contains the function evaluations f(x0), f(x1), ..., f(xn-1)
	 * where x0 < x1 < x2 ... < xn-1. The length of y must be greater than or equal
	 * to 2.
	 * 
	 * <p>
	 * The returned array has the same length as y and contains the backward finite
	 * differences approximating the derivatives of f evaluated at x1, x2, ... xn-1
	 * 
	 * <p>
	 * The first element of the returned array is set to 0.0 as the backward
	 * difference is not computable.
	 * 
	 * @param y an array of function evaluations f(x0), f(x1), ..., f(xn-1)
	 * @param h the positive distance between function evaluations
	 * @return an array of length y.length containing the backward finite differences
	 * @throws IllegalArgumentException if h is not positive
	 * @throws IllegalArgumentException if y.length is less than 2
	 */
	public static double[] bdiff(double[] y, double h) {
		int n = y.length;
	    if (n < 2) {
	        throw new IllegalArgumentException("y.length < 2");
	    }
	    double[] dy = new double[n];
	    for (int i = 0; i < n - 1; i++) {
	        dy[i] = Diff.bdiff(y[i + 1], y[i], h);
	    }
	    return dy;
	}

}
