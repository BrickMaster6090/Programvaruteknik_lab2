package dataDomain;

import java.time.LocalDate;
import java.util.Map;

public class Main {

	static DataCollectionBuilder dcb;
	
	public static void main(String[] args) {
		//System.out.println("mål: ");
		//System.out.println(new FootballGoalsSource().getValues());
		//System.out.println("väder: ");
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
