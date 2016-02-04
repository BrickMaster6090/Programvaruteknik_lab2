import java.util.Map;

public class DataCollection {
	
	private Map<String, MatchedDataPair> data;
	private String title;
	private String xUnit;
	private String yUnit;
	
	public DataCollection(String title,String xUnit, String yUnit,Map<String, MatchedDataPair> data ){
		
	}
	public String getTitle(){
		return title;
	}
	public String getXUnit(){
		return xUnit;
	}
	public String getYUnit(){
		return yUnit;
	}
	public Map<String, MatchedDataPair> getData(){
		return data;
	}
	public String toString(){
		return data+ " " + title + " " + xUnit + " " + yUnit;
	}
	

}
