package mock.com.documentum.fc.client;

import static org.mockito.Mockito.*;

import java.lang.reflect.Method;

import mock.ValueProvider;
import mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt.ReturnsProvidedValues;
import mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt.ReturnsSuperMockAnswer;

import com.documentum.fc.client.IDfPersistentObject;
import com.documentum.fc.client.IDfUser;
import com.documentum.fc.common.DfException;

public class IDfUserMock extends IDfPersistentObjectMock {
	public static Method GETUSERNAME_METHOD;
	static {
		try {
			GETUSERNAME_METHOD = IDfUser.class.getMethod("getUserName");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private IDfUser iDfUser = null;

	public IDfUserMock() {
		this(null);
	}

	public IDfUserMock(ValueProvider vals) {
		super(vals);
		iDfUser = mock(IDfUser.class);
		try {
			when(iDfUser.getUserName()).thenAnswer(new ReturnsProvidedValues<String>(values));
			when(iDfUser.getString(anyString())).thenAnswer(new ReturnsSuperMockAnswer<String, IDfPersistentObject>(super.getMock()));
		} catch (DfException e) {
			e.printStackTrace();
		}
	}

	public ValueProvider getDefaultValueProvider() {
		return super.getDefaultValueProvider().add(GETUSERNAME_METHOD, "dmadmin", "admin");
	}

	@Override
	public com.documentum.fc.client.IDfUser getMock() {
		return iDfUser;
	}

}
