package vys.tax.computation;

import java.util.HashMap;
import java.util.Map;

public class COMPUTATION_CONTEXT {
	
	private Map<String, Object> symbols = new HashMap<>();
	
	public void put(String key, Object value) {
		symbols.put(key, value);
	}
	
	public Object get(String key) {
		return symbols.get(key);
	}

}
