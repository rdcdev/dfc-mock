package mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class ReturnsMultipleValues<T> implements Answer<T> {
	int calls = -1;
	T[] values = null;

	public ReturnsMultipleValues(T... values) {
		this.values = values;
	}

	@Override
	public T answer(InvocationOnMock invocation) throws Throwable {
		return values[calls >= values.length-1? calls = 0 : ++calls];
	}
}
