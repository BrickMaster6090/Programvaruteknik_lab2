package dataDomain;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UrlFetcherTemperatureTest {

	UrlFetcherTemperature uft;
	
	@Before
	public void setUp() throws Exception {
		uft = new UrlFetcherTemperature("http://opendata-download-metobs.smhi.se/api/version/la"
				+ "test/parameter/2/station/107420/period/corrected-archive/data.csv");
	}

	@After
	public void tearDown() throws Exception {
		uft = null;
	}

	@Test
	public void testUrlFetcherTemperature() {
		Map<LocalDate, Double> temperature = new TreeMap<>();
		temperature= uft.getContent();
		assertEquals(true,temperature.containsKey(LocalDate.of(1995, 8, 13)) );
		assertEquals(true,temperature.containsKey(LocalDate.of(1996, 1, 5)) );
		assertEquals(false,temperature.containsKey(LocalDate.of(1994, 9, 15)));
		assertEquals(true,temperature.containsKey(LocalDate.of(2014, 1, 13)) );
	}
	
	@Test(expected = RuntimeException.class)
	public void testUrl(){
	uft = new UrlFetcherTemperature("hej!");
	}
}