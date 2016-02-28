package dataDomain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author thomas, Jonatan Högberg, Daniel Carlström
 * @version 28/2-2016
 * This class sorts out dates and temperature from the files.
 */
public class UrlFetcherTemperature {

	private final URL url;

	public UrlFetcherTemperature(String urlString) {
		try {
			url = new URL(urlString);
		} catch (MalformedURLException ex) {
			throw new RuntimeException(ex);
		}
	}

	public Map<LocalDate, Double> getContent() {
		
		Map<LocalDate, Double> temperature = new TreeMap<>();
		String temp;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
			while (null != (temp = br.readLine())) {
				String[] collumns = temp.split(";");

				try {
					temperature.put(LocalDate.parse(collumns[2]), Double.parseDouble(collumns[3]));
				} catch (Exception e) {
					temperature.clear();
				}
			}
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}

		return temperature;
	}
}