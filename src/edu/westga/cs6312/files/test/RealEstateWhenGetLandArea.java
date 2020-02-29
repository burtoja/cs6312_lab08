package edu.westga.cs6312.files.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.RealEstate;

/**
 * Test the getLandArea method of the RealEstate class
 * 
 * @author J. Allen Burton
 * @version Feb 29, 2020
 *
 */
public class RealEstateWhenGetLandArea {

	/**
	 * Test getLandArea(). Create RealEstate object with land area set to 500.
	 * EXPECT: 500
	 */
	@Test
	public void testGetLandAreaExpect500() {
		RealEstate theRealEstate = new RealEstate("Virginia", 500, 200);
		int report = theRealEstate.getLandArea();
		assertEquals(500, report);
	}

}
