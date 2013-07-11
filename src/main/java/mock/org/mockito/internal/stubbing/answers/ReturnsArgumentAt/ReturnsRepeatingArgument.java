package mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class ReturnsRepeatingArgument implements Answer<String> {
	int count = 0;

	public ReturnsRepeatingArgument(int index) {
		this.count = index;
	}

	@Override
	public String answer(InvocationOnMock invocation) throws Throwable {
		Object[] args = invocation.getArguments();
		StringBuilder retString = new StringBuilder();
		for (int i = 0; i < count; i++) {
			retString.append("Mock-").append(args[0].toString()).append(args[1].toString());
		}
		return retString.deleteCharAt(retString.length() - 1).toString();
	}
}