package mock.com.documentum.fc.client;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;

import mock.ValueProvider;
import mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt.ReturnsProvidedValues;
import mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt.ReturnsSuperMockAnswer;

import com.documentum.fc.client.IDfCollection;
import com.documentum.fc.client.IDfTypedObject;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.DfId;
import com.documentum.fc.common.IDfAttr;
import com.documentum.fc.common.IDfId;
import com.documentum.fc.common.IDfTime;

public class IDfCollectionMock extends IDfTypedObjectMock {
	public static Method NEXT_METHOD;
	public static Method GETOBJECTID_METHOD;
	static {
		try {
			NEXT_METHOD = IDfCollection.class.getMethod("next");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	private IDfCollection idfCollection = null;

	public IDfCollectionMock() {
		this(null);
	}

	public IDfCollectionMock(ValueProvider vals) {
		super(vals);
		idfCollection = mock(IDfCollection.class);
		try {
			when(idfCollection.getObjectId()).thenAnswer(new ReturnsSuperMockAnswer<IDfId, IDfTypedObject>(super.getMock()));
			when(idfCollection.getString(anyString())).thenAnswer(new ReturnsSuperMockAnswer<String, IDfTypedObject>(super.getMock()));
			when(idfCollection.getTime(anyString())).thenAnswer(new ReturnsSuperMockAnswer<IDfTime, IDfTypedObject>(super.getMock()));
			when(idfCollection.getInt(anyString())).thenAnswer(new ReturnsSuperMockAnswer<Integer, IDfTypedObject>(super.getMock()));
			when(idfCollection.getAttr(anyInt())).thenAnswer(new ReturnsSuperMockAnswer<IDfAttr, IDfTypedObject>(super.getMock()));
			when(idfCollection.getAllRepeatingStrings(anyString(), anyString())).thenAnswer(new ReturnsSuperMockAnswer<IDfAttr, IDfTypedObject>(super.getMock()));
			when(idfCollection.next()).thenAnswer(new ReturnsProvidedValues<Boolean>(values));
		} catch (DfException e) {
			e.printStackTrace();
		}
	}

	@Override
	public IDfCollection getMock() {
		return idfCollection;
	}

	public ValueProvider getDefaultValueProvider() {
		return super.getDefaultValueProvider().add(NEXT_METHOD, true, true, true, false);
	}

	public static void main(String[] args) throws DfException {
		ValueProvider values = new ValueProvider();
		values.add(NEXT_METHOD, true, true, true, false);
		values.add(IDfTypedObjectMock.GETOBJECTID_METHOD, DfId.valueOf("0912345678945612"));
		IDfCollection mockedColl = new IDfCollectionMock().getMock();
		System.out.println(mockedColl.getString("Ion"));
		System.out.println(mockedColl.getString("Ion"));
		System.out.println(mockedColl.getObjectId());
		System.out.println(mockedColl.next());
		System.out.println(mockedColl.next());
		System.out.println(mockedColl.next());
		System.out.println(mockedColl.next());
		mockedColl.close();
	}
}
