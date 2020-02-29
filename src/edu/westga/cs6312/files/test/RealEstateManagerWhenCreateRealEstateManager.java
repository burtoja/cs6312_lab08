package edu.westga.cs6312.files.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.RealEstateManager;

/**
 * Test class for the RealEstateManager constructor and toString method
 * 
 * @author J. Allen Burton
 * @version Feb 28, 2020
 *
 */
public class RealEstateManagerWhenCreateRealEstateManager {

	/**
	 * Test the zero parameter constructor and toString output when no RealEstate
	 * objects have been added to the object. EXPECT: "Current Real Estate
	 * Listings:\n\tThere are no current listings"
	 */
	@Test
	public void testCreateNewRealEstateManager() {
		RealEstateManager theRealEstateManager = new RealEstateManager();
		String report = theRealEstateManager.toString();
		assertEquals("Current Real Estate Listings:\n\tThere are no current listings", report);
	}

}
