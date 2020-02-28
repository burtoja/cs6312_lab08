package edu.westga.cs6312.files.model;

/**
 * This class will manage data concerning real estate location, land area, and
 * structure area
 * 
 * @author J. Allen Burton
 * @version Feb 28, 2020
 *
 */

public class RealEstate {
	private String location;
	private int landArea;
	private int structureArea;

	/**
	 * Constructor for RealEstate objects
	 *
	 * @param location      a String description of the location of the RealEstate
	 *                      object
	 * @param landArea      the area of land associated with the RealEstate object
	 * @param structureArea the area of the structure associated with the RealEstate
	 *                      object
	 *
	 * @precondition location must be a String of at least 2 characters
	 * @precondition landArea > 0
	 * @precondition structureArea >= 0
	 *
	 * @postcondition new RealEstate object created with the given parameters set
	 *                into instance variables
	 */
	public RealEstate(String location, int landArea, int structureArea) {
		if (location == null) {
			throw new NullPointerException("Month cannot be null.");
		}
		if (location.length() < 2) {
			throw new IllegalArgumentException("Location description must have at least two characters.");
		}
		if (landArea <= 0) {
			throw new IllegalArgumentException("Land area must be greater than zero");
		}
		if (structureArea < 0) {
			throw new IllegalArgumentException("Structure area cannot be negative");
		}
		this.location = location;
		this.landArea = landArea;
		this.structureArea = structureArea;
	}

	/**
	 * This method will return a string representation of the RealEstate location
	 * and areas
	 * 
	 * @return string representation of object variables
	 *
	 * @precondition none
	 *
	 * @postcondition object is not changed
	 */
	@Override
	public String toString() {
		return "Location: " + this.location + "\tLand Area: " + this.landArea + " sq.ft.\tStructure Area: "
				+ this.structureArea + " sq.ft.";
	}

	/**
	 * This method allows a structure to be added to the land. This method adds the
	 * area of the new structure to the existing structure area for the RealEstate
	 * object.
	 * 
	 * @param structureArea the area of the structure to be added to the property
	 *
	 * @precondition structureArea >= 0 && structureArea <= landArea
	 *
	 * @postcondition object will have new structure area if parameter sent is valid
	 */
	public void addStructureArea(double structureArea) {
		if (structureArea < 0) {
			throw new IllegalArgumentException("Structure area cannot be negative");
		}
		if ((this.structureArea + structureArea) > this.landArea) {
			throw new IllegalArgumentException("Total structure area excedes land area available");
		}
		this.structureArea += structureArea;
	}

}
