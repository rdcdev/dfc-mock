package mock.com.documentum.fc.client;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;
import java.util.Date;

import mock.Mockable;
import mock.ValueProvider;
import mock.com.documentum.fc.common.IDfAttrMock;
import mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt.ReturnsProvidedValues;

import com.documentum.fc.client.IDfTypedObject;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.DfId;
import com.documentum.fc.common.DfTime;
import com.documentum.fc.common.IDfId;
import com.documentum.fc.common.IDfTime;

public class IDfTypedObjectMock implements Mockable<IDfTypedObject> {
	public static Method GETATTR_METHOD;
	public static Method GETATTRCOUNT_METHOD;
	public static Method GETTIME_METHOD;
	public static Method GETDOUBLE_METHOD;
	public static Method GETINT_METHOD;
	public static Method GETBOOLEAN_METHOD;
	public static Method GETALLREPEATINGSTRING_METHOD;
	public static Method GETSTRING_METHOD;
	public static Method GETID_METHOD;
	public static Method GETOBJECTID_METHOD;
	static {
		try {
			GETOBJECTID_METHOD = IDfTypedObject.class.getMethod("getObjectId");
			GETATTR_METHOD = IDfTypedObject.class.getMethod("getAttr", Integer.TYPE);
			GETATTRCOUNT_METHOD = IDfTypedObject.class.getMethod("getAttrCount");
			GETTIME_METHOD = IDfTypedObject.class.getMethod("getTime", String.class);
			GETDOUBLE_METHOD = IDfTypedObject.class.getMethod("getDouble", String.class);
			GETINT_METHOD = IDfTypedObject.class.getMethod("getInt", String.class);
			GETBOOLEAN_METHOD = IDfTypedObject.class.getMethod("getBoolean", String.class);
			GETALLREPEATINGSTRING_METHOD = IDfTypedObject.class.getMethod("getAllRepeatingStrings", String.class, String.class);
			GETID_METHOD = IDfTypedObject.class.getMethod("getId", String.class);
			GETSTRING_METHOD = IDfTypedObject.class.getMethod("getString", String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private IDfTypedObject typedObj = null;
	protected ValueProvider values = null;

	public IDfTypedObjectMock() {
		this(null);
	}

	public IDfTypedObjectMock(ValueProvider vals) {
		values = vals != null ? vals : getDefaultValueProvider();
		typedObj = mock(IDfTypedObject.class);
		try {
			when(typedObj.getObjectId()).thenAnswer(new ReturnsProvidedValues<IDfId>(values));
			when(typedObj.getId(anyString())).thenAnswer(new ReturnsProvidedValues<IDfId>(values));
			when(typedObj.getString(anyString())).thenAnswer(new ReturnsProvidedValues<String>(values));
			when(typedObj.getAllRepeatingStrings(anyString(), anyString())).thenAnswer(new ReturnsProvidedValues<String>(values));
			when(typedObj.getBoolean(anyString())).thenAnswer(new ReturnsProvidedValues<Boolean>(values));
			when(typedObj.getInt(anyString())).thenAnswer(new ReturnsProvidedValues<Integer>(values));
			when(typedObj.getDouble(anyString())).thenAnswer(new ReturnsProvidedValues<Double>(values));
			when(typedObj.getTime(anyString())).thenAnswer(new ReturnsProvidedValues<IDfTime>(values));
			when(typedObj.getAttrCount()).thenAnswer(new ReturnsProvidedValues<Integer>(values));
			when(typedObj.getAttr(anyInt())).thenAnswer(new ReturnsProvidedValues<com.documentum.fc.common.IDfAttr>(values));
		} catch (DfException e) {
			e.printStackTrace();
		}
	}

	public ValueProvider getDefaultValueProvider() {
		ValueProvider values = new ValueProvider();
		values.add(GETOBJECTID_METHOD, DfId.DF_NULLID);
		values.add(GETID_METHOD, DfId.DF_NULLID);
		values.add(GETSTRING_METHOD, "str1", "str2", "str3");
		values.add(GETALLREPEATINGSTRING_METHOD, "rstr1", "rstr2", "rstr3");
		values.add(GETBOOLEAN_METHOD, true, true, false);
		values.add(GETINT_METHOD, 1, 2, 3);
		values.add(GETDOUBLE_METHOD, 1.1, 2.2, 3.3);
		values.add(GETTIME_METHOD, new DfTime(new Date()), new DfTime(new Date(0)));
		values.add(GETATTRCOUNT_METHOD, 3);
		com.documentum.fc.common.IDfAttr attr = new IDfAttrMock().getMock();
		values.add(GETATTR_METHOD, attr);
		return values;
	}

	@Override
	public IDfTypedObject getMock() {
		return typedObj;
	}

	public static void main(String[] args) throws DfException, SecurityException, NoSuchMethodException {

		IDfTypedObject mockedTypObj = new IDfTypedObjectMock(null).getMock();
		System.out.println(mockedTypObj.getString("s"));
		System.out.println(mockedTypObj.getString("s"));
		System.out.println(mockedTypObj.getAllRepeatingStrings("s", ","));
		System.out.println(mockedTypObj.getInt("s"));
		System.out.println(mockedTypObj.getDouble("Ion"));
	}
}
