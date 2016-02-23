package dataDomain;

import java.io.File;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class TemperatureSource implements DataSource {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<LocalDate, Double> getValues() {
		  UrlFetcherTemperature fetcher = new UrlFetcherTemperature("http://opendata-download-metobs.smhi.se/api/version/latest/parameter/2/station/107420/period/corrected-archive/data.csv");
		  
		  return fetcher.getContent();
	}

	/*public static void main(String[] args){
		new TemperatureSource().getValues();
	}*/

		

}