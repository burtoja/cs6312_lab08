package edu.westga.cs6312.files.controller;

import edu.westga.cs6312.files.model.RealEstateManager;
import edu.westga.cs6312.files.view.RealEstateTUI;

/**
 * This class will serve as the driver for the real estate property management
 * management application
 * 
 * @author J. Allen Burton
 * @version Feb 28, 2020
 *
 */
public class RealEstateDriver {

	/**
	* This method is the entry point of the application
	*
	* @param args Command-line arguments, not used
	*/
	public static void main(String[] args) {
		RealEstateManager userRealEstateManager = new RealEstateManager();
		RealEstateTUI userRealEstateTUI = new RealEstateTUI(userRealEstateManager);
		userRealEstateTUI.run();
	}
}
