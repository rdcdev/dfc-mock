package mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt;

import java.lang.reflect.Method;

import mock.ValueProvider;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class ReturnsProvidedValues<T> implements Answer<T> {
	int calls = -1;
	ValueProvider values;
	

	public ReturnsProvidedValues(ValueProvider values) {
		this.values = values;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T answer(InvocationOnMock invocation) throws Throwable {
		Method method = invocation.getMethod();
		T[] providedValue=null;
		if(null!=values.get(method)){
			providedValue=(T[]) values.get(method);
			return (T) providedValue[calls >= providedValue.length - 1 ? calls = 0 : ++calls];
		}
		return null;
	}
}
