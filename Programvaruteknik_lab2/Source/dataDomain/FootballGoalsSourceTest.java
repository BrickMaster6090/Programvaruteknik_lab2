package dataDomain;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FootballGoalsSourceTest {

	FootballGoalsSource fgs;
	
	@Before
	public void setUp() throws Exception {
		 fgs = new FootballGoalsSource();
	}

	@After
	public void tearDown() throws Exception {
		fgs = null;
	}

	@Test
	public void testName() {
		assertEquals("Antal mål per matchdag i fotbollsallsvenskan",  fgs.getName());
	}
	
	@Test
	public void testUnit() {
		 assertEquals("Antal mål", fgs.getUnit());
	}
	
	@Test
	public void testGetValues() {
		 Map<LocalDate, Double> testMap = fgs.getValues();
		 assertEquals(14, testMap.size());
		 assertEquals(true,testMap.containsKey(LocalDate.of(2014, 4, 06)) );
	}
	
	
}