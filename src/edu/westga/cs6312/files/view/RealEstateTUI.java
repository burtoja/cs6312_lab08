package edu.westga.cs6312.files.view;

import java.util.NoSuchElementException;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

import edu.westga.cs6312.files.model.RealEstate;
import edu.westga.cs6312.files.model.RealEstateManager;

/**
 * This class will serve as the user interface for the real estate property
 * management application
 * 
 * @author J. Allen Burton
 * @version Feb 28, 2020
 *
 */
public class RealEstateTUI {
	private RealEstateManager userRealEstateManager;
	private Scanner userInput;

	/**
	 * Constructor for RealEstateManager objects
	 * 
	 * @param userRealEstateManager the RealEstateManager object o be used in the
	 *                              TUI
	 *
	 * @precondition userRealEstateManager != null
	 *
	 * @postcondition new RealEstateManager object created with the
	 *                RealEstateMAnager object provided in the parameter
	 */
	public RealEstateTUI(RealEstateManager userRealEstateManager) {
		this.userRealEstateManager = userRealEstateManager;
		this.userInput = new Scanner(System.in);
	}

	/**
	 * This method serves as the director of the user interface
	 *
	 * @precondition none
	 *
	 * @postcondition changes to the object dictated by private methods within this
	 *                method
	 */
	public void run() {
		System.out.println("Welcome to the Real Estate Manager Application.");
		int userChoice;
		do {
			this.displayMenu();
			userChoice = this.getIntegerFromUser("Please enter your choice from the menu: ");
			switch (userChoice) {
				case 1:
					this.addPropertiesFromFile();
					break;
				case 2:

					break;
				case 3:

					break;
				case 4:
					break;
				default:
					System.out.println("Invalid menu choice. Please choose from the following options:");
			}
		} while (userChoice != 4);
		System.out.println("Thank you for using the Real Estate Manager Application.");
	}

	/**
	 * This method will display the menu of choices for the user
	 *
	 * @precondition none
	 *
	 * @postcondition displayed menu to console
	 */
	private void displayMenu() {
		System.out.println("\n\t---------------------------------------------");
		System.out.println("\t| 1 - Add properties from file              |");
		System.out.println("\t| 2 - Display sorted properties on console  |");
		System.out.println("\t| 3 - Save sorted properties to file        |");
		System.out.println("\t| 4 - Quit                                  |");
		System.out.println("\t---------------------------------------------");
	}

	/**
	 * This method displays the message provided in the parameter, reads the user
	 * input, and returns the integer provided by the user.
	 * 
	 * @return integer value provided by the user
	 *
	 * @precondition none
	 *
	 * @postcondition integer returned corresponding to user input
	 */
	private int getIntegerFromUser(String message) {
		String input = "";
		int userInteger = 0;
		boolean isValid = false;
		do {
			try {
				System.out.println(message);
				input = this.userInput.nextLine();
				userInteger = Integer.parseInt(input);
				isValid = true;
			} catch (NumberFormatException nfe) {
				System.out.println("Your entry (" + input + ") was not a valid integer.  Please try again.");
			}
		} while (!isValid);
		return userInteger;
	}

	/**
	 * This method will add the real estate properties from a file supplied by the
	 * user. File must be formatted with each entry on a separate line as follows:
	 * property_name, land_area, structure_area i.e. "Shotgun Shack, 2, 1"
	 * 
	 * @precondition
	 *
	 * @postcondition
	 */
	private void addPropertiesFromFile() {
		String fileName = getStringFromUser("Please enter file name: ");
		File userFile = new File(fileName);
		Scanner inFile = null;
		try {
			inFile = new Scanner(userFile);
			while (inFile.hasNext()) {
				String input = inFile.nextLine();
				RealEstate currentProperty = this.createRealEstateObjectFromFileLine(input);
				if (currentProperty != null) {
					this.userRealEstateManager.addProperty(currentProperty);
				}
			}
			inFile.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("Data file does not exist");
		} catch (NoSuchElementException nsee) {
			System.out.println("Read past the end of the file");
		}

		System.out.println("Properties read: ");
		System.out.println(this.userRealEstateManager.toString());

	}

	/**
	 * PRivate helper method to create a new RealEstate object from a line of text
	 * where the location name, land area, and structure area are separated by a
	 * comma and a space. The areas will only be considered if they are integers. If
	 * all three pieces of data are unable to be parsed from the line, then a null
	 * RealEstate object is returned.
	 * 
	 * @param fileLine a properly formated comma separated String with location
	 *                 (String), land area (int), and structure area (int)
	 * @return a new RealEstate object (null if unable to parse data from supplied
	 *         string)
	 *
	 * @precondition provided string must match format guidelines: comma separated
	 *               with space following the comma, string location and integer
	 *               areas
	 *
	 * @postcondition new RealEstate object created
	 */
	private RealEstate createRealEstateObjectFromFileLine(String fileLine) {
		RealEstate theProperty;
		try {
			String currentLocation = fileLine.split(", ")[0];
			int currentLandArea = Integer.parseInt(fileLine.split(", ")[1]);
			int currentStructureArea = Integer.parseInt(fileLine.split(", ")[2]);
			theProperty = new RealEstate(currentLocation, currentLandArea, currentStructureArea);
		} catch (ArrayIndexOutOfBoundsException aioob) {
			theProperty = null;
		} catch (NumberFormatException nfe) {
			theProperty = null;
		}
		return theProperty;
	}

	/**
	 * Prompts user for a to enter a String based upon the message delivered in the
	 * parameter. This method will continue to prompt the user for the String until
	 * a String with at least 1 character is entered.
	 * 
	 * @return	String entered by user
	 *
	 * @precondition	none
	 *	
	 * @postcondition	no change to object
	 */
	private String getStringFromUser(String message) {
		boolean isValid = false;
		String fileName;
		do {
			System.out.println(message);
			fileName = this.userInput.nextLine();
			if (fileName.length() > 0) {
				isValid = true;
			} else {
				System.out.println("You did not enter any text.  Please try again.");
			}
		} while (!isValid);
		return fileName;
	}

}
