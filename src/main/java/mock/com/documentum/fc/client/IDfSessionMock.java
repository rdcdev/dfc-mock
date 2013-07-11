package mock.com.documentum.fc.client;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;

import mock.Mockable;
import mock.ValueProvider;
import mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt.ReturnsProvidedValues;

import com.documentum.fc.client.IDfFolder;
import com.documentum.fc.client.IDfPersistentObject;
import com.documentum.fc.client.IDfSession;
import com.documentum.fc.client.IDfSysObject;
import com.documentum.fc.client.IDfUser;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.DfId;
import com.documentum.fc.common.IDfId;

public class IDfSessionMock implements Mockable<IDfSession> {
	public static Method GETFOLDERBYPATH_METHOD;
	public static Method GETOBJECTBYQUALIFICATION_METHOD;
	public static Method GETOBJECTBYPATH_METHOD;
	public static Method GETOBJECT_METHOD;
	public static Method GETDOCBASEID_METHOD;
	public static Method GETUSER_METHOD;
	static {
		try {
			GETFOLDERBYPATH_METHOD = IDfSession.class.getMethod("getFolderByPath", String.class);
			GETOBJECTBYQUALIFICATION_METHOD = IDfSession.class.getMethod("getObjectByQualification", String.class);
			GETOBJECTBYPATH_METHOD = IDfSession.class.getMethod("getObjectByPath", String.class);
			GETOBJECT_METHOD = IDfSession.class.getMethod("getObject", IDfId.class);
			GETDOCBASEID_METHOD = IDfSession.class.getMethod("getDocbaseId");
			GETUSER_METHOD = IDfSession.class.getMethod("getUser", String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private IDfSession iDfSession = null;
	ValueProvider values = null;

	public IDfSessionMock() {
		this(null);
	}

	public IDfSessionMock(ValueProvider vals) {
		values = vals != null ? vals : getDefaultValueProvider();
		iDfSession = mock(IDfSession.class);
		try {
			when(iDfSession.getUser(null)).thenAnswer(new ReturnsProvidedValues<IDfUser>(values));
			when(iDfSession.getDocbaseId()).thenAnswer(new ReturnsProvidedValues<String>(values));
			when(iDfSession.getObject(any(IDfId.class))).thenAnswer(new ReturnsProvidedValues<IDfSysObject>(values));
			when(iDfSession.getObjectByPath(anyString())).thenAnswer(new ReturnsProvidedValues<IDfSysObject>(values));
			when(iDfSession.getObjectByQualification(anyString())).thenAnswer(new ReturnsProvidedValues<IDfSysObject>(values));
			when(iDfSession.getFolderByPath(anyString())).thenAnswer(new ReturnsProvidedValues<IDfFolder>(values));
		} catch (DfException e) {
			e.printStackTrace();
		}
	}

	public ValueProvider getDefaultValueProvider() {
		ValueProvider vals = new ValueProvider();
		IDfUser dfUser = new IDfUserMock().getMock();
		vals.add(GETUSER_METHOD, dfUser);
		vals.add(GETDOCBASEID_METHOD, DfId.DF_NULLID_STR);
		IDfPersistentObject sysObject = new IDfSysObjectMock().getMock();
		vals.add(GETOBJECT_METHOD, sysObject);
		sysObject = new IDfSysObjectMock().getMock();
		vals.add(GETOBJECTBYPATH_METHOD, sysObject);
		sysObject = new IDfSysObjectMock().getMock();
		vals.add(GETOBJECTBYQUALIFICATION_METHOD, sysObject);
		IDfFolder dfFolder = new IDfFolderMock().getMock();
		vals.add(GETFOLDERBYPATH_METHOD, dfFolder);
		return vals;
	}

	@Override
	public IDfSession getMock() {
		return iDfSession;
	}

	public static void main(String[] args) throws DfException {
		IDfSession mockedTypObj = new IDfSessionMock().getMock();
		System.out.println(mockedTypObj.getObject(DfId.DF_NULLID));
		System.out.println(mockedTypObj.getObject(DfId.DF_NULLID).getObjectId());
		System.out.println(mockedTypObj.getObject(DfId.DF_NULLID).getObjectId());
		System.out.println(mockedTypObj.getObject(DfId.DF_NULLID).getObjectId());
		System.out.println(mockedTypObj.getObject(DfId.DF_NULLID).getObjectId());
		System.out.println(mockedTypObj.getObject(DfId.DF_NULLID).getObjectId());
	}
}
