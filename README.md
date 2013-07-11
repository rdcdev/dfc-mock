dfc-mock
========

Documentum Foundations Classes Mocks

This library uses mockito-all-1.9.5.jar for mocking dfc.
The log4j-1.2.17.jar is used for unit tests.

Example of IdfCollection Mock:

ValueProvider values = new ValueProvider();
  	values.add(IDfCollection.class.getMethod("next"), true, true, true, false);
		values.add(IDfTypedObject.class.getMethod("getObjectId"), DfId.valueOf("0912345678945612"));
		IDfCollection mockedColl = new IDfCollectionMock().getMock();
		System.out.println(mockedColl.getString("subject"));
		System.out.println(mockedColl.getObjectId());
		System.out.println(mockedColl.next());
		System.out.println(mockedColl.next());
		System.out.println(mockedColl.next());
		System.out.println(mockedColl.next());
		mockedColl.close();
