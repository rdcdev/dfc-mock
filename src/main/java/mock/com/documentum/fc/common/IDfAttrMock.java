package mock.com.documentum.fc.common;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;

import com.documentum.fc.common.IDfAttr;

import mock.Mockable;
import mock.ValueProvider;
import mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt.ReturnsProvidedValues;

public class IDfAttrMock implements Mockable<IDfAttr> {
	public static Method GETID_METHOD;
	public static Method ISREPEATING_METHOD;
	public static Method GETDATATYPE_METHOD;
	public static Method GETNAME_METHOD;
	public static Method GETLENGTH_METHOD;
	static {
		try {
			GETID_METHOD = IDfAttr.class.getMethod("getId");
			ISREPEATING_METHOD = IDfAttr.class.getMethod("isRepeating");
			GETDATATYPE_METHOD = IDfAttr.class.getMethod("getDataType");
			GETNAME_METHOD = IDfAttr.class.getMethod("getName");
			GETLENGTH_METHOD = IDfAttr.class.getMethod("getLength");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private IDfAttr idfAttr = null;
	ValueProvider values = null;

	public IDfAttrMock() {
		this(null);
	}

	public IDfAttrMock(ValueProvider vals) {
		values = vals != null ? vals : getDefaultValueProvider();
		idfAttr = mock(IDfAttr.class);
		when(idfAttr.getLength()).thenAnswer(new ReturnsProvidedValues<Integer>(values));
		when(idfAttr.getName()).thenAnswer(new ReturnsProvidedValues<String>(values));
		when(idfAttr.getDataType()).thenAnswer(new ReturnsProvidedValues<Integer>(values));
		when(idfAttr.isRepeating()).thenAnswer(new ReturnsProvidedValues<Boolean>(values));
		when(idfAttr.getId()).thenAnswer(new ReturnsProvidedValues<String>(values));
	}

	public ValueProvider getDefaultValueProvider() {
		ValueProvider vals = new ValueProvider();
		vals.add(GETLENGTH_METHOD, 0, 1, 5);
		vals.add(GETNAME_METHOD, "MocketAttrName");
		vals.add(GETDATATYPE_METHOD, IDfAttr.DM_BOOLEAN, IDfAttr.DM_STRING);
		vals.add(ISREPEATING_METHOD, true, false);
		vals.add(GETID_METHOD, "MockedAttrId");
		return vals;
	}

	@Override
	public IDfAttr getMock() {
		return idfAttr;
	}

}
