package mock.com.documentum.fc.client;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;

import mock.ValueProvider;
import mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt.ReturnsProvidedValues;
import mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt.ReturnsSuperMockAnswer;

import com.documentum.fc.client.IDfFormat;
import com.documentum.fc.client.IDfTypedObject;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.IDfTime;

public class IDfFormatMock extends IDfPersistentObjectMock {
	public static Method GETDOSEXTENSION_METHOD;
	static {
		try {
			GETDOSEXTENSION_METHOD = IDfFormat.class.getMethod("getDOSExtension");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private IDfFormat format = null;

	public IDfFormatMock() {
		this(null);
	}

	public IDfFormatMock(ValueProvider vals) {
		super(vals);
		format = mock(IDfFormat.class);
		try {
			when(format.getDOSExtension()).thenAnswer(new ReturnsProvidedValues<String>(values));
			when(format.getObjectId()).thenAnswer(new ReturnsSuperMockAnswer<String, IDfTypedObject>(super.getMock()));
			when(format.getId(anyString())).thenAnswer(new ReturnsSuperMockAnswer<String, IDfTypedObject>(super.getMock()));
			when(format.getString(anyString())).thenAnswer(new ReturnsSuperMockAnswer<String, IDfTypedObject>(super.getMock()));
			when(format.getTime(anyString())).thenAnswer(new ReturnsSuperMockAnswer<IDfTime, IDfTypedObject>(super.getMock()));
		} catch (DfException e) {
			e.printStackTrace();
		}
	}

	public ValueProvider getDefaultValueProvider() {
		return super.getDefaultValueProvider().add(GETDOSEXTENSION_METHOD, "pdf", "doc", null);
	}

	@Override
	public IDfFormat getMock() {
		return format;
	}

}
