import java.time.LocalDate;
import java.util.Map;

public interface DataSource {
	
	public String getName();
	
	public String getUnit();
	//fr�ga �ke
	public Map<LocalDate, Double> getData();

}
