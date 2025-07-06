package ce103_hw4_medical_store_lib;

public class Customer
{
	public final static int ID_LENGTH = 4;
	public final static int NAME_LENGTH = 100;
	public final static int CITY_LENGTH = 50;
	public final static int NUM_LENGTH= 30;
	public final static int EMAIL_LENGTH = 50;
	public final static int CUSTOMER_DATA_BLOCK_SIZE = ID_LENGTH + NAME_LENGTH + CITY_LENGTH + NUM_LENGTH + EMAIL_LENGTH;
	
	
	private int _id;
	private String _name;
	private String _city;
	private String _num;
	private String _email;
	
	public int getId() {
	    return _id;
	}

	public void setId(int id) {
	    this._id = id;
	}

	public String getName() {
	    return _name;
	}

	public void setName(String name) {
	    this._name = name;
	}


	public String getCity() {
	    return _city;
	}

	public void setCity(String city) {
	    this._city = city;
	}

	public String getNum() {
	    return _num;
	}

	public void setNum(String num) {
	    this._num = num;
	}
	public String getEmail() {
	    return _email;
	}

	public void setEmail(String emailID) {
	    this._email = emailID;
	}	


		public static byte[] customerToByteArrayBlock(Customer customer) 
		{
			int index = 0;

	        byte[] dataBuffer = new byte[CUSTOMER_DATA_BLOCK_SIZE];
	        
	       
	        byte[] idBytes = ConversionUtility.integerToByteArray(customer.getId());
	        System.arraycopy(idBytes, 0, dataBuffer, index, idBytes.length);
	        index += Customer.ID_LENGTH; 
	        
	        byte[]nameBytes = ConversionUtility.stringToByteArray(customer.getName());
	        System.arraycopy(nameBytes, 0, dataBuffer, index, nameBytes.length);
	        index += Customer.NAME_LENGTH;
	        
	        byte[] cityBytes = ConversionUtility.stringToByteArray(customer.getCity());
	    	System.arraycopy(cityBytes, 0, dataBuffer, index, cityBytes.length);
	    	index += Customer.CITY_LENGTH;
	        
	    	 byte[] numBytes = ConversionUtility.stringToByteArray(customer.getNum());
	     	System.arraycopy(numBytes, 0, dataBuffer, index, numBytes.length);
	     	index += Customer.NUM_LENGTH;
	        
	        byte[]emailBytes = ConversionUtility.stringToByteArray(customer.getEmail());
	        System.arraycopy(emailBytes, 0, dataBuffer, index, emailBytes.length);
	        index += Customer.EMAIL_LENGTH;
	        
	       
	        if (index != dataBuffer.length) {
	            throw new IllegalArgumentException("Index and DataBuffer Size Not Matched");
	        }

	        return dataBuffer;        
	    }
		 
		public static Customer ByteArrayBlockToCustomer(byte[] byteArray)
		{
			Customer customer = new Customer();
			
			 if (byteArray.length != CUSTOMER_DATA_BLOCK_SIZE)
	         {
				 throw new IllegalArgumentException("Byte Array Size Not Match with Constant Data Block Size");
	         }

	         int index = 0;
	         
	         
	         byte[] idBytes = new byte[Customer.ID_LENGTH];
	         System.arraycopy(byteArray, index, idBytes, 0, idBytes.length);
	         customer.setId(ConversionUtility.byteArrayToInteger(idBytes));

	         index += Customer.ID_LENGTH;
	         
	         
	         byte[] nameBytes = new byte[Customer.NAME_LENGTH];
	         System.arraycopy(byteArray, index, nameBytes, 0, nameBytes.length);
	         customer.setName(ConversionUtility.byteArrayToString(nameBytes));

	         index += Customer.NAME_LENGTH;
	         
	     	byte[] cityBytes = new byte[Customer.CITY_LENGTH];
	    	System.arraycopy(byteArray, index, cityBytes, 0, cityBytes.length);
	    	customer.setCity(ConversionUtility.byteArrayToString(cityBytes));

	    	index += Customer.CITY_LENGTH;
	    	
	    	
	    	byte[] numBytes = new byte[Customer.NUM_LENGTH];
	    	System.arraycopy(byteArray, index, numBytes, 0, numBytes.length);
	    	customer.setNum(ConversionUtility.byteArrayToString(numBytes));

	    	index += Customer.NUM_LENGTH;
	         
	         
	         
	         byte[] emailBytes = new byte[Customer.EMAIL_LENGTH];
	         System.arraycopy(byteArray, index, emailBytes, 0, emailBytes.length);
	         customer.setEmail(ConversionUtility.byteArrayToString(emailBytes));

	         index += Customer.EMAIL_LENGTH;
	         
	      
	             return customer;
	         }
		}
