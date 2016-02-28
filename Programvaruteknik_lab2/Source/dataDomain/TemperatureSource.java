package dataDomain;

import java.time.LocalDate;
import java.util.Map;

/**
 * @author Daniel Carlström, Jonatan Högberg
 * @version 28/2-2016
 * This class fetches the temperatures from smhi.se
 */

public class TemperatureSource implements DataSource {

	@Override
	public String getName() {		
		return null;
	}

	@Override
	public String getUnit() {
		return null;
	}

	@Override
	public Map<LocalDate, Double> getValues() {
		  UrlFetcherTemperature fetcher = new UrlFetcherTemperature("http://opendata-download-metobs.smhi.se/api/version/la"
		  		+ "test/parameter/2/station/107420/period/corrected-archive/data.csv");
		  return fetcher.getContent();
	}
}