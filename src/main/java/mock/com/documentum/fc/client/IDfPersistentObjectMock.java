package mock.com.documentum.fc.client;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import mock.ValueProvider;
import mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt.ReturnsSuperMockAnswer;

import com.documentum.fc.client.IDfPersistentObject;
import com.documentum.fc.client.IDfTypedObject;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.IDfTime;

public class IDfPersistentObjectMock extends IDfTypedObjectMock {
	private IDfPersistentObject persObj = null;

	public IDfPersistentObjectMock() {
		this(null);
	}

	public IDfPersistentObjectMock(ValueProvider vals) {
		super(vals);
		persObj = mock(IDfPersistentObject.class);
		try {
			when(persObj.getObjectId()).thenAnswer(new ReturnsSuperMockAnswer<String, IDfTypedObject>(super.getMock()));
			when(persObj.getId(anyString())).thenAnswer(new ReturnsSuperMockAnswer<String, IDfTypedObject>(super.getMock()));
			when(persObj.getString(anyString())).thenAnswer(new ReturnsSuperMockAnswer<String, IDfTypedObject>(super.getMock()));
			when(persObj.getTime(anyString())).thenAnswer(new ReturnsSuperMockAnswer<IDfTime, IDfTypedObject>(super.getMock()));
		} catch (DfException e) {
			e.printStackTrace();
		}

	}

	@Override
	public com.documentum.fc.client.IDfPersistentObject getMock() {
		return persObj;
	}
}
