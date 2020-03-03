package edu.westga.cs6312.files.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.RealEstate;

/**
 * This class will serve to test the compareTo method in the RealEstate class
 * 
 * @author J. Allen Burton
 * @version Mar 2, 2020
 *
 */
public class RealEstateWhenCompareTo {

	/**
	 * This test will create two identical RealEstate objects and compare them
	 * using the compareTo method.
	 * 
	 * PropertyA: Location: Ohio, Land Area: 200, Structure Area: 200
	 * 
	 * PropertyB: Location: Ohio, Land Area: 200, Structure Area: 200
	 * 
	 * Expect: 0 (equal)
	 */
	@Test
	public void testIdenticalPRopertiesExpect0() {
		RealEstate propertyA = new RealEstate("Ohio", 200, 200);
		RealEstate propertyB = new RealEstate("Ohio", 200, 200);
		int report = propertyA.compareTo(propertyB);
		assertEquals(0, report);
	}
	
	/**
	 * This test will create two RealEstate objects and compare them
	 * using the compareTo method.
	 * 
	 * PropertyA: Location: Ohio, Land Area: 300, Structure Area: 200
	 * 
	 * PropertyB: Location: Ohio, Land Area: 200, Structure Area: 200
	 * 
	 * Expect: 1
	 */
	@Test
	public void testAMoreLandThanBExpect1() {
		RealEstate propertyA = new RealEstate("Ohio", 300, 200);
		RealEstate propertyB = new RealEstate("Ohio", 200, 200);
		int report = propertyA.compareTo(propertyB);
		assertEquals(1, report);
	}
	
	/**
	 * This test will create two RealEstate objects and compare them
	 * using the compareTo method.
	 * 
	 * PropertyA: Location: Ohio, Land Area: 200, Structure Area: 200
	 * 
	 * PropertyB: Location: Ohio, Land Area: 300, Structure Area: 200
	 * 
	 * Expect: -1
	 */
	@Test
	public void testBMoreLandThanAExpectNeg1() {
		RealEstate propertyA = new RealEstate("Ohio", 200, 200);
		RealEstate propertyB = new RealEstate("Ohio", 300, 200);
		int report = propertyA.compareTo(propertyB);
		assertEquals(-1, report);
	}
	
	/**
	 * This test will create two RealEstate objects and compare them
	 * using the compareTo method.
	 * 
	 * PropertyA: Location: Ohio, Land Area: 500, Structure Area: 300
	 * 
	 * PropertyB: Location: Ohio, Land Area: 500, Structure Area: 200
	 * 
	 * Expect: 1
	 */
	@Test
	public void testLandAreaEqualAMoreStructureThanBExpect1() {
		RealEstate propertyA = new RealEstate("Ohio", 500, 300);
		RealEstate propertyB = new RealEstate("Ohio", 500, 200);
		int report = propertyA.compareTo(propertyB);
		assertEquals(1, report);
	}
	
	/**
	 * This test will create two RealEstate objects and compare them
	 * using the compareTo method.
	 * 
	 * PropertyA: Location: Alabama, Land Area: 500, Structure Area: 200
	 * 
	 * PropertyB: Location: Bahamas, Land Area: 500, Structure Area: 200
	 * 
	 * Expect: -1
	 */
	@Test
	public void testLandAreaEqualStructureEqualAMoreStructureAIsBeforeBThanBExpectNeg1() {
		RealEstate propertyA = new RealEstate("Alabama", 500, 200);
		RealEstate propertyB = new RealEstate("Bahamas", 500, 200);
		int report = propertyA.compareTo(propertyB);
		assertEquals(-1, report);
	}
	
	/**
	 * This test will create two RealEstate objects and compare them
	 * using the compareTo method.
	 * 
	 * PropertyA: Location: Bahamas, Land Area: 500, Structure Area: 200
	 * 
	 * PropertyB: Location: Alabama, Land Area: 500, Structure Area: 200
	 * 
	 * Expect: 1
	 */
	@Test
	public void testLandAreaEqualStructureEqualAMoreStructureBIsBeforeAThanBExpectNeg1() {
		RealEstate propertyA = new RealEstate("Bahamas", 500, 200);
		RealEstate propertyB = new RealEstate("Alabama", 500, 200);
		int report = propertyA.compareTo(propertyB);
		assertEquals(1, report);
	}

}
