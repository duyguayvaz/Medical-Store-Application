package ce103_hw4_medical_store_lib;

public class Bill 
{
	public static final int BILLNO_MAX_LENGTH = 4;
	public static final int ID_MAX_LENGTH = 9;
	public static final int CUSTOMERNAME_MAX_LENGTH = 25;
	public static final int MEDICINENAME_MAX_LENGTH = 25;
	public static final int QUANTITY_MAX_LENGTH = 9;
	public static final int RATE_MAX_LENGTH = 9;

	public static final int Bill_DATA_BLOCK_SIZE = BILLNO_MAX_LENGTH +CUSTOMERNAME_MAX_LENGTH+MEDICINENAME_MAX_LENGTH+QUANTITY_MAX_LENGTH+RATE_MAX_LENGTH+ID_MAX_LENGTH;



	// Private Fields
	private String Billno;
	private int id;
	private String medicinename;
	private String customername;
	private String quantity;
	private int rate;

	// Public Properties
	public String getBillno() {
		return Billno;
	}

	public void setBillno(String Billno) {
		this.Billno = Billno;
	}
	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getmedicinename() {
		return medicinename;
	}

	public void setmedicinename(String medicinename) {
		this.medicinename = medicinename;
	}

	public String getcustomername() {
		return customername;
	}

	public void setcustomername(String customername) {
		this.customername = customername;
	}

	public String getquantity() {
		return quantity;
	}

	public void setquantity(String quantity) {
		this.quantity = quantity;
	}

	public int getrate() {
		return rate;
	}

	public void setrate(int rate) {
		this.rate = rate;
	}

	public static byte[] bookToByteArrayBlock(Bill book) {
		int index = 0;
		byte[] dataBuffer = new byte[Bill.Bill_DATA_BLOCK_SIZE];

		// copy Bill no
		byte[] BillnoBytes = ConversionUtility.stringToByteArray(book.getBillno());
		System.arraycopy(BillnoBytes, 0, dataBuffer, index, BillnoBytes.length);
		index += Bill.BILLNO_MAX_LENGTH;
		// copy id no
		byte[] idBytes = ConversionUtility.integerToByteArray(book.getid());
		System.arraycopy(idBytes, 0, dataBuffer, index, idBytes.length);
		index += Bill.ID_MAX_LENGTH;
		// copy medicine name
		byte[] medicinenameBytes = ConversionUtility.stringToByteArray(book.getmedicinename());
		System.arraycopy(medicinenameBytes, 0, dataBuffer, index, medicinenameBytes.length);
		index += Bill.MEDICINENAME_MAX_LENGTH;
		
		// copy  costumer name
		byte[] customernameBytes = ConversionUtility.stringToByteArray(book.getcustomername());
		System.arraycopy(customernameBytes, 0, dataBuffer, index, customernameBytes.length);
		index += Bill.CUSTOMERNAME_MAX_LENGTH;
		
		// copy quantity
		byte[] quantityBytes = ConversionUtility.stringToByteArray(book.getquantity());
		System.arraycopy(quantityBytes, 0, dataBuffer, index, quantityBytes.length);
		index += Bill.QUANTITY_MAX_LENGTH;
		
		// copy rate
		byte[] rateBytes = ConversionUtility.integerToByteArray(book.getrate());
		System.arraycopy(rateBytes, 0, dataBuffer, index, rateBytes.length);
		index += Bill.RATE_MAX_LENGTH;
		if (index != dataBuffer.length) {
			throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");
		}
		return dataBuffer;
	}

	public static Bill byteArrayBlockToBook(byte[] byteArray) {
		Bill Bill = new Bill();

		if (byteArray.length != ce103_hw4_medical_store_lib.Bill.Bill_DATA_BLOCK_SIZE) {
			throw new IllegalArgumentException("Byte Array Size Not Match with Constant Data Block Size");
		}
		int index = 0;

		// copy Bill no
		byte[] BillnoBytes = new byte[ce103_hw4_medical_store_lib.Bill.BILLNO_MAX_LENGTH];
		System.arraycopy(byteArray, index, BillnoBytes, 0, BillnoBytes.length);
		Bill.setBillno(ConversionUtility.byteArrayToString(BillnoBytes));

		index += ce103_hw4_medical_store_lib.Bill.BILLNO_MAX_LENGTH;
		
		// copy id no
			byte[] idBytes = new byte[ce103_hw4_medical_store_lib.Bill.ID_MAX_LENGTH];
			System.arraycopy(byteArray, index, idBytes, 0, idBytes.length);
			Bill.setid(ConversionUtility.byteArrayToInteger(idBytes));

			index += ce103_hw4_medical_store_lib.Bill.ID_MAX_LENGTH;
		
		// copy medicine name
		byte[] medicinenameBytes = new byte[ce103_hw4_medical_store_lib.Bill.MEDICINENAME_MAX_LENGTH];
		System.arraycopy(byteArray, index, medicinenameBytes, 0, medicinenameBytes.length);
		Bill.setmedicinename(ConversionUtility.byteArrayToString(medicinenameBytes));
		
		index += ce103_hw4_medical_store_lib.Bill.MEDICINENAME_MAX_LENGTH;
		
		// copy customer name
		byte[] customernameBytes = new byte[ce103_hw4_medical_store_lib.Bill.CUSTOMERNAME_MAX_LENGTH];
		System.arraycopy(byteArray, index, customernameBytes, 0, customernameBytes.length);
		Bill.setcustomername(ConversionUtility.byteArrayToString(customernameBytes));

		index += ce103_hw4_medical_store_lib.Bill.CUSTOMERNAME_MAX_LENGTH;
		
		// copy quantity
		byte[] quantityBytes = new byte[ce103_hw4_medical_store_lib.Bill.QUANTITY_MAX_LENGTH];
		System.arraycopy(byteArray, index, quantityBytes, 0, quantityBytes.length);
		Bill.setquantity(ConversionUtility.byteArrayToString(quantityBytes));

		index += ce103_hw4_medical_store_lib.Bill.QUANTITY_MAX_LENGTH;
		
		// copy rate
		byte[] rateBytes = new byte[ce103_hw4_medical_store_lib.Bill.RATE_MAX_LENGTH];
		System.arraycopy(byteArray, index, rateBytes, 0, rateBytes.length);
		Bill.setrate(ConversionUtility.byteArrayToInteger(rateBytes));

		index += ce103_hw4_medical_store_lib.Bill.RATE_MAX_LENGTH;
		return Bill;
	}

}