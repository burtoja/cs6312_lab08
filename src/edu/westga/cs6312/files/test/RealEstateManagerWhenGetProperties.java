package edu.westga.cs6312.files.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.RealEstate;
import edu.westga.cs6312.files.model.RealEstateManager;

/**
 * Test for the getProperties method in the RealEstateManager class
 * 
 * @author J. Allen Burton
 * @version Feb 28, 2020
 *
 */

public class RealEstateManagerWhenGetProperties {

	/**
	 * Test for the getLocation method in the RealEstateManager class. This test
	 * will create a RealEstateManager object, add a RealEstate object to it, and
	 * then get the ArrayList containing the RealEstate object then get the toString
	 * method from the RealEstate object to verify RealEstate1 = location: Ohio,
	 * landArea: 500, structureArea: 200
	 */
	@Test
	public void testGetPropertiesSinglePropertyAddedLocationOhioLand500Structure200() {
		RealEstateManager theRealEstateManager = new RealEstateManager();
		RealEstate theRealEstate = new RealEstate("Ohio", 500, 200);
		theRealEstateManager.addProperty(theRealEstate);
		ArrayList<RealEstate> realEstateList = theRealEstateManager.getProperties();
		String report = "";
		for (RealEstate currentProperty : realEstateList) {
			report += currentProperty.toString();
		}
		assertEquals("Location: Ohio\tLand Area: 500 sq.ft.\tStructure Area: 200 sq.ft.", report);
	}

	/**
	 * Test for the getLocation method in the RealEstateManager class. This test
	 * will create a RealEstateManager object, add two RealEstate objects to it, and
	 * then get the ArrayList containing the RealEstate objects then get the
	 * toString method from the RealEstate objects to verify. RealEstate1 =
	 * location: Ohio, landArea: 500, structureArea: 200 RealEstate2 = location:
	 * Utah, landArea: 1200, structureArea: 400
	 */
	@Test
	public void testGetPropertiesTwoPropertiesAddedLocationOhioLand500Structure200() {
		RealEstateManager theRealEstateManager = new RealEstateManager();
		RealEstate theRealEstate1 = new RealEstate("Ohio", 500, 200);
		RealEstate theRealEstate2 = new RealEstate("Utah", 1200, 400);
		theRealEstateManager.addProperty(theRealEstate1);
		theRealEstateManager.addProperty(theRealEstate2);
		ArrayList<RealEstate> realEstateList = theRealEstateManager.getProperties();
		String report = "";
		for (RealEstate currentProperty : realEstateList) {
			report += currentProperty.toString();
		}
		assertEquals(
				"Location: Ohio\tLand Area: 500 sq.ft.\tStructure Area: 200 sq.ft.Location: Utah\tLand Area: 1200 sq.ft.\tStructure Area: 400 sq.ft.",
				report);
	}

}
