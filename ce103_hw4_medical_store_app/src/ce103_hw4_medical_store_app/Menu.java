package ce103_hw4_medical_store_app;

import java.util.Scanner;



import java.io.IOException;


public class Menu 
{
    // Initialize scanner and InsiderOfTheMenu object
    InsiderOfTheMenu functions = new InsiderOfTheMenu();
    Scanner kb = new Scanner(System.in);
    // Initialize exit flag as false
    boolean exit = false;
	
    public static void main(String[] args) throws IOException 
    {
        // Create a new Menu object and run it
        Menu menu = new Menu();
        menu.runMenu();
    }

    public void runMenu() throws IOException 
    {
        // Run menu until exit flag is set to true
        while (!exit) 
        {
            // Print menu and get user input
            printMenu();
            int choice = functions.getInput();
            // Perform action based on user input
            performAction(choice);
        }
    }


    public void clearScreen() 
    {
        // Attempt to clear the terminal screen
        try 
        {
            // Use ProcessBuilder to run the command "cls" in the terminal
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } 
        // If there is an exception, print the stack trace
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public void printMenu() 
    {
        // Clear the terminal screen and print the main menu
        clearScreen();
        InsiderOfTheMenu.mainmenu();
    }

    static void gotoxy(int collumn, int row) 
    {
        // Move the terminal cursor to the specified row and column
        System.out.print("\033[" + row + ";" + collumn + "H");
    }

	
	public void performAction(int choice) throws IOException 
	{
		// Prompt the user to enter the first character for further operations
		gotoxy(21,38);
    	System.out.println("Press First Character for further Operations ");
        
    	switch (choice) 
    	{
    	case 0:
    		// Prompt the user to confirm if they want to exit the program
    		System.out.println("Do you want to exit now? Y/N :");
            Scanner exit = new Scanner(System.in);
    	    String choiceExit = (exit.next()) ;
    	    
        switch(choiceExit) {
        case "Y":
        case "y":
        	// Exit the program
        	System.exit(0);
        	break;
        case "N":
        case "n":
        	// Clear the screen and print the main menu
        	clearScreen();
        	printMenu();
        	
        	break;
        }
        break;


		case 1:
			// Clear the screen
			 clearScreen();
			 // Display the options for supplier operations
			 functions.supplier();
	            
				// Read user input
				Scanner de = new Scanner(System.in);
				
				// Parse the user input to integer
				choice = Integer.parseInt(de.nextLine());
				
				// Perform actions based on user input
				switch (choice) {
					case 1:
						// Add a new supplier
						functions.addSupplier();
						break;
					case 2:
						// Edit an existing supplier
						functions.editSupplier();
						break;
					case 3:
						// Search for a supplier
						try {
							functions.searchsupp();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						break;
					case 4:
						// Clear the screen
						clearScreen();
						// List all suppliers
						functions.listsupp();
						break;
					case 5:
						// Go back to main menu
						InsiderOfTheMenu.mainmenu();
						break;
				}
			break;

		case 2:
			// Clear the screen
			clearScreen();
			
			// Show the customer menu options
			functions.customer();
			
			// Scan for user input
			Scanner dae = new Scanner(System.in);
			
			// Prompt the user to enter their choice
			gotoxy(5, 40);
	    	System.out.println("Press First Character for further Operations ");
			choice = Integer.parseInt(dae.nextLine());

			// Perform the action based on the user's choice
			switch (choice) {
			case 1:
				// Add a customer
				functions.addCustomer();
				break;
			case 2:
				// Edit a customer
				functions.editCustomer();
				break;
			case 3:
				// Search for a customer
				try {
					functions.searchcust();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 4:
				// List all customers
				try {
					functions.listcust();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				// Go back to the main menu
				InsiderOfTheMenu.mainmenu();
				break;

			}

			break;
			
			// This switch case handles the operations related to medicines.
			// The user is presented with a list of options related to medicines and asked to choose one.
			// Depending on the choice made by the user, the corresponding function is called.
			// If the user chooses option 5, the control is returned to the main menu.  
		case 3:
			clearScreen();
			functions.medicine();
			
			Scanner ds = new Scanner(System.in);
			gotoxy(5, 40);
	    	System.out.println("Press First Character for further Operations ");
			choice = Integer.parseInt(ds.nextLine());

			switch (choice) {
			case 1:
				functions.purchasemedicine();
				break;
			case 2:
				try {
					functions.salemedicine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				functions.stockmedicine();
				break;
			case 4:
				functions.listmedicine();
				break;
			case 5:
				InsiderOfTheMenu.mainmenu();
				break;

			}

			break;
		case 4:
			// Clear the screen
			clearScreen();
			
			// Display the report menu options
			functions.report();
			
			// Scan user input
			Scanner dsd = new Scanner(System.in);
			gotoxy(5, 40);
	    	System.out.println("Press First Character for further Operations ");
			choice = Integer.parseInt(dsd.nextLine());

			// Perform different actions based on user input
			switch (choice) {
			case 1:
				// TODO: Add code for report action 1
				break;
			case 2:
				// TODO: Add code for report action 2
				break;
			case 3:
				// TODO: Add code for report action 3
				break;
			case 4:
				// TODO: Add code for report action 4
				break;
			case 5:
				// TODO: Add code for report action 5
				break;

			}

			break;
		case 5:
			clearScreen();
			
			Scanner df = new Scanner(System.in);
			System.out.println("Enter The Bill No : ");
			choice = Integer.parseInt(df.nextLine());

			switch (choice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;

			}

			break;
		case 6:
			clearScreen();
			System.out.println("Made by HDCODE team");
			System.out.println("This is a Medical Store Management Application");

			System.out.println("Press any key to exit");
			Scanner a1 = new Scanner(System.in);
			a1.next().charAt(0);

			break;
		default:
			 System.out.println("Plese Enter right character ONLY (0,1,2,3,4,5,6)");
			 clearScreen();
			 InsiderOfTheMenu.mainmenu();
			 break;

		}
	}
}