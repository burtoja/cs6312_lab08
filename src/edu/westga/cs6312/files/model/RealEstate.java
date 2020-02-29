package edu.westga.cs6312.files.model;

/**
 * This class will manage data concerning real estate location, land area, and
 * structure area
 * 
 * @author J. Allen Burton
 * @version Feb 28, 2020
 *
 */

public class RealEstate implements Comparable<RealEstate> {
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
			throw new IllegalArgumentException("Month cannot be null.");
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
	 * @return string representation of RealEstate object variables
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

	/**
	 * Gets the location name of the property
	 * 
	 * @return location name of the property
	 *
	 * @precondition none
	 *
	 * @postcondition no change to object
	 */
	public String getLocation() {
		return this.location;
	}

	/**
	 * Gets the land area of the property
	 * 
	 * @return land area of the property
	 * 
	 * @precondition none
	 *
	 * @postcondition no change to object
	 */
	public int getLandArea() {
		return this.landArea;
	}

	/**
	 * Gets the structure area of the property
	 * 
	 * @return structure area of the property
	 *
	 * @precondition none
	 *
	 * @postcondition no change to object
	 */
	public int getStructureArea() {
		return this.structureArea;
	}

	/**
	 * This method compares this RealEstate object based on land area followed by
	 * structure area followed by location name with all compared with ascending
	 * order
	 *  
	 * @param propertyToCompare the RealEstate object to compare to this RealEstate
	 *                          object
	 * 
	 * @return -1 if this lower in sort value, 0 if this object is of equal
	 *         sort value, or 1 if this object is greater in sort value
	 *
	 * @precondition propertyToCompare must be a valid RealEstate object
	 *
	 * @postcondition no changes to either object
	 * 
	 */
	@Override
	public int compareTo(RealEstate propertyToCompare) {
		int returnValue = 0;
		if (this.getLandArea() > propertyToCompare.getLandArea()) {
			returnValue = 1;
		} else if (this.getLandArea() < propertyToCompare.getLandArea()) {
			returnValue = -1;
		} else if (this.getStructureArea() > propertyToCompare.getStructureArea()) {
			returnValue = 1;
		} else if (this.getStructureArea() < propertyToCompare.getStructureArea()) {
			returnValue = -1;
		} else if (this.getLocation().compareTo(propertyToCompare.getLocation()) < 0) {
			returnValue = -1;
		} else if (this.getLocation().compareTo(propertyToCompare.getLocation()) > 0) {
			returnValue = 1;
		}
		return returnValue;
	}

}
