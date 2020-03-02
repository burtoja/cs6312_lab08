package edu.westga.cs6312.files.view;

import java.util.NoSuchElementException;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
	 * Constructor for RealEstateTUI objects
	 * 
	 * @param userRealEstateManager the RealEstateManager object o be used in the
	 *                              TUI
	 *
	 * @precondition userRealEstateManager != null
	 *
	 * @postcondition new RealEstateManager object created with the
	 *                RealEstateMAnager object provided in the parameter and a
	 *                Scanner object instantiated
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
					this.addPropertiesFromFile(this.getStringFromUser("Please enter input file name: "));
					break;
				case 2:
					this.displaySortedProperties();
					break;
				case 3:
					this.saveSortedProperties(this.getStringFromUser("Please enter output file name: "));
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
	 * Prompts user for a to enter a String based upon the message delivered in the
	 * parameter. This method will continue to prompt the user for the String until
	 * a String with at least 1 character is entered.
	 * 
	 * @return String entered by user
	 *
	 * @precondition none
	 * 
	 * @postcondition no change to object
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

	/**
	 * This method will add the real estate properties from a file supplied through
	 * the parameter. File must be formatted with each entry on a separate line as
	 * follows: property_name, land_area, structure_area i.e. "Shotgun Shack, 2, 1".
	 * Each line will be read and a RealEstate object will be created from its data
	 * if possible. This object will then be added to the list and a string
	 * representation of that property will be displayed to the console. If the
	 * formatting of the line of data in the file does not allow it to be parsed
	 * correctly, then a report of the problem is generated for that line before
	 * continuing to the next.
	 * 
	 * @param fileName the name of the file to be read into the object.
	 * 
	 * @precondition fileName must reference a valid file
	 *
	 * @postcondition new RealEstate objects are created for each successful entry
	 *                and added to the userRealEstateManager list
	 * 
	 */
	private void addPropertiesFromFile(String fileName) {
		File userFile = new File(fileName);
		Scanner inFile = null;
		try {
			inFile = new Scanner(userFile);
			System.out.println("Properties read: ");
			while (inFile.hasNext()) {
				String input = inFile.nextLine();
				RealEstate currentProperty = this.createRealEstateObjectFromFileLine(input);
				if (currentProperty != null) {
					this.userRealEstateManager.addProperty(currentProperty);
					System.out.println(currentProperty.toString());
				} else {
					System.out.println("\tInvalid property data read: " + input);
				}
			}
			inFile.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("Data file does not exist");
		} catch (NoSuchElementException nsee) {
			System.out.println("Read past the end of the file");
			inFile.close();
		}
	}

	/**
	 * Private helper method to create a new RealEstate object from a line of text
	 * where the location name, land area, and structure area are separated by a
	 * comma and a space. The areas will only be considered if they are integers. If
	 * all three pieces of data are unable to be parsed from the line, then a null
	 * RealEstate object is returned.
	 * 
	 * @param fileLine a properly formated comma separated String with location
	 *                 (String), land area (int), and structure area (int)
	 * 
	 * @return a new RealEstate object (null if unable to parse data from supplied
	 *         string)
	 *
	 * @precondition provided string must match format guidelines: "location_name,
	 *               land_area, structure_area" (space following each comma)
	 *
	 * @postcondition new RealEstate object created with values from provided string
	 *                (or null if unsuccessful parsing of string)
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
	 * This private method will display the properties stored in the
	 * RealEstateManager object in order of increasing land area with duplicate land
	 * areas being sorted first by structure area and then sorted alphabetically by
	 * location name for duplicates.
	 * 
	 * @precondition none
	 *
	 * @postcondition the data in the userRealEstateManager list of properties now
	 *                sorted
	 */
	private void displaySortedProperties() {
		this.userRealEstateManager.sortProperties();
		System.out.println(this.userRealEstateManager.toString());
	}

	/**
	 * This method will create (or overwrite) a file with name matching provided
	 * parameter and then write the current list (after being sorted) to the file
	 * and save the file.
	 * 
	 * @param fileName the name of the file to be created (or overwritten)
	 *
	 * @precondition fileName must be at least one character long
	 *
	 * @postcondition the data in the userRealEstateManager list of properties now
	 *                sorted and is stored in a newly created (or overwritten) file
	 */
	private void saveSortedProperties(String fileName) {
		this.userRealEstateManager.sortProperties();
		File userFile = new File(fileName);
		try {
			PrintWriter outFile = new PrintWriter(userFile);
			for (RealEstate currentProperty : this.userRealEstateManager.getProperties()) {
				outFile.write(currentProperty.getLocation() + ", " + currentProperty.getLandArea() + ", "
						+ currentProperty.getStructureArea() + System.getProperty("line.separator"));
			}
			outFile.close();
			System.out.println("Property information successfully saved to file " + fileName);
		} catch (FileNotFoundException fnfe) {
			System.out.println("There was a problem creating the file");
		}
	}

}
