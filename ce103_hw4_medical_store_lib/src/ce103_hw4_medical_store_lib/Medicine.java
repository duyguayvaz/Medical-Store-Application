package ce103_hw4_medical_store_lib;

public class Medicine 
{
	public static final int ID_LENGTH = 4;
	public static final int MEDICINENAME_MAX_LENGTH = 25;
	public static final int RACKNO_MAX_LENGTH = 9;
	public static final int CABNITNO_MAX_LENGTH = 25;
	public static final int COMPANYNAME_MAX_LENGTH = 25;
	public static final int SUPPLIERNAME_MAX_LENGTH = 25;
	public static final int MFGDATE_MAX_LENGTH = 10;
	public static final int EXPDATE_MAX_LENGTH = 10;
	public static final int UNITCOST_LENGTH = 9;
	public static final int SALECOST_LENGTH = 9;
	public static final int QUANTITY_LENGTH = 9;

	public static final int BOOK_DATA_BLOCK_SIZE = ID_LENGTH +MEDICINENAME_MAX_LENGTH+UNITCOST_LENGTH+SALECOST_LENGTH+QUANTITY_LENGTH +RACKNO_MAX_LENGTH+CABNITNO_MAX_LENGTH+COMPANYNAME_MAX_LENGTH+SUPPLIERNAME_MAX_LENGTH+MFGDATE_MAX_LENGTH+EXPDATE_MAX_LENGTH;

	private int id;
	private String medicinename;
	private String rackno;
	private String cabnitno;
	private String companyname;
	private String suppliername;
	private int mfgdate;
	private String expdate;
	private String unitcost;
	private String salecost;
	private String quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedicinename() {
		return medicinename;
	}

	public void setMedicinename(String medicinename) {
		this.medicinename = medicinename;
	}

	public String getRackno() {
		return rackno;
	}

	public void setRackno(String rackno) {
		this.rackno = rackno;
	}

	public String getCabnitno() {
		return cabnitno;
	}

	public void setCabnitno(String cabnitno) {
		this.cabnitno = cabnitno;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getSuppliername() {
		return suppliername;
	}

	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}


	public String getUnitcost() {
		return unitcost;
	}

	public void setUnitcost(String unitcost) {
		this.unitcost = unitcost;
	}

	public String getSalecost() {
		return salecost;
	}

	public void setSalecost(String salecost) {
		this.salecost = salecost;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getMfgdate() {
		return mfgdate;
	}

	public void setMfgdate(int mfgdate) {
		this.mfgdate = mfgdate;
	}

	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}



	public static byte[] bookToByteArrayBlock(Medicine book) {
		int index = 0;

		byte[] dataBuffer = new byte[Medicine.BOOK_DATA_BLOCK_SIZE];



		// copy id
		byte[] idBytes = ConversionUtility.integerToByteArray(book.getId());
		System.arraycopy(idBytes, 0, dataBuffer, index, idBytes.length);
		index += Medicine.ID_LENGTH;
		
		// copy medicine name
		byte[] medicinenameBytes = ConversionUtility.stringToByteArray(book.getMedicinename());
		System.arraycopy(medicinenameBytes, 0, dataBuffer, index, medicinenameBytes.length);
		index += Medicine.MEDICINENAME_MAX_LENGTH;
		
		// copy unit cost
		byte[] unitcostBytes = ConversionUtility.stringToByteArray(book.getUnitcost());
		System.arraycopy(unitcostBytes, 0, dataBuffer, index, unitcostBytes.length);
		index += Medicine.UNITCOST_LENGTH;
		
		// copy sale cost 
		byte[] salecostBytes = ConversionUtility.stringToByteArray(book.getSalecost());
		System.arraycopy(salecostBytes, 0, dataBuffer, index, salecostBytes.length);
		index += Medicine.SALECOST_LENGTH;
		
		// copy quantity
		byte[] quantityBytes = ConversionUtility.stringToByteArray(book.getQuantity());
		System.arraycopy(quantityBytes, 0, dataBuffer, index, quantityBytes.length);
		index += Medicine.QUANTITY_LENGTH;
		
		// copy rack no
		byte[] racknoBytes = ConversionUtility.stringToByteArray(book.getRackno());
		System.arraycopy(racknoBytes, 0, dataBuffer, index, racknoBytes.length);
		index += Medicine.RACKNO_MAX_LENGTH;
		
		// copy cabnit no
		byte[] cabnitnoBytes = ConversionUtility.stringToByteArray(book.getCabnitno());
		System.arraycopy(cabnitnoBytes, 0, dataBuffer, index, cabnitnoBytes.length);
		index += Medicine.CABNITNO_MAX_LENGTH;
		
		// copy  company name
		byte[] companynameBytes = ConversionUtility.stringToByteArray(book.getCompanyname());
		System.arraycopy(companynameBytes, 0, dataBuffer, index, companynameBytes.length);
		index += Medicine.COMPANYNAME_MAX_LENGTH;
		
		// copy supplier name
		byte[] suppliernameBytes = ConversionUtility.stringToByteArray(book.getSuppliername());
		System.arraycopy(suppliernameBytes, 0, dataBuffer, index, suppliernameBytes.length);
		index += Medicine.SUPPLIERNAME_MAX_LENGTH;
		
		// copy mfg date
		byte[] mfgdateBytes = ConversionUtility.integerToByteArray(book.getMfgdate());
		System.arraycopy(mfgdateBytes, 0, dataBuffer, index, mfgdateBytes.length);
		index += Medicine.MFGDATE_MAX_LENGTH;
		
		// copy exp date
		byte[] expdateBytes = ConversionUtility.stringToByteArray(book.getExpdate());
		System.arraycopy(expdateBytes, 0, dataBuffer, index, expdateBytes.length);
		index += Medicine.EXPDATE_MAX_LENGTH;
		
		if (index != dataBuffer.length) {
			throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");
		}

		return dataBuffer;
	}

	public static Medicine byteArrayBlockToBook(byte[] byteArray) {

		Medicine Medicine = new Medicine();

		if (byteArray.length != ce103_hw4_medical_store_lib.Medicine.BOOK_DATA_BLOCK_SIZE) {
			throw new IllegalArgumentException("Byte Array Size Not Match with Constant Data Block Size");
		}
		int index = 0;

		// copy id
		byte[] idBytes = new byte[ce103_hw4_medical_store_lib.Medicine.ID_LENGTH];
		System.arraycopy(byteArray, index, idBytes, 0, idBytes.length);
		Medicine.setId(ConversionUtility.byteArrayToInteger(idBytes));

		index += ce103_hw4_medical_store_lib.Medicine.ID_LENGTH;
		
		// copy medicine name
		byte[] medicinenameBytes = new byte[ce103_hw4_medical_store_lib.Medicine.MEDICINENAME_MAX_LENGTH];
		System.arraycopy(byteArray, index, medicinenameBytes, 0, medicinenameBytes.length);
		Medicine.setMedicinename(ConversionUtility.byteArrayToString(medicinenameBytes));
		
		index += ce103_hw4_medical_store_lib.Medicine.MEDICINENAME_MAX_LENGTH;
		
		// copy unit cost
		byte[] unitcostBytes = new byte[ce103_hw4_medical_store_lib.Medicine.UNITCOST_LENGTH];
		System.arraycopy(byteArray, index, unitcostBytes, 0, unitcostBytes.length);
		Medicine.setUnitcost(ConversionUtility.byteArrayToString(unitcostBytes));

		index += ce103_hw4_medical_store_lib.Medicine.UNITCOST_LENGTH;
		
		// copy sale cost
		byte[] salecostBytes = new byte[ce103_hw4_medical_store_lib.Medicine.SALECOST_LENGTH];
		System.arraycopy(byteArray, index, salecostBytes, 0, salecostBytes.length);
		Medicine.setSalecost(ConversionUtility.byteArrayToString(salecostBytes));

		index += ce103_hw4_medical_store_lib.Medicine.SALECOST_LENGTH;
		
		// copy quantity
		byte[] quantityBytes = new byte[ce103_hw4_medical_store_lib.Medicine.QUANTITY_LENGTH];
		System.arraycopy(byteArray, index, quantityBytes, 0, quantityBytes.length);
		Medicine.setQuantity(ConversionUtility.byteArrayToString(quantityBytes));

		index += ce103_hw4_medical_store_lib.Medicine.QUANTITY_LENGTH;
		
		// copy rack no
		byte[] racknoBytes = new byte[ce103_hw4_medical_store_lib.Medicine.RACKNO_MAX_LENGTH];
		System.arraycopy(byteArray, index, racknoBytes, 0, racknoBytes.length);
		Medicine.setRackno(ConversionUtility.byteArrayToString(racknoBytes));
		
		index += ce103_hw4_medical_store_lib.Medicine.RACKNO_MAX_LENGTH;
		
		// copy cabnit no
		byte[] cabnitnoBytes = new byte[ce103_hw4_medical_store_lib.Medicine.CABNITNO_MAX_LENGTH];
		System.arraycopy(byteArray, index, cabnitnoBytes, 0, cabnitnoBytes.length);
		Medicine.setCabnitno(ConversionUtility.byteArrayToString(cabnitnoBytes));
		
		index += ce103_hw4_medical_store_lib.Medicine.CABNITNO_MAX_LENGTH;
		
		// copy company name
		byte[] companynameBytes = new byte[ce103_hw4_medical_store_lib.Medicine.COMPANYNAME_MAX_LENGTH];
		System.arraycopy(byteArray, index, companynameBytes, 0, companynameBytes.length);
		Medicine.setCompanyname(ConversionUtility.byteArrayToString(companynameBytes));
		
		index += ce103_hw4_medical_store_lib.Medicine.COMPANYNAME_MAX_LENGTH;
		
		// copy supplier name
		byte[] suppliernameBytes = new byte[ce103_hw4_medical_store_lib.Medicine.SUPPLIERNAME_MAX_LENGTH];
		System.arraycopy(byteArray, index, suppliernameBytes, 0, suppliernameBytes.length);
		Medicine.setSuppliername(ConversionUtility.byteArrayToString(suppliernameBytes));
		
		index += ce103_hw4_medical_store_lib.Medicine.SUPPLIERNAME_MAX_LENGTH;
		
		// copy mfg date
		byte[] mfgdateBytes = new byte[ce103_hw4_medical_store_lib.Medicine.MFGDATE_MAX_LENGTH];
		System.arraycopy(byteArray, index, mfgdateBytes, 0, mfgdateBytes.length);
		Medicine.setExpdate(ConversionUtility.byteArrayToString(mfgdateBytes));
		
		index += ce103_hw4_medical_store_lib.Medicine.MFGDATE_MAX_LENGTH;
		
		// copy exp date
		byte[] expdateBytes = new byte[ce103_hw4_medical_store_lib.Medicine.EXPDATE_MAX_LENGTH];
		System.arraycopy(byteArray, index, expdateBytes, 0, expdateBytes.length);
		Medicine.setExpdate(ConversionUtility.byteArrayToString(expdateBytes));
		
		index += ce103_hw4_medical_store_lib.Medicine.EXPDATE_MAX_LENGTH;
				

		return Medicine;
	}
}
