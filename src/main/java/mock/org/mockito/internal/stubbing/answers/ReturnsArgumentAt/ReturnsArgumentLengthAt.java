package mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class ReturnsArgumentLengthAt implements Answer<Integer> {
	int index = 0;

	public ReturnsArgumentLengthAt(int index) {
		this.index = index;
	}

	@Override
	public Integer answer(InvocationOnMock invocation) throws Throwable {
		Object[] args = invocation.getArguments();
		return args[index].toString().length();
	}
}
