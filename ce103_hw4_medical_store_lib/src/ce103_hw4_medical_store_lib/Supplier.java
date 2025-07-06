package ce103_hw4_medical_store_lib;

public class Supplier 
{
	public static final int SUPPLIER_ID_LENGTH = 4;
	public static final int SUPPLIER_NAME_LENGTH = 30;
	public static final int CITY_LENGTH = 30;
	public static final int CONTACT_NO_LENGTH = 30;  
	public static final int EMAIL_ID_LENGTH = 30;    


	public static final int SUPPLIER_DATA_BLOCK_SIZE = SUPPLIER_ID_LENGTH +
	                                            SUPPLIER_NAME_LENGTH +
	                                            CITY_LENGTH +
	                                            CONTACT_NO_LENGTH +
	                                           EMAIL_ID_LENGTH ;
	                                         
	                                            
	                                            
	                                            
	                                            

	// Private Fields
	public int _supplierid;
	public String _suppliername;
	public String _city;
	public String _contactno;
	public String _emailID;





	// Public Properties

	public int getsupplierId() {
	    return _supplierid;
	}

	public void setsupplierId(int supplierid) {
	    this._supplierid = supplierid;
	}


	public String getsuppliername() {
	    return _suppliername;
	}

	public void setsuppliername(String suppliername) {
	    this._suppliername = suppliername;
	}

	public String getCity() {
	    return _city;
	}

	public void setCity(String city) {
	    this._city = city;
	}

	public String getContactNo() {
	    return _contactno;
	}

	public void setContactNo(String contactno) {
	    this._contactno = contactno;
	}

	public String getemailID() {
	    return _emailID;
	}

	public void setemailID(String emailID) {
	    this._emailID = emailID;
	}
	public static byte[] supplierToByteArrayBlock(Supplier supplier) {
		int index = 0;

		byte[] dataBuffer = new byte[Supplier.SUPPLIER_DATA_BLOCK_SIZE];

		// copy supplier id
		byte[] idBytes = ConversionUtility.integerToByteArray(supplier.getsupplierId());
		System.arraycopy(idBytes, 0, dataBuffer, index, idBytes.length);
		index += Supplier.SUPPLIER_ID_LENGTH;

		// copy supplier name
		byte[] nameBytes = ConversionUtility.stringToByteArray(supplier.getsuppliername());
		System.arraycopy(nameBytes, 0, dataBuffer, index, nameBytes.length);
		index += Supplier.SUPPLIER_NAME_LENGTH;

		// copy supplier city
		byte[] cityBytes = ConversionUtility.stringToByteArray(supplier.getCity());
		System.arraycopy(cityBytes, 0, dataBuffer, index, cityBytes.length);
		index += Supplier.CITY_LENGTH;

		// copy supplier phone
		byte[] phoneBytes = ConversionUtility.stringToByteArray(supplier.getContactNo());
		System.arraycopy(phoneBytes, 0, dataBuffer, index, phoneBytes.length);
		index += Supplier.CONTACT_NO_LENGTH;

		// copy supplier email
		byte[] emailBytes = ConversionUtility.stringToByteArray(supplier.getemailID());
		System.arraycopy(emailBytes, 0, dataBuffer,		index, emailBytes.length);
		index += Supplier.EMAIL_ID_LENGTH;

		if (index != dataBuffer.length) {
			throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");
		}

		return dataBuffer;
	}

	public static Supplier byteArrayBlockToSupplier(byte[] byteArray) {

		Supplier supplier = new Supplier();

		if (byteArray.length != Supplier.SUPPLIER_DATA_BLOCK_SIZE) {
			throw new IllegalArgumentException("Byte Array Size Not Match with Constant Data Block Size");
		}
		int index = 0;

		// copy supplier id
		byte[] idBytes = new byte[Supplier.SUPPLIER_ID_LENGTH];
		System.arraycopy(byteArray, index, idBytes, 0, idBytes.length);
		supplier.setsupplierId(ConversionUtility.byteArrayToInteger(idBytes));

		index += Supplier.SUPPLIER_ID_LENGTH;

		// copy supplier name
		byte[] nameBytes = new byte[Supplier.SUPPLIER_NAME_LENGTH];
		System.arraycopy(byteArray, index, nameBytes, 0, nameBytes.length);
		supplier.setsuppliername(ConversionUtility.byteArrayToString(nameBytes));

		index += Supplier.SUPPLIER_NAME_LENGTH;

		// copy supplier city
		byte[] cityBytes = new byte[Supplier.CITY_LENGTH];
		System.arraycopy(byteArray, index, cityBytes, 0, cityBytes.length);
		supplier.setCity(ConversionUtility.byteArrayToString(cityBytes));

		index += Supplier.CITY_LENGTH;
		
		// copy supplier phone
		byte[] phoneBytes = new byte[Supplier.CONTACT_NO_LENGTH];
		System.arraycopy(byteArray, index, phoneBytes, 0, phoneBytes.length);
		supplier.setContactNo(ConversionUtility.byteArrayToString(phoneBytes));

		index += Supplier.CONTACT_NO_LENGTH;

		// copy supplier email
		byte[] emailBytes = new byte[Supplier.EMAIL_ID_LENGTH];
		System.arraycopy(byteArray, index, emailBytes, 0, emailBytes.length);
		supplier.setemailID(ConversionUtility.byteArrayToString(emailBytes));

		index += Supplier.EMAIL_ID_LENGTH;

		return supplier;

	}
}