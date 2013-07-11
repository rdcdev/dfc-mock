package mock;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ValueProvider {
	Map<Method, Object> values = new HashMap<Method, Object>();

	public ValueProvider add(Method key, Object... value) {
		values.put(key, value);
		return this;
	}

	public Object get(Method key) {
		return values.get(key);
	}
}
