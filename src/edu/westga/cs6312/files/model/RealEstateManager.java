package edu.westga.cs6312.files.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class will manage the currently listed RealEstate objects
 * 
 * @author J. Allen Burton
 * @version Feb 28, 2020
 *
 */
public class RealEstateManager {
	private ArrayList<RealEstate> listedRealEstate;

	/**
	 * Constructor for RealEstateManager objects
	 *
	 * @precondition none
	 *
	 * @postcondition new RealEstateManager object with empty initialized ArrayList
	 *                ready to take RealEstate objects
	 */
	public RealEstateManager() {
		this.listedRealEstate = new ArrayList<RealEstate>();
	}

	/**
	 * This method adds a RealEstate object to the current list
	 * 
	 * @param newProperty the property to be added to the list
	 *
	 * @precondition newProperty != null
	 *
	 * @postcondition RealEstate object added to listedRealEstate list in object
	 */
	public void addProperty(RealEstate newProperty) {
		if (newProperty == null) {
			throw new IllegalArgumentException("Invalid RealEstate object provided");
		}
		this.listedRealEstate.add(newProperty);
	}

	/**
	 * Gets the full list of collected RealEstate objects held in this object
	 * 
	 * @return	ArrayList of RealEstate objects
	 *
	 * @precondition	none	
	 *
	 * @postcondition	no change to object
	 */
	public ArrayList<RealEstate> getProperties() {
		return this.listedRealEstate;
	}
	
	/**
	 * 
	 * 
	 *
	 * @precondition
	 *
	 * @postcondition
	 */
	public void sortProperties() {
		Collections.sort(this.listedRealEstate);
	}

	/**
	 * Returns a string representation of the object variables
	 * 
	 * @return	string representation of the object variables
	 *
	 * @precondition	none
	 *
	 * @postcondition	no change to object
	 */
	@Override
	public String toString() {
		String report = "Current Real Estate Listings:\n";
		if (this.listedRealEstate.size() == 0) {
			report += "\tThere are no current listings";
		} else {
			for (RealEstate currentProperty : this.listedRealEstate) {
				report += currentProperty.toString() + "\n";
			}
		}
		return report;
	}

}
