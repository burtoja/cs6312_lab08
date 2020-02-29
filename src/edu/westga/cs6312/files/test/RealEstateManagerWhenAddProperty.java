package edu.westga.cs6312.files.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.RealEstate;
import edu.westga.cs6312.files.model.RealEstateManager;

/**
 * Test class for the addProperty method in the RealEstateManager class
 * 
 * @author J. Allen Burton
 * @version Feb 28, 2020
 *
 */

public class RealEstateManagerWhenAddProperty {

	/**
	 * Test addProperty to new RealEstatManager object. Will create new
	 * RealEstateMAnager object then create new RealEstate object with location =
	 * Ohio, landArea = 500 and structureArea = 200.  EXPECT:
	 * Current Real Estate Listings:\n\tLocation: Ohio\tLand Area: 500 sq.ft.\tStructure Area: 200 sq.ft.
	 */
	@Test
	public void testAddPropertyOhioLand500Structure200() {
		RealEstateManager theRealEstateManager = new RealEstateManager();
		RealEstate theRealEstate = new RealEstate("Ohio", 500, 200);
		theRealEstateManager.addProperty(theRealEstate);
		String report = theRealEstateManager.toString();
		assertEquals("Current Real Estate Listings:\nLocation: Ohio\tLand Area: 500 sq.ft.\tStructure Area: 200 sq.ft.\n", report);
	}

}
