package edu.westga.cs6312.files.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.files.model.RealEstate;
import edu.westga.cs6312.files.model.RealEstateManager;

/**
 * Test for the sortProperties method in the RealEstateManager class
 * 
 * @author J. Allen Burton
 * @version Feb 29, 2020
 *
 */

public class RealEstateManagerWhenSortProperties {

	/**
	 * Test sort by land area (no ties) 
	 * RealEstate1 = location: Ohio, landArea: 200,
	 * structureArea: 200 
	 * RealEstate2 = location: Utah, landArea: 100,
	 * structureArea: 500 
	 * RealEstate3 = location: Idaho, landArea: 300,
	 * structureArea: 400
	 * 
	 * Expect order to be Utah, Ohio, Idaho
	 * 
	 */
	@Test
	public void testSortPropertiesLandAreaExpectUtahOhioIdaho() {
		RealEstateManager theRealEstateManager = new RealEstateManager();
		RealEstate theRealEstate1 = new RealEstate("Ohio", 300, 200);
		RealEstate theRealEstate2 = new RealEstate("Utah", 100, 500);
		RealEstate theRealEstate3 = new RealEstate("Idaho", 300, 400);
		theRealEstateManager.addProperty(theRealEstate1);
		theRealEstateManager.addProperty(theRealEstate2);
		theRealEstateManager.addProperty(theRealEstate3);
		theRealEstateManager.sortProperties();
		ArrayList<RealEstate> realEstateList = theRealEstateManager.getProperties();
		String report = theRealEstateManager.toString();
		assertEquals(
				"Current Real Estate Listings:\nLocation: Utah\tLand Area: 100 sq.ft.\tStructure Area: 500 sq.ft.\nLocation: Ohio\tLand Area: 300 sq.ft.\tStructure Area: 200 sq.ft.\nLocation: Idaho\tLand Area: 300 sq.ft.\tStructure Area: 400 sq.ft.\n",
				report);
	}
	
	/**
	 * Test sort by structure area (land area ties) 
	 * RealEstate1 = location: Ohio, landArea: 200,
	 * structureArea: 200 
	 * RealEstate2 = location: Utah, landArea: 200,
	 * structureArea: 500 
	 * RealEstate3 = location: Idaho, landArea: 200,
	 * structureArea: 400
	 * 
	 * Expect order to be Ohio, Idaho, Utah
	 * 
	 */
	@Test
	public void testSortPropertiesStructureAreaExpectOhioIdahoUtah() {
		RealEstateManager theRealEstateManager = new RealEstateManager();
		RealEstate theRealEstate1 = new RealEstate("Ohio", 200, 200);
		RealEstate theRealEstate2 = new RealEstate("Utah", 200, 500);
		RealEstate theRealEstate3 = new RealEstate("Idaho", 200, 400);
		theRealEstateManager.addProperty(theRealEstate1);
		theRealEstateManager.addProperty(theRealEstate2);
		theRealEstateManager.addProperty(theRealEstate3);
		theRealEstateManager.sortProperties();
		ArrayList<RealEstate> realEstateList = theRealEstateManager.getProperties();
		String report = theRealEstateManager.toString();
		assertEquals(
				"Current Real Estate Listings:\nLocation: Ohio\tLand Area: 200 sq.ft.\tStructure Area: 200 sq.ft.\nLocation: Idaho\tLand Area: 200 sq.ft.\tStructure Area: 400 sq.ft.\nLocation: Utah\tLand Area: 200 sq.ft.\tStructure Area: 500 sq.ft.\n",
				report);
	}
	
	/**
	 * Test sort by location name area (land area and location area ties) 
	 * RealEstate1 = location: Ohio, landArea: 200,
	 * structureArea: 200 
	 * RealEstate2 = location: Utah, landArea: 200,
	 * structureArea: 200 
	 * RealEstate3 = location: Idaho, landArea: 200,
	 * structureArea: 200
	 * 
	 * Expect order to be Idaho, Ohio, Utah
	 * 
	 */
	@Test
	public void testSortPropertiesLocationNameExpectIdahoOhioUtah() {
		RealEstateManager theRealEstateManager = new RealEstateManager();
		RealEstate theRealEstate1 = new RealEstate("Ohio", 200, 200);
		RealEstate theRealEstate2 = new RealEstate("Utah", 200, 200);
		RealEstate theRealEstate3 = new RealEstate("Idaho", 200, 200);
		theRealEstateManager.addProperty(theRealEstate1);
		theRealEstateManager.addProperty(theRealEstate2);
		theRealEstateManager.addProperty(theRealEstate3);
		theRealEstateManager.sortProperties();
		ArrayList<RealEstate> realEstateList = theRealEstateManager.getProperties();
		String report = theRealEstateManager.toString();
		assertEquals(
				"Current Real Estate Listings:\nLocation: Idaho\tLand Area: 200 sq.ft.\tStructure Area: 200 sq.ft.\nLocation: Ohio\tLand Area: 200 sq.ft.\tStructure Area: 200 sq.ft.\nLocation: Utah\tLand Area: 200 sq.ft.\tStructure Area: 200 sq.ft.\n",
				report);
	}

}
