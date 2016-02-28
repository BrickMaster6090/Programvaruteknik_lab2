package dataDomain;

import java.time.LocalDate;
import java.util.Map;

/**
 * @author Daniel Carlström, Jonatan Högberg
 * @version 28/2-2016
 * this is the main class that execute the program
 */

public class Main {

	static DataCollectionBuilder dcb;
	
	/**
	 * @param args
	 * Sends two data sources to DataCollectionBuilder and then prints the result
	 */
	public static void main(String[] args) {
		
		Map<LocalDate,Double> temperature = new TemperatureSource().getValues();
		Map<LocalDate, Double> goals = new FootballGoalsSource().getValues();
		
		DataSourcerBuilder xData = new DataSourcerBuilder();
		DataSourcerBuilder yData = new DataSourcerBuilder();
		String xname = "mål", yname = "temperatur",xunit="antal",yunit="grader";
		
		for (LocalDate xCurrentKey : goals.keySet()) {
			xData.setValue(xname, xunit, xCurrentKey, goals.get(xCurrentKey));
		}
		for (LocalDate yCurrentKey : temperature.keySet()) {
			yData.setValue(yname, yunit, yCurrentKey, temperature.get(yCurrentKey));
		}
				
		dcb = new DataCollectionBuilder(xData, yData, Resolution.DAY);
		
		System.out.println(dcb.getResult().toString());		
	}
}
