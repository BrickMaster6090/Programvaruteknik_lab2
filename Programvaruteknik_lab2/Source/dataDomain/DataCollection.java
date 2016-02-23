package dataDomain;
import java.util.Map;

/**
 * @author ntn13dcm
 * @author ofk14den
 * @version 2016-02-17
 */
/**
 * @author ntn13dcm
 *
 */
public class DataCollection {

	private Map<String, MatchedDataPair> data;
	private String title;
	private String xUnit;
	private String yUnit;

	/**
	 * Constructor of the DataCollection Class
	 * 
	 * @param title
	 *            String
	 * @param xUnit
	 *            String
	 * @param yUnit
	 *            String
	 * @param data
	 *            Map<String, MatchedDataPair>
	 */
	public DataCollection(String title, String xUnit, String yUnit, Map<String, MatchedDataPair> data) {
		this.title = title;
		this.xUnit = xUnit;
		this.yUnit = yUnit;
		this.data = data;

	}

	/**
	 * returns the title of the collection
	 * 
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * returns the unit of the xData
	 * 
	 * @return String
	 */
	public String getXUnit() {

		return xUnit;
	}

	/**
	 * returns the unit of the yData
	 * 
	 * @return String
	 */
	public String getYUnit() {
		return yUnit;
	}

	/**
	 * returns the data
	 * 
	 * @return Map<String, MatchedDataPair>
	 */
	public Map<String, MatchedDataPair> getData() {
		return data;
	}

	public String toString() {
		return data + " " + title + " " + xUnit + " " + yUnit;
	}

}
