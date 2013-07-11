package mock.com.documentum.fc.client;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;

import mock.Mockable;
import mock.ValueProvider;
import mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt.ReturnsProvidedValues;

import com.documentum.fc.client.IDfCollection;
import com.documentum.fc.client.IDfQuery;
import com.documentum.fc.client.IDfSession;
import com.documentum.fc.common.DfException;

public class IDfQueryMock implements Mockable<IDfQuery> {
	public static Method EXECUTE_METHOD;
	public static Method GETDQL_METHOD;
	static {
		try {
			EXECUTE_METHOD = IDfQuery.class.getMethod("execute", IDfSession.class, Integer.TYPE);
			GETDQL_METHOD = IDfQuery.class.getMethod("getDQL");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private IDfQuery dfQuery = null;
	ValueProvider values = null;

	public IDfQueryMock() {
		this(null);
	}

	public IDfQueryMock(ValueProvider vals) {
		try {
			this.values = vals != null ? vals : getDefaultValueProvider();
			dfQuery = mock(IDfQuery.class);
			doNothing().when(dfQuery).setDQL(anyString());
			when(dfQuery.getDQL()).thenAnswer(new ReturnsProvidedValues<String>(values));
			when(dfQuery.execute((IDfSession) any(), anyInt())).thenAnswer(new ReturnsProvidedValues<IDfCollection>(values));
		} catch (DfException e) {
			e.printStackTrace();
		}
	}

	public ValueProvider getDefaultValueProvider() {
		ValueProvider vals = new ValueProvider();
		vals.add(GETDQL_METHOD, "dql1", "dql2");
		IDfCollection coll = new IDfCollectionMock().getMock();
		vals.add(EXECUTE_METHOD, coll);
		return vals;
	}

	@Override
	public IDfQuery getMock() {
		return dfQuery;
	}

	public static void main(String[] args) throws DfException, SecurityException, NoSuchMethodException {
		com.documentum.fc.client.IDfQuery mockedDFQuery = new IDfQueryMock().getMock();
		mockedDFQuery.setDQL("DQL");
		System.out.println(mockedDFQuery.getDQL());
		System.out.println(mockedDFQuery.getDQL());
		IDfCollection coll = mockedDFQuery.execute(null, 0);
		while (coll.next()) {
			System.out.println(coll.getString("string"));
			System.out.println(coll.getInt("string"));
			System.out.println(coll.getTime("string"));
			System.out.println(coll.getTime("string"));
		}
	}
}
