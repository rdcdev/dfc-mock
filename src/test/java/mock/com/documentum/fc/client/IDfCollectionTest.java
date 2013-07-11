package mock.com.documentum.fc.client;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.documentum.fc.client.IDfType;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.DfId;
import com.documentum.fc.common.DfTime;

public class IDfCollectionTest {
	com.documentum.fc.client.IDfCollection testedColl = null;
	Map<Integer, List<?>> valueProvider = null;
/**
 * 
 */
	@Before
	public void setUp() {
		setUpValuesProvider();
//		testedColl = new IDfCollection(valueProvider).getMock();
	}

	private void setUpValuesProvider() {
		valueProvider = new HashMap<Integer, List<?>>();
		valueProvider.put(IDfType.DF_ID, Arrays.asList(DfId.DF_NULLID, DfId.valueOf("0912365987456321")));
		valueProvider.put(IDfType.DF_STRING, Arrays.asList("str0", "str1", "str2"));
		valueProvider.put(IDfType.DF_TIME, Arrays.asList(new DfTime(), new DfTime(), new DfTime(new Date(0)), new DfTime()));
	}

	@Test
	public void getObjectId() throws DfException {
		assertEquals(valueProvider.get(IDfType.DF_ID).get(0), testedColl.getObjectId());
		assertEquals(valueProvider.get(IDfType.DF_ID).get(1), testedColl.getObjectId());
		assertEquals(valueProvider.get(IDfType.DF_ID).get(0), testedColl.getObjectId());
		assertEquals(valueProvider.get(IDfType.DF_ID).get(1), testedColl.getObjectId());
		assertNotSame(valueProvider.get(IDfType.DF_ID).get(1), testedColl.getObjectId());
	}

	@Test
	public void getString() throws DfException {
		assertEquals(valueProvider.get(IDfType.DF_STRING).get(0), testedColl.getString(""));
		assertEquals(valueProvider.get(IDfType.DF_STRING).get(1), testedColl.getString(""));
		assertEquals(valueProvider.get(IDfType.DF_STRING).get(2), testedColl.getString(""));
		assertEquals(valueProvider.get(IDfType.DF_STRING).get(0), testedColl.getString(""));
		assertEquals(valueProvider.get(IDfType.DF_STRING).get(1), testedColl.getString(""));
		assertEquals(valueProvider.get(IDfType.DF_STRING).get(2), testedColl.getString(""));
	}

	@Test
	public void getAllRepeatingStrings() throws DfException {
		assertEquals(valueProvider.get(IDfType.DF_STRING).get(0), testedColl.getAllRepeatingStrings("", ","));
		assertEquals(valueProvider.get(IDfType.DF_STRING).get(1), testedColl.getAllRepeatingStrings("", ","));
		assertEquals(valueProvider.get(IDfType.DF_STRING).get(2), testedColl.getAllRepeatingStrings("", ","));
		assertEquals(valueProvider.get(IDfType.DF_STRING).get(0), testedColl.getAllRepeatingStrings("", ","));
		assertEquals(valueProvider.get(IDfType.DF_STRING).get(1), testedColl.getAllRepeatingStrings("", ","));
		assertEquals(valueProvider.get(IDfType.DF_STRING).get(2), testedColl.getAllRepeatingStrings("", ","));
		assertNotSame(valueProvider.get(IDfType.DF_STRING).get(2), testedColl.getAllRepeatingStrings("", ","));
	}

	@Test
	public void getTime() throws DfException {
		assertEquals(valueProvider.get(IDfType.DF_TIME).get(0), testedColl.getTime(""));
		assertEquals(valueProvider.get(IDfType.DF_TIME).get(1), testedColl.getTime(""));
		assertEquals(valueProvider.get(IDfType.DF_TIME).get(2), testedColl.getTime(""));
		assertEquals(valueProvider.get(IDfType.DF_TIME).get(3), testedColl.getTime(""));
		assertEquals(valueProvider.get(IDfType.DF_TIME).get(0), testedColl.getTime("1"));
		assertEquals(valueProvider.get(IDfType.DF_TIME).get(1), testedColl.getTime("1"));
		assertEquals(valueProvider.get(IDfType.DF_TIME).get(2), testedColl.getTime("1"));
		assertEquals(valueProvider.get(IDfType.DF_TIME).get(3), testedColl.getTime("1"));
		assertNotSame(valueProvider.get(IDfType.DF_TIME).get(3), testedColl.getTime("1"));
	}

}
