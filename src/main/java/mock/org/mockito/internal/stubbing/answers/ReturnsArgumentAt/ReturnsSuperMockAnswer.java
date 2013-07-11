package mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class ReturnsSuperMockAnswer<T, S> implements Answer<T> {
	S typedObj;

	public ReturnsSuperMockAnswer(S superMock) {
		this.typedObj = superMock;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T answer(InvocationOnMock invocationonmock) throws Throwable {
		java.lang.reflect.Method sysobjMethod = this.typedObj.getClass().getMethod(invocationonmock.getMethod().getName(), invocationonmock.getMethod().getParameterTypes());
		return (T) sysobjMethod.invoke(this.typedObj, invocationonmock.getArguments());
	}
}
