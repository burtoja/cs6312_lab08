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
public class RealEstateWhenGetStructureArea {

	/**
	 * Test getLAndArea(). Create RealEstate object with structure area set to 200.
	 * EXPECT: 200
	 */
	@Test
	public void testGetStructureAreaExpect200() {
		RealEstate theRealEstate = new RealEstate("Virginia", 500, 200);
		int report = theRealEstate.getStructureArea();
		assertEquals(200, report);
	}

}
