package edu.westga.cs6312.files.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.RealEstate;

/**
 * Test the getLocation method of the RealEstate class
 * 
 * @author J. Allen Burton
 * @version Feb 29, 2020
 *
 */
public class RealEstateWhenGetLocation {

	/**
	 * Test getLocation(). Create RealEstate object with location set to Virginia.
	 * EXPECT: Virginia
	 */
	@Test
	public void testGetLocationExpectVirginia() {
		RealEstate theRealEstate = new RealEstate("Virginia", 500, 200);
		String report = theRealEstate.getLocation();
		assertEquals("Virginia", report);
	}

}
