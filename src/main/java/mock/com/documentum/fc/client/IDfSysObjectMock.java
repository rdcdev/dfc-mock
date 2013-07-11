package mock.com.documentum.fc.client;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;

import mock.ValueProvider;
import mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt.ReturnsSuperMockAnswer;

import com.documentum.fc.client.IDfPersistentObject;
import com.documentum.fc.client.IDfSysObject;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.IDfTime;

public class IDfSysObjectMock extends IDfPersistentObjectMock {
	IDfSysObject idfSysobject = null;

	public IDfSysObjectMock() {
		this(null);
	}

	public IDfSysObjectMock(ValueProvider vals) {
		super(vals);
		idfSysobject = mock(IDfSysObject.class);
		try {
			when(idfSysobject.getObjectId()).thenAnswer(new ReturnsSuperMockAnswer<String, IDfPersistentObject>(super.getMock()));
			when(idfSysobject.getId(anyString())).thenAnswer(new ReturnsSuperMockAnswer<String, IDfPersistentObject>(super.getMock()));
			when(idfSysobject.getString(anyString())).thenAnswer(new ReturnsSuperMockAnswer<String, IDfPersistentObject>(super.getMock()));
			when(idfSysobject.getTime(anyString())).thenAnswer(new ReturnsSuperMockAnswer<IDfTime, IDfPersistentObject>(super.getMock()));
			IDfFormatMock format = new IDfFormatMock();
			when(idfSysobject.getFormat()).thenReturn(format.getMock());
			when(idfSysobject.getContentEx(anyString(), anyInt())).thenReturn(new ByteArrayInputStream(new byte[256]));
		} catch (DfException e) {
			e.printStackTrace();
		}
	}

	@Override
	public IDfSysObject getMock() {
		return idfSysobject;
	}

	public static void main(String[] args) throws DfException {
		IDfSysObject mockedTypObj = new IDfSysObjectMock(null).getMock();
		System.out.println(mockedTypObj.getString("s"));
		System.out.println(mockedTypObj.getString("s"));
		System.out.println(mockedTypObj.getString("s"));
		System.out.println(mockedTypObj.getString("s"));
		System.out.println(mockedTypObj.getString("s"));
		System.out.println(mockedTypObj.getString("s"));
		System.out.println(mockedTypObj.getString("s"));
		System.out.println(mockedTypObj.getString("s"));
		// System.out.println(mockedTypObj.getAllRepeatingStrings("s", ","));
		System.out.println(mockedTypObj.getString("s"));
		// System.out.println(mockedTypObj.getString("Ion"));
	}
}
