package mock.com.documentum.fc.client;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import mock.ValueProvider;
import mock.org.mockito.internal.stubbing.answers.ReturnsArgumentAt.ReturnsSuperMockAnswer;

import com.documentum.fc.client.IDfFolder;
import com.documentum.fc.client.IDfSysObject;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.IDfTime;

public class IDfFolderMock extends IDfSysObjectMock {
	IDfFolder folder = null;

	public IDfFolderMock() {
		this(null);
	}

	public IDfFolderMock(ValueProvider vals) {
		super(vals);
		folder = mock(IDfFolder.class);
		try {
			when(folder.getString(anyString())).thenAnswer(new ReturnsSuperMockAnswer<String, IDfSysObject>(super.getMock()));
			when(folder.getTime(anyString())).thenAnswer(new ReturnsSuperMockAnswer<IDfTime, IDfSysObject>(super.getMock()));
		} catch (DfException e) {
			e.printStackTrace();
		}
	}

	@Override
	public IDfFolder getMock() {
		return folder;
	}

	public static void main(String[] args) throws DfException {
		IDfFolder folMock = new IDfFolderMock(null).getMock();
		System.out.println(folMock.getString("sdfds"));
		System.out.println(folMock.getTime("sdfds"));
		System.out.println(folMock.getTime("sdfds"));
	}

}
