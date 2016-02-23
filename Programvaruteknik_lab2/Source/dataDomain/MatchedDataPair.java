package dataDomain;

/**
 * @author ntn13dcm
 * @author ofk14den
 * @version 2016-02-17
 */
public class MatchedDataPair {

	private Double xValue;
	private Double yValue;

	/**
	 * Constructor of the MatchedDataPair Class
	 * 
	 * @param x
	 *            Double
	 * @param y
	 *            Double
	 */
	public MatchedDataPair(Double x, Double y) {

		this.xValue = x;
		this.yValue = y;

	}

	/**
	 * returns the x value
	 * 
	 * @return double
	 */
	public double getXValue() {

		return xValue;
	}

	/**
	 * returns the y value
	 * 
	 * @return double
	 */
	public double getYValue() {
		return yValue;
	}

	public String toString() {
		return xValue + " " + yValue;
	}

}
