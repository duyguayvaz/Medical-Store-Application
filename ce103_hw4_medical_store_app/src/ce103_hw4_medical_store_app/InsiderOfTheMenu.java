package ce103_hw4_medical_store_app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


import ce103_hw4_medical_store_lib.FileUtility;
import ce103_hw4_medical_store_lib.Bill;
import ce103_hw4_medical_store_lib.Customer;
import ce103_hw4_medical_store_lib.Medicine;
import ce103_hw4_medical_store_lib.Supplier;

public class InsiderOfTheMenu {
	
	// This method reads input from the user and returns an integer
	public int getInput() 
	{
		// Create a Scanner object to read input from the user
		Scanner kb = new Scanner(System.in);
		
		// Initialize the choice variable to a value that is not in the valid range
		int choice = -1;
		
		// Keep reading input until the user enters a valid choice
		while (choice < 0 || choice > 6) {
			try {
				// Move the cursor to the specified position
				gotoxy(5, 40);
		    	
				// Print a prompt for the user
		    	System.out.println("Press First Character for further Operations ");
				
				// Read the user's input and parse it as an integer
				choice = Integer.parseInt(kb.nextLine());
			} catch (NumberFormatException e) {
				// If the user's input is not a valid integer, print an error message
				System.out.println("invalid");
			}
		}
		
		// Return the user's choice
		return choice;
	}

	// This method moves the cursor to the specified position
	static void gotoxy(int collumn, int row) {
		// Print the escape sequence to move the cursor to the specified position
		System.out.print("\033[" + row + ";" + collumn + "H");
	}

		
		// This method clears the console
		public void clear() 
		{
			try 
			{
			    // Execute the "cls" command to clear the console
			    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} catch (Exception e) {
			    // Print the stack trace if an exception is thrown
			    e.printStackTrace();
			}
		}

		// This is the main method of the class
		public static void mainmenu() {
			
			// Create a DateTimeFormatter object to format the current date
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
			
			// Get the current date
			LocalDate localDate = LocalDate.now();
			
			// Create a DateTimeFormatter object to format the current time
			DateTimeFormatter dtfe = DateTimeFormatter.ofPattern("HH:mm:ss");
			
			// Get the current time
			LocalTime localTime = LocalTime.now();
			
			// Call the main_box and box1 methods
			main_box();
			box1();
			
			// Print the welcome message and menu options
	        gotoxy(30,10);
	        System.out.println("Welcome To Medical Store"); 
			gotoxy(4, 5);
			System.out.println("Supplier Info");
			gotoxy(19, 5);
			System.out.println("Customer Info");
			gotoxy(36, 5);
			System.out.println("Medicine");
			gotoxy(48, 5);
			System.out.println("Report");
			gotoxy(57, 5);
			System.out.println("Bill");
			gotoxy(64, 5);
			System.out.println("About");
			gotoxy(72, 5);
			System.out.println("Exit");
			
			// Print the current date and time
	        gotoxy(55,47);
	        System.out.println("Date: "+dtf.format(localDate));	
	        gotoxy(55,49);
	        System.out.println("Time: "+dtfe.format(localTime));		
		}
	


		// This method draws a box on the console
		public static void main_box() 
		{
			// Declare a loop counter variable
			int i;
			
			// Print the top left corner of the box
			gotoxy(1, 6);
			System.out.print("\u2554");
			
			// Print the top of the box (horizontal line)
			for (i = 1; i < 79; i++) 
			{
				gotoxy(1 + i, 6);
				System.out.print("\u2550");
			}
			
			// Print the top right corner of the box
			gotoxy(80, 6);
			System.out.print("\u2557");
			
			// Print the left side of the box (vertical line)
			gotoxy(1, 6);
			for (i = 5; i < 35; i++) 
			{
				gotoxy(1, 2 + i);
				System.out.print("\u2551");
			}
			
			// Print the bottom left corner of the box
			gotoxy(1, 37);
			System.out.print("\u255A");
			
			// Print the bottom of the box (horizontal line)
			for (i = 1; i < 79; i++) 
			{
				gotoxy(1 + i, 37);
				System.out.print("\u2550");
			}
			
			// Print the bottom right corner of the box
			gotoxy(80, 37);
			System.out.print("\u255D");
			
			// Print the right side of the box (vertical line)
			gotoxy(80, 6);
			for (i = 5; i < 35; i++) 
			{
				gotoxy(80, 2 + i);
				System.out.print("\u2551");
			}
		}
	

		// This method draws a box on the console
		public static void box1() 
	    {      
			// Declare a loop counter variable
			int i;
			
			// Print the top left corner of the box
			gotoxy(1,3);
			System.out.print("\u2554");
			
			// Print the top of the box (horizontal line)
			for(i=1;i<79;i++)
			{
			    gotoxy(1+i,3);
			    System.out.print("\u2550");
			}
			
			// Print the top right corner of the box
			gotoxy(80,3);
			System.out.print("\u2557");
			
			// Print the left side of the box (vertical line)
			gotoxy(1,3);
			for(i=4;i<10;i++)
			{
			    gotoxy(1,i);
			    System.out.print("\u2551");
			}
			
			// Print the right side of the box (vertical line)
			gotoxy(1,9);
			for(i=4;i<8;i++)
			{
			    gotoxy(80,i);
			    System.out.print("\u2551");
			}
		}
	
		// This method displays the supplier menu on the console
		public void supplier()
		{
			// Clear the console
			System.out.print("\033[H\033[2J");
			System.out.flush();
			
			// Print the menu title and options
			gotoxy(34, 3);
			System.out.print("----------------");
			gotoxy(35, 4);
			System.out.print("Supplier MENU");
			gotoxy(34, 5);
			System.out.print("----------------");
			gotoxy(26, 11);
			System.out.print("Add New Supplier");
			gotoxy(26, 15);
			System.out.print("Update Supplier");
			gotoxy(26, 19);
			System.out.print("Search Supplier");
			gotoxy(26, 23);
			System.out.print("List of Existing Supplier");
			gotoxy(26, 27);
			System.out.print("Main Menu");
			
			// Call the main_box method to draw a box on the console
			main_box();
		}
	

	public void listsupp() throws IOException 
	{
		try {
			new Supplier();
		    int p = 1;
			String fileName = "supplier.dat";
			FileReader fileReader = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fileReader);
			String datlength = br.readLine();
			br.close();
			int b = datlength.length();
			 int i=14;
			 
		do
		{

	    String path = System.getProperty("user.dir");
	    new File(path + File.separator + fileName);
	    byte[] bookWrittenBytes = FileUtility.readBlock(p, Supplier.SUPPLIER_DATA_BLOCK_SIZE, fileName);
	    Supplier bookWrittenObject = Supplier.byteArrayBlockToSupplier(bookWrittenBytes);
	    
	    if (bookWrittenObject != null)
	    {
	    	
	        gotoxy(34,3);
		    System.out.print("______________");
		      gotoxy(35,4);
		      System.out.print("SUPPLIER LIST");
		      gotoxy(34,5);
		      System.out.print("______________");
		      gotoxy(3,11);
		      System.out.print("ID ."); 
		      gotoxy(10,11);
		      System.out.print("SUPPLIER NAME .");
		      gotoxy(30,11);
		      System.out.print("PH.NO.");
		      gotoxy(44,11);
		      System.out.print("CITY.");
		      gotoxy(56,11);
		      System.out.print("EMAIL.");
		      gotoxy(2,13);
		      System.out.print("======================================================================="); 
		   
	  	    
	  	   
	        gotoxy(4,i);
	        System.out.println(bookWrittenObject.getsupplierId());
	        gotoxy(9,i);
	        System.out.println(bookWrittenObject.getsuppliername());
	        gotoxy(29,i);
	        System.out.println(bookWrittenObject.getCity());
	        gotoxy(41,i);
	        System.out.println(bookWrittenObject.getContactNo());
	        gotoxy(54,i);
	        System.out.println(bookWrittenObject.getemailID());
	        
			i++;
			
	    }
	    p++;
		} while (p < (((b) / (Supplier.SUPPLIER_DATA_BLOCK_SIZE)) + 1));
		main_box();
		 Scanner scanner = new Scanner(System.in);
		  gotoxy(8,42);
		  System.out.print("Press Enter to go to MAIN MENU !!!"); 
		  scanner.nextLine();
		  supplier();
		 // scanner.close();

					} catch (IOException e) {
						 e.printStackTrace(); 
					} 

		}

	public void listcust() throws IOException 

	{
		int p = 1;
		String fileName = "customer.dat";
		FileReader fileReader = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fileReader);
		String datlength = br.readLine();
		br.close();
		int b = datlength.length();
		clear();
		int i = 14;
		do {

			String path = System.getProperty("user.dir");
			new File(path + File.separator + fileName);
			byte[] writtenBytes = FileUtility.readBlock(p, Customer.CUSTOMER_DATA_BLOCK_SIZE, fileName);
			Customer writtenObject = Customer.ByteArrayBlockToCustomer(writtenBytes);

			if (writtenObject != null) 
			{

				gotoxy(4, 12);
				System.out.print("ID");
				gotoxy(9, 12);
				System.out.println("Name");
				gotoxy(29, 12);
				System.out.println("City");
				gotoxy(41, 12);
				System.out.println("Contact No");
				gotoxy(54, 12);
				System.out.println("Email Id");

				gotoxy(4, i);
				System.out.println(writtenObject.getId());
				gotoxy(9, i);
				System.out.println(writtenObject.getName());
				gotoxy(29, i);
				System.out.println(writtenObject.getCity());
				gotoxy(41, i);
				System.out.println(writtenObject.getNum());
				gotoxy(54, i);
				System.out.println(writtenObject.getEmail());

				i++;
			}
			p++;
			
		} while (p < (((b) / (Customer.CUSTOMER_DATA_BLOCK_SIZE)) + 1));
		main_box();
		Scanner scanner = new Scanner(System.in);
		  gotoxy(8,42);
		  System.out.print("Press Enter to go to MAIN MENU !!!"); 
		  scanner.nextLine();
		  customer(); 
		
		
	}

	public void listmedicine() throws IOException
	{
		int p2 = 1;
		String file2Name = "medicine.dat";
		FileReader file2Reader = new FileReader(file2Name);
		BufferedReader br = new BufferedReader(file2Reader);
		String dat2length = br.readLine();
		br.close();
		int b2 = dat2length.length();
		clear();
		int i2 = 14;
		do {

			String path = System.getProperty("user.dir");
			new File(path + File.separator + file2Name);
			byte[] bookWrittenBytes = FileUtility.readBlock(p2, Medicine.BOOK_DATA_BLOCK_SIZE, file2Name);
			Medicine bookWrittenObject = Medicine.byteArrayBlockToBook(bookWrittenBytes);
			
			bookWrittenObject.getMedicinename();
			bookWrittenObject.getCabnitno();
			bookWrittenObject.getCompanyname();
			bookWrittenObject.getExpdate();
			bookWrittenObject.getMfgdate();
			bookWrittenObject.getQuantity();
			bookWrittenObject.getRackno();
			bookWrittenObject.getSalecost();
			bookWrittenObject.getSuppliername();
			bookWrittenObject.getUnitcost();
			bookWrittenObject.getId();
			
			if (bookWrittenObject != null) {

				gotoxy(4, 12);
				System.out.print("ID");
				gotoxy(9, 12);
				System.out.println("Name");
				gotoxy(29, 12);
				System.out.println("City");
				gotoxy(41, 12);
				System.out.println("Contact No");
				gotoxy(54, 12);
				System.out.println("Email Id");

				gotoxy(4, i2);
				System.out.println(bookWrittenObject.getId());
				gotoxy(9, i2);
				System.out.println(bookWrittenObject.getCabnitno());
				gotoxy(29, i2);
				System.out.println(bookWrittenObject.getMedicinename());
				gotoxy(41, i2);
				System.out.println(bookWrittenObject.getCompanyname());
				gotoxy(54, i2);
				System.out.println(bookWrittenObject.getExpdate());
				System.out.println(bookWrittenObject.getMfgdate());
				gotoxy(9, i2);
				System.out.println(bookWrittenObject.getQuantity());
				gotoxy(29, i2);
				System.out.println(bookWrittenObject.getRackno());
				gotoxy(41, i2);
				System.out.println(bookWrittenObject.getSalecost());
				gotoxy(54, i2);
				System.out.println(bookWrittenObject.getSuppliername());
				System.out.println(bookWrittenObject.getUnitcost());
				gotoxy(41, i2);

				i2++;
			}
			p2++;
		} while (p2 < (((b2) / (Medicine.BOOK_DATA_BLOCK_SIZE)) + 1));
		main_box();
		
	
		Scanner a1 = new Scanner(System.in);
		a1.next().charAt(0);
	}
	
	public void stockmedicine() throws IOException {
        clear();
    	gotoxy(9,10);
		System.out.println("ID.   MEDICINE NAME.    QTY     Supplier Name     Exp.Date");
		gotoxy(9,12);
		System.out.println("===========================================================\n");
	
		int p22 = 1;
		String file2Name2 = "medicine.dat";
		FileReader file22Reader = new FileReader(file2Name2);
		BufferedReader br = new BufferedReader(file22Reader);
		String dat22length = br.readLine();
		br.close();
		int b22 = dat22length.length();
		int i22 = 14;
		do {
			byte[] bookWrittenBytes11 = FileUtility.readBlock(p22, Medicine.BOOK_DATA_BLOCK_SIZE, file2Name2);
			Medicine bookWrittenObject11 = Medicine.byteArrayBlockToBook(bookWrittenBytes11);

			if (bookWrittenObject11 != null) {

				gotoxy(9, i22);
				System.out.println(bookWrittenObject11.getId());
				gotoxy(15, i22);
				System.out.println(bookWrittenObject11.getMedicinename());
				gotoxy(33, i22);
				System.out.println(bookWrittenObject11.getQuantity());
				gotoxy(41, i22);
				System.out.println(bookWrittenObject11.getSuppliername());
				gotoxy(59, i22);
				System.out.println(bookWrittenObject11.getExpdate());
	
				i22++;
			}
			p22++;
		} while (p22 < (((b22) / (Medicine.BOOK_DATA_BLOCK_SIZE)) + 1));
		main_box();
	
		Scanner a1 = new Scanner(System.in);
		Character kl = a1.next().charAt(0);
    }
	
	public void customer() 
	{
		clear();
		gotoxy(34, 3);
		System.out.print("----------------");
		gotoxy(35, 4);
		System.out.print("Customer MENU");
		gotoxy(34, 5);
		System.out.print("----------------");
		gotoxy(26, 11);
		System.out.print("Add New Customer");
		gotoxy(26, 15);
		System.out.print("Update Customer");
		gotoxy(26, 19);
		System.out.print("Search Customer");
		gotoxy(26, 23);
		System.out.print("List of Existing Customer");
		gotoxy(26, 27);
		System.out.print("Main Menu");
		main_box();

	}

	public void medicine() throws IOException 
	{
		// Clear screen
		System.out.print("\033[H\033[2J");
		System.out.flush();
		// Menu
		gotoxy(34, 3);
		System.out.print("----------------");
		gotoxy(35, 4);
		System.out.print("Medicine MENU");
		gotoxy(34, 5);
		System.out.print("----------------");
		gotoxy(26, 15);
		System.out.print("Purchase New Medicine");
		gotoxy(26, 19);
		System.out.print("Sale Medicine");
		gotoxy(26, 23);
		System.out.print("Stock of Medicine");
		gotoxy(26, 27);
		System.out.print("Search Medicine");
		gotoxy(26, 31);
		System.out.print("Main Menu");
		main_box();
	}

	public void report() 
	{
		// Clear screen
		System.out.print("\033[H\033[2J");
		System.out.flush();
		// Menu
		gotoxy(34, 3);
		System.out.print("----------------");
		gotoxy(35, 4);
		System.out.print("Report MENU");
		gotoxy(34, 5);
		System.out.print("----------------");
		gotoxy(26, 12);
		System.out.print("Purchase Report");
		gotoxy(26, 16);
		System.out.print("Sale Report");
		gotoxy(26, 20);
		System.out.print("Profit Report");
		gotoxy(26, 24);
		System.out.print("Daily Sale Report");
		gotoxy(26, 28);
		System.out.print("Daily Purchase Report");
		gotoxy(26, 32);
		System.out.print("Main Menu");
		main_box();

	}

	public void addSupplier()

	{
		clear();
		main_box();
		gotoxy(30, 8);
		System.out.println("SUPPLIER ENTRY ");
		gotoxy(8, 13);
		System.out.println("SUPPLIER ID : ");
		gotoxy(39, 13);
		System.out.println("SUPPLIER NAME : ");
		gotoxy(8, 18);
		System.out.println("CITY        : ");
		gotoxy(39, 18);
		System.out.println("CONTACT NO.   : ");
		gotoxy(8, 23);
		System.out.println("EMAIL ID    : ");

		gotoxy(22, 13);
		int id = Integer.parseInt(System.console().readLine());
		gotoxy(55, 13);
		String title = System.console().readLine();
		gotoxy(22, 18);
		String city = System.console().readLine();
		gotoxy(55, 18);
		String num = System.console().readLine();
		gotoxy(22, 23);
		String email = System.console().readLine();

		Supplier book = new Supplier();
		book.setsupplierId(id);
		book.setsuppliername(title);
		book.setCity(city);
		book.setContactNo(num);
		book.setemailID(email);

		clear();
		gotoxy(20, 30);
		System.out.println("Save");
		gotoxy(28, 30);
		System.out.println("Cancel");
		gotoxy(18, 36);
		System.out.println("Press First charecter for the operation : ");
		gotoxy(1, 31);
		String a = System.console().readLine();
		switch (a) {
		case "s":
			byte[] aBytes = Supplier.supplierToByteArrayBlock(book); 
			{
			try 
			{
				FileUtility.appendBlock(aBytes, "supplier.dat");
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
			break;

		case "c":
			clear();
			System.out.println("it didnt save");
			System.out.println("Write Something And Press Enter To Exit");
			Scanner a1 = new Scanner(System.in);
			a1.next().charAt(0);
			supplier();
			break;
		}

	}

	public void addCustomer() 
	{

		clear();
		main_box();
		gotoxy(30, 8);
		System.out.println("CUSTOMER ENTRY ");
		gotoxy(8, 13);
		System.out.println("CUSTOMER ID : ");
		gotoxy(39, 13);
		System.out.println("CUSTOMER NAME : ");
		gotoxy(8, 18);
		System.out.println("CITY        : ");
		gotoxy(39, 18);
		System.out.println("CONTACT NO.   : ");
		gotoxy(8, 23);
		System.out.println("EMAIL ID    : ");

		gotoxy(22, 13);
		int id = Integer.parseInt(System.console().readLine());
		gotoxy(55, 13);
		String title = System.console().readLine();
		gotoxy(22, 18);
		String city = System.console().readLine();
		gotoxy(55, 18);
		String num = System.console().readLine();
		gotoxy(22, 23);
		String email = System.console().readLine();

		Customer book = new Customer();
		book.setId(id);
		book.setName(title);
		book.setCity(city);
		book.setNum(num);
		book.setEmail(email);

		clear();
		gotoxy(20, 30);
		System.out.println("Save");
		gotoxy(28, 30);
		System.out.println("Cancel");
		gotoxy(18, 36);
		System.out.println("Press First charecter for the operation : ");
		gotoxy(1, 31);
		String a = System.console().readLine();
		switch (a) {
		case "s":

			byte[] aBytes = Customer.customerToByteArrayBlock(book); {
			try {
				FileUtility.appendBlock(aBytes, "customer.dat");
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
			break;
		case "c":
			clear();
			System.out.println("it didnt save");
			System.out.println("Write Something And Press Enter To Exit");
			Scanner a1 = new Scanner(System.in);
			a1.next().charAt(0);
			supplier();
			break;
		}

	}

	public void editSupplier() {
		clear();
		
		int booknumber;

		System.out.println("Please enter the supplier that do you want to edit: ");
		booknumber = Integer.parseInt(System.console().readLine());
		Supplier supp = new Supplier();

		main_box();
		gotoxy(30, 8);
		System.out.println("SUPPLIER ENTRY ");
		gotoxy(8, 13);
		System.out.println("SUPPLIER ID : ");
		gotoxy(39, 13);
		System.out.println("SUPPLIER NAME : ");
		gotoxy(8, 18);
		System.out.println("CITY        : ");
		gotoxy(39, 18);
		System.out.println("CONTACT NO.   : ");
		gotoxy(8, 23);
		System.out.println("EMAIL ID    : ");

		gotoxy(22, 13);
		int id = Integer.parseInt(System.console().readLine());
		gotoxy(55, 13);
		String title = System.console().readLine();
		gotoxy(22, 18);
		String city = System.console().readLine();
		gotoxy(55, 18);
		String contactno = System.console().readLine();
		gotoxy(22, 23);
		String email = System.console().readLine();

		supp.setsupplierId(id);
		supp.setsuppliername(title);
		supp.setCity(city);
		supp.setContactNo(contactno);
		supp.setemailID(email);

		try {
			byte[] bookBytes = Supplier.supplierToByteArrayBlock(supp);
			FileUtility.updateBlock(bookBytes, booknumber, Supplier.SUPPLIER_DATA_BLOCK_SIZE, "supplier.dat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void editCustomer() 
	{

		int booknumber;
		clear();
		System.out.println("Please enter number of the book which do you want to edit: ");
		booknumber = Integer.parseInt(System.console().readLine());
		Customer cust = new Customer();

		main_box();
		
		gotoxy(30, 8);
		System.out.println("CUSTOMER ENTRY ");
		gotoxy(8, 13);
		System.out.println("CUSTOMER ID : ");
		gotoxy(39, 13);
		System.out.println("CUSTOMER NAME : ");
		gotoxy(8, 18);
		System.out.println("CITY        : ");
		gotoxy(39, 18);
		System.out.println("CONTACT NO.   : ");
		gotoxy(8, 23);
		System.out.println("EMAIL ID    : ");

		gotoxy(22, 13);
		int id = Integer.parseInt(System.console().readLine());
		gotoxy(55, 13);
		String title = System.console().readLine();
		gotoxy(22, 18);
		String city = System.console().readLine();
		gotoxy(55, 18);
		String num = System.console().readLine();
		gotoxy(22, 23);
		String email = System.console().readLine();

		cust.setId(id);
		cust.setName(title);
		cust.setCity(city);
		cust.setNum(num);
		cust.setEmail(email);

		byte[] bookBytes = Customer.customerToByteArrayBlock(cust);
		try {
			FileUtility.updateBlock(bookBytes, booknumber, Customer.CUSTOMER_DATA_BLOCK_SIZE, "customer.dat");
			customer();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void purchasemedicine() 
	{
		clear();
		main_box();

		gotoxy(7, 11);
		System.out.println("MEDICINE ID    : ");
		gotoxy(40, 11);
		System.out.println("MEDICINE NAME  : ");
		gotoxy(7, 14);
		System.out.println("ENTER RACK NO  : ");
		gotoxy(40, 14);
		System.out.println("CABNIT NO      : ");
		gotoxy(7, 18);
		System.out.println("COMPANY NAME   : ");
		gotoxy(40, 18);
		System.out.println("SUPPLIER NAME  : ");
		gotoxy(7, 21);
		System.out.println("UNIT COST   Rs.:  ");
		gotoxy(40, 21);
		System.out.println("SALE COST   Rs.: ");
		gotoxy(7, 24);
		System.out.println("QUANTITY       :  ");
		gotoxy(7, 27);
		System.out.println("MFG.DATE(dd-mm-yyyy): ");
		gotoxy(7, 29);
		System.out.println("EXP.DATE(dd-mm-yyyy): ");

		gotoxy(26, 11);
		int id = Integer.parseInt(System.console().readLine());
		gotoxy(60, 11);
		String name = System.console().readLine();
		gotoxy(26, 14);
		String rackno = System.console().readLine();
		gotoxy(60, 14);
		String cabnitno = System.console().readLine();
		gotoxy(26, 18);
		String companyname = System.console().readLine();
		gotoxy(60, 18);
		String suppliername = System.console().readLine();
		gotoxy(26, 21);
		String unitcost = System.console().readLine();
		gotoxy(60, 21);
		String salecost = System.console().readLine();
		gotoxy(26, 24);
		String quantity = System.console().readLine();
		gotoxy(30, 27);
		int mfgdate = Integer.parseInt(System.console().readLine());
		gotoxy(30, 29);
		String expdate = System.console().readLine();

		Medicine y = new Medicine();

		y.setId(id);
		y.setMedicinename(name);
		y.setRackno(rackno);
		y.setCabnitno(cabnitno);
		y.setCompanyname(companyname);
		y.setSuppliername(suppliername);
		y.setUnitcost(unitcost);
		y.setSalecost(salecost);
		y.setQuantity(quantity);
		y.setMfgdate(mfgdate);
		y.setExpdate(expdate);

		int quantityint = Integer.parseInt(y.getQuantity());
		int salecostint = Integer.parseInt(y.getSalecost());
		int unitcostint = Integer.parseInt(y.getUnitcost());

		int totalSaleCost = quantityint * salecostint;
		int totalUnitCost = quantityint * unitcostint;
		gotoxy(7, 31);
		System.out.println("Total Sale Cost : " + totalSaleCost);
		gotoxy(40, 31);
		System.out.println("Total Unit Cost : " + totalUnitCost);

		gotoxy(20, 33);
		System.out.println("Save");
		gotoxy(28, 33);
		System.out.println("Cancel");
		gotoxy(18, 36);
		System.out.println("Press First charecter for the operation : ");
		gotoxy(1, 31);
		String a = System.console().readLine();
		switch (a) {
		case "s":

			byte[] aBytes = Medicine.bookToByteArrayBlock(y); {
			try {
				FileUtility.appendBlock(aBytes, "medicine.dat");
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
			break;
		case "c":
			clear();
			System.out.println("it didnt save");
			System.out.println("Write Something And Press Enter To Exit");
			Scanner a1 = new Scanner(System.in);
			Character kl = a1.next().charAt(0);
			supplier();
			break;
		}
		
	}

	public void searchsupp() throws IOException 
	{
		new Supplier();
		int p = 1;
		String fileName = "supplier.dat";
		FileReader fileReader = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fileReader);
		String datlength = br.readLine();
		br.close();
		int b = datlength.length();
		clear();
		int i = 14;

		System.out.println("Id Search for Supplier");
		System.out.println("Name Search for Supplier");
		String a = System.console().readLine();
		switch (a) {
		case "i":
			gotoxy(13, 8);
			System.out.println("Enter id to be searched:");
			int sid = Integer.parseInt(System.console().readLine());
			gotoxy(20, 35);
			System.out.println("Press Any key to Return Back Menu ....");
			clear();
			do {

				String path = System.getProperty("user.dir");
				new File(path + File.separator + fileName);
				byte[] writtenBytes = FileUtility.readBlock(p, Supplier.SUPPLIER_DATA_BLOCK_SIZE, fileName);
				Supplier writtenObject = Supplier.byteArrayBlockToSupplier(writtenBytes);

				if (writtenObject != null && sid == writtenObject.getsupplierId()) {

					gotoxy(4, 12);
					System.out.print("ID");
					gotoxy(9, 12);
					System.out.println("Name");
					gotoxy(29, 12);
					System.out.println("City");
					gotoxy(41, 12);
					System.out.println("Contact No");
					gotoxy(54, 12);
					System.out.println("Email Id");

					gotoxy(4, i);
					System.out.println(writtenObject.getsupplierId());
					gotoxy(9, i);
					System.out.println(writtenObject.getsuppliername());
					gotoxy(29, i);
					System.out.println(writtenObject.getCity());
					gotoxy(41, i);
					System.out.println(writtenObject.getContactNo());
					gotoxy(54, i);
					System.out.println(writtenObject.getemailID());

					i++;
				}

				p++;
			} while (p < (((b) / (Supplier.SUPPLIER_DATA_BLOCK_SIZE)) + 1));
			main_box();
			Scanner a1 = new Scanner(System.in);
			a1.next().charAt(0);
			break;

		case "n":

			gotoxy(13, 8);
			System.out.println("Enter name to be searched:");
			String sname = System.console().readLine();
			gotoxy(20, 35);
			System.out.println("Press Any key to Return Back Menu ....");
			do {

				String path = System.getProperty("user.dir");
				new File(path + File.separator + fileName);
				byte[] writtenBytes = FileUtility.readBlock(p, Supplier.SUPPLIER_DATA_BLOCK_SIZE, fileName);
				Supplier writtenObject = Supplier.byteArrayBlockToSupplier(writtenBytes);

				int index = writtenObject.getsuppliername().indexOf(sname);

				if (writtenObject != null && index != -1) {

					gotoxy(4, 12);
					System.out.print("ID");
					gotoxy(9, 12);
					System.out.println("Name");
					gotoxy(29, 12);
					System.out.println("City");
					gotoxy(41, 12);
					System.out.println("Contact No");
					gotoxy(54, 12);
					System.out.println("Email Id");

					gotoxy(4, i);
					System.out.println(writtenObject.getsupplierId());
					gotoxy(9, i);
					System.out.println(writtenObject.getsuppliername());
					gotoxy(29, i);
					System.out.println(writtenObject.getCity());
					gotoxy(41, i);
					System.out.println(writtenObject.getContactNo());
					gotoxy(54, i);
					System.out.println(writtenObject.getemailID());

					i++;
				} else {
					gotoxy(4, 12);
					System.out.print("Searched supplier couldn't found.");
				}
				p++;
			} while (p < (((b) / (Supplier.SUPPLIER_DATA_BLOCK_SIZE)) + 1));
			main_box();
			Scanner scanner = new Scanner(System.in);
			  gotoxy(8,42);
			  System.out.print("Press Enter to go to MAIN MENU !!!"); 
			  scanner.nextLine();
			  customer(); 

			break;
		}

	}

	public void searchcust() throws IOException {
		int p = 1;
		String fileName = "customer.dat";
		FileReader fileReader = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fileReader);
		String datlength = br.readLine();
		br.close();
		int b = datlength.length();
		clear();
		int i = 14;

		System.out.println("Id Search for Customer");
		System.out.println("Name Search for Customer");
		String a = System.console().readLine();
		switch (a) {
		case "i":
			gotoxy(13, 8);
			System.out.println("Enter id to be searched:");
			int sid = Integer.parseInt(System.console().readLine());
			gotoxy(20, 35);
			System.out.println("Press Any key to Return Back Menu ....");
			clear();
			do {

				String path = System.getProperty("user.dir");
				new File(path + File.separator + fileName);
				byte[] writtenBytes = FileUtility.readBlock(p, Customer.CUSTOMER_DATA_BLOCK_SIZE, fileName);
				Customer writtenObject = Customer.ByteArrayBlockToCustomer(writtenBytes);

				if (writtenObject != null && sid == writtenObject.getId()) {

					gotoxy(4, 12);
					System.out.print("ID");
					gotoxy(9, 12);
					System.out.println("Name");
					gotoxy(29, 12);
					System.out.println("City");
					gotoxy(41, 12);
					System.out.println("Contact No");
					gotoxy(54, 12);
					System.out.println("Email Id");

					gotoxy(4, i);
					System.out.println(writtenObject.getId());
					gotoxy(9, i);
					System.out.println(writtenObject.getName());
					gotoxy(29, i);
					System.out.println(writtenObject.getCity());
					gotoxy(41, i);
					System.out.println(writtenObject.getNum());
					gotoxy(54, i);
					System.out.println(writtenObject.getEmail());

					i++;
				}

				p++;
			} while (p < (((b) / (Customer.CUSTOMER_DATA_BLOCK_SIZE)) + 1));
			main_box();
			Scanner scanner = new Scanner(System.in);
			  gotoxy(8,42);
			  System.out.print("Press Anykey to go to SUPPLIER MENU !!!"); 
			  scanner.nextLine();
			  supplier();
			break;

		case "n":

			gotoxy(13, 8);
			System.out.println("Enter name to be searched:");
			String sname = System.console().readLine();
			gotoxy(20, 35);
			System.out.println("Press Any key to Return Back Menu ....");
			do {

				String path = System.getProperty("user.dir");
				new File(path + File.separator + fileName);
				byte[] writtenBytes = FileUtility.readBlock(p, Customer.CUSTOMER_DATA_BLOCK_SIZE, fileName);
				Customer writtenObject = Customer.ByteArrayBlockToCustomer(writtenBytes);

				int index = writtenObject.getName().indexOf(sname);

				if (writtenObject != null && index > 0) {

					gotoxy(4, 12);
					System.out.print("ID");
					gotoxy(9, 12);
					System.out.println("Name");
					gotoxy(29, 12);
					System.out.println("City");
					gotoxy(41, 12);
					System.out.println("Contact No");
					gotoxy(54, 12);
					System.out.println("Email Id");

					gotoxy(4, i);
					System.out.println(writtenObject.getId());
					gotoxy(9, i);
					System.out.println(writtenObject.getName());
					gotoxy(29, i);
					System.out.println(writtenObject.getCity());
					gotoxy(41, i);
					System.out.println(writtenObject.getNum());
					gotoxy(54, i);
					System.out.println(writtenObject.getEmail());

					i++;
				} else {
					gotoxy(4, 12);
					System.out.print("Searched supplier couldn't found.");
				}
				p++;
			} while (p < (((b) / (Customer.CUSTOMER_DATA_BLOCK_SIZE)) + 1));
			main_box();
			Scanner a11 = new Scanner(System.in);
			a11.next().charAt(0);

			break;
		}

	}

	public void salemedicine() throws IOException 
	{
	clear();
	int p2 = 1;
	String file2Name = "medicine.dat";
	byte[] bookWrittenBytes2 = FileUtility.readBlock(p2, Medicine.BOOK_DATA_BLOCK_SIZE, file2Name);
	Medicine bookWrittenObject2 = Medicine.byteArrayBlockToBook(bookWrittenBytes2);
	
	String medname = bookWrittenObject2.getMedicinename();
	String medcab = bookWrittenObject2.getCabnitno();
	String medcomp = bookWrittenObject2.getCompanyname();
	String medexp = bookWrittenObject2.getExpdate();
	int medmfg = bookWrittenObject2.getMfgdate();
	String medrack = bookWrittenObject2.getRackno();	
	String medsale = bookWrittenObject2.getSalecost();
	String medsupp = bookWrittenObject2.getSuppliername();
	String medunit = bookWrittenObject2.getUnitcost();
	int medid = bookWrittenObject2.getId();


	int p = 1;
	String fileName = "medicine.dat";
	Bill bill = new Bill();
	
	FileReader fileReader = new FileReader(fileName);
	BufferedReader br2 = new BufferedReader(fileReader);
	String datlength = br2.readLine();
	
	int b = datlength.length();
	int i = 14;
    medicinebox();
	gotoxy(7, 11);
	System.out.println("Enter Medicine Id To Be Sold : ");
	gotoxy(40, 11);
	int sid = Integer.parseInt(System.console().readLine());
	clear();
	
	byte[] bookWrittenBytes = FileUtility.readBlock(p, Medicine.BOOK_DATA_BLOCK_SIZE, fileName);
	Medicine bookWrittenObject = Medicine.byteArrayBlockToBook(bookWrittenBytes);
	
	do {
		if (bookWrittenObject != null && sid == bookWrittenObject.getId()) {
			gotoxy(7, i);
			System.out.println("Medicine Name     : " + bookWrittenObject.getMedicinename());
			gotoxy(7, i + 1);
			System.out.println("Quantity In Stock : " + bookWrittenObject.getQuantity());
			gotoxy(7, i + 2);
			System.out.println("Sales Price       : " + bookWrittenObject.getSalecost());
			

			i++;
		}
		p++;
	} while (p < (((b) / (Medicine.BOOK_DATA_BLOCK_SIZE)) + 1));
	medicinebox();
    int newquantity = Integer.parseInt(bookWrittenObject.getQuantity());
	String medicinename = bookWrittenObject.getMedicinename();
	int rate =  Integer.parseInt(bookWrittenObject.getSalecost());
	gotoxy(7, 18);
	System.out.println("Enter Bill Number     : ");
	gotoxy(31, 18);
	String billnumber = System.console().readLine();
	gotoxy(7, 21);
	System.out.println("Enter Customer Name   : ");
	gotoxy(31, 21);
	String custname = System.console().readLine();
	gotoxy(7, 24);
	System.out.println("Quantity Want To Sale : ");
	gotoxy(31, 24);
	String quantity = System.console().readLine();
	
	int newquantity1 = Integer.parseInt(quantity);
	int	lastquantity = newquantity - newquantity1 ;
	String lastquantity1 = String.valueOf(lastquantity);
	
	clear();
	main_box();
	gotoxy(7,18);
	System.out.println("Price Paid By Customer : " + custname);
	gotoxy(7,21);
	System.out.println("Quantity Sold          : " + quantity);
	
	Scanner a11 = new Scanner(System.in);
	Character kl1 = a11.next().charAt(0);
	
	bookWrittenObject.setCabnitno(medcab);
	bookWrittenObject.setCompanyname(medcomp);
	bookWrittenObject.setExpdate(medexp);
	bookWrittenObject.setId(medid);
	bookWrittenObject.setMedicinename(medname);
	bookWrittenObject.setMfgdate(medmfg);
	bookWrittenObject.setRackno(medrack);
	bookWrittenObject.setSalecost(medsale);
	bookWrittenObject.setSuppliername(medsupp);
	bookWrittenObject.setUnitcost(medunit);
 	bookWrittenObject.setQuantity(lastquantity1);
 	
 	byte[] aBytes = Medicine.bookToByteArrayBlock(bookWrittenObject); {
		FileUtility.updateBlock(aBytes,sid,Medicine.BOOK_DATA_BLOCK_SIZE, "medicine.dat");
	}
 	
	bill.setBillno(billnumber);
	bill.setcustomername(custname);
	bill.setmedicinename(medicinename);
	bill.setquantity(quantity);
	bill.setrate(rate);
	
	byte[] aBytes1 = Bill.bookToByteArrayBlock(bill); {
		try {
			FileUtility.appendBlock(aBytes1, "bill.dat");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	clear();
	gotoxy(20, 20);
	System.out.println("Succesfully Updated");
	main_box();
	Scanner a111 = new Scanner(System.in);
	Character kl11 = a111.next().charAt(0);
	
	br2.close();
	medicine();
	}

	public static void medicinebox() {

		  int i;
	        gotoxy(1,6);
	        System.out.print("\u2554");
	       for(i=1;i<79;i++)
	        {
	            gotoxy(1+i,6);
	            System.out.print("\u2550");
	        }

	        gotoxy(80,6);
	        System.out.print("\u2557");
	        gotoxy(1,6);
	        for(i=5;i<35;i++)
	        {
	            gotoxy(48,2+i);
	            System.out.print("\u2551");
	        }
	        gotoxy(1,37);
	        System.out.print("\u255A");
	        for(i=1;i<79;i++)
	        {
	            gotoxy(1+i,37);
	            System.out.print("\u2550");
	        }
	        gotoxy(80,37);
	        System.out.print("\u255D");
	        gotoxy(80,6);
	        for(i=5;i<35;i++)
	        {
	            gotoxy(80,2+i);
	            System.out.print("\u2551");
	            
	        }
	        gotoxy(60,6);
	        for(i=5;i<35;i++)
	        {
	            gotoxy(1,2+i);
	            System.out.print("\u2551");
	        }
	    }


	public void billthings() throws IOException
	{
		clear();
		int p2 = 1;
		// read the first block of data from the "medicine.dat" file
		String file2Name = "medicine.dat";
		byte[] bookWrittenBytes2 = FileUtility.readBlock(p2, Medicine.BOOK_DATA_BLOCK_SIZE, file2Name);
		// convert the data block to a Medicine object
		Medicine bookWrittenObject2 = Medicine.byteArrayBlockToBook(bookWrittenBytes2);

		// store the quantity and sale cost of the medicine
		String medquan = bookWrittenObject2.getQuantity();
		String medsale = bookWrittenObject2.getSalecost();
		// convert the quantity and sale cost to integer values
		int medquannew = Integer.parseInt(medquan);
		int medsalenew = Integer.parseInt(medsale);

		int pp = 1;
		String ffileName = "bill.dat";
		// read the first line of the "bill.dat" file
		FileReader ffileReader = new FileReader(ffileName);
		BufferedReader br = new BufferedReader(ffileReader);
		String dattlength = br.readLine();
		br.close();
		// store the length of the first line
		int bb = dattlength.length();
		clear();
		int ii = 17;

		// prompt the user to enter a bill number to search for
		gotoxy(13, 8);
		System.out.println("Enter bill no to be searched:");
		gotoxy(42, 8);
		// read the user's input as an integer
		int sid = Integer.parseInt(System.console().readLine());
		// clear the screen and display the main box
		main_box();
		clear();

		// display the header for the bill information
		gotoxy(9, 14);
		System.out.println("Sr.No  ID.   MEDICINE NAME.    QTY     Rate     Total");
		gotoxy(9, 15);
		System.out.println("=====================================================\n");

		do {
			// read a block of data from the "bill.dat" file
			byte[] bookWrittenBytes = FileUtility.readBlock(pp, Bill.Bill_DATA_BLOCK_SIZE, ffileName);
			// Convert the block of data to a bill object
			Bill bookWrittenObject = Bill.byteArrayBlockToBook(bookWrittenBytes);
			// Convert the bill number to an integer
			int billnobro = Integer.parseInt(bookWrittenObject.getBillno());
			gotoxy(9, 7);
			System.out.println("Bill No: ");
			gotoxy(18, 7);
			System.out.println(bookWrittenObject.getBillno());
			gotoxy(9, 9);
			System.out.println("Customer Name: ");
			gotoxy(24, 9);
			System.out.println(bookWrittenObject.getcustomername());

			if (bookWrittenObject != null && sid == billnobro) {

				gotoxy(9, ii);
				System.out.println(pp);
				gotoxy(16, ii);
				System.out.println(bookWrittenObject.getid());
				gotoxy(22, ii);
				System.out.println(bookWrittenObject.getmedicinename());
				gotoxy(40, ii);
				System.out.println(bookWrittenObject.getquantity());
				gotoxy(48, ii);
				System.out.println(bookWrittenObject.getrate());
				int total = medsalenew * medquannew;
				gotoxy(57, ii);
				System.out.println(total);
				ii++;
			}

			pp++;
		} while (pp < (((bb) / (Bill.Bill_DATA_BLOCK_SIZE)) + 1));
		main_box();

		Scanner b1 = new Scanner(System.in);
		Character cl = b1.next().charAt(0);
	}

}

