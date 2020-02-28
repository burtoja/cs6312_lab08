package edu.westga.cs6312.files.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.RealEstate;

/**
 * Test the constructor and toString() method of the RealEstate class
 * 
 * @author J. Allen Burton
 * @version Feb 28, 2020
 *
 */
public class RealEstateWhenCreateRealEstate {

	/**
	 * Test of RealEstate constructor. 
	 * EXPECT:
	 * Location: Ohio\tLand Area: 500 sq.ft.\tStructure Area: 200 sq.ft.
	 */
	@Test
	public void testCreateRealEstateLocationOhioLand500Structure200() {
		RealEstate theRealEstate = new RealEstate("Ohio", 500, 200);
		String report = theRealEstate.toString();
		assertEquals("Location: Ohio\tLand Area: 500 sq.ft.\tStructure Area: 200 sq.ft.", report);
	}

}
