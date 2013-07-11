package mock;

import java.lang.reflect.Method;

public class MethodMock {
	Object[] params = null;
	Method method = null;

	public MethodMock(Method method, Object... params) {
		this.method = method;
		this.params = params;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && (obj instanceof MethodMock)) {
			MethodMock other = (MethodMock) obj;
			Class<?>[] paramTypes = other.method.getParameterTypes();
			for (Class<?> class1 : paramTypes) {
//				class1.cast(obj)
//				if (other.params[0] instanceof class1) {
//
//				}
			}
			return other.method.equals(this.method);
		}

		return false;
	}
}
