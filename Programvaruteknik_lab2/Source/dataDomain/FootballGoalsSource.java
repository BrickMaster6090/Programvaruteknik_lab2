package dataDomain;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
* @author Daniel Carlström, Jonatan Högberg
* @version 28/2-2016
* This class fetches the results from allsvenskan 2014
*/

public class FootballGoalsSource implements DataSource {

    @Override
    public String getName() {
        return "Antal mål per matchdag i fotbollsallsvenskan";
    }
    
    @Override
    public String getUnit() {
        return "Antal mål";
    }
    /**
     * this method gets the result from everysport.com and sort out the 
     * results from the games played at Strömvallen
     */
    @Override
    public Map<LocalDate, Double> getValues() {
        UrlFetcherGoals fetcher = new UrlFetcherGoals("http://api.everysport.com/v1/events?apikey=1769e0fdbeabd60f479b1dcaff03bf5c&league=63925&limit=240");
        JsonToMapParser parser = new JsonToMapParser(fetcher.getContent());
        Map<String, Object> data = parser.getResult();
        Map<LocalDate, Double> result = new TreeMap<>();
        Map<String, Object> arena = null;
        
        int counter = 1;
        for (Map event : (List<Map>) data.get("events")){
        	Map<String, Object> facts = (Map<String, Object>) event.get("facts");
        	arena = (Map<String, Object>) facts.get("arena");
        	if(arena != null && facts != null){
        		String name = (String)arena.get("name");
        	if(name.equals("Strömvallen")){
        		System.out.println(name + " " + counter);
        		counter++;
        		LocalDate date = LocalDate.parse(event.get("startDate").toString().substring(0, 10));
            	int goals = Integer.parseInt(event.get("visitingTeamScore").toString());
           		goals += Integer.parseInt(event.get("homeTeamScore").toString());
           		addGoalsToDate(result, date, goals);
        	}
        }	
      }
        return result;
    }

    private void addGoalsToDate(Map<LocalDate, Double> result, LocalDate date, int goals) {
        if (!result.containsKey(date)) {
            result.put(date, new Double(goals));
        } else {
            result.put(date, result.get(date) + goals);
        }
    }
}