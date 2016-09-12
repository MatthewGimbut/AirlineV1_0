/**
 * SilverMember.java is an implementation of the MemberPassenger interface which helps 
 * apple the State Pattern to Passenger.java which gives MemberPassenger and its implemented
 *  classes functionality of if the Passenger can register 
 * for a flight and updating the existing membership. Memberships come in Platinum, Gold, 
 * Silver, and None.
 * @author Sean Zimmerman, Matthew Gimbut, Phong Tran
 * @version 2015.11.20
 */

package Airline.Passenger;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

//import org.joda.time.Days;
//import org.joda.time.LocalDate;

import Airline.Airplane.Airplane;
import Airline.CustomExceptions.CannotUpgradeMembershipException;

public class SilverMember implements MemberPassenger {

	//Default generated serialVersionUID so we can save SilverMembers
	private static final long serialVersionUID = -773711284315329608L;
	private final double PRICE_REDUCTION = 15.25;


	/**
	 * Default Constructor
	 */
	public SilverMember() {
		//Do nothing
	}
	
	@Override
	/**
	 * Determines if the Passenger can register for this plane
	 * @param plane The Airplane to check if the passenger can register for it
	 * @return If the passenger can register
	 */
	public boolean canRegister(Airplane plane) {
		//Using the external library Joda Time to easily get the distance between date objects in days
		int differenceNum = LocalDate.now().until(plane.getRoute().getFlightDate()).getDays();
		
		//If the dates are closer than the allowed registration day
		if(differenceNum <= MemberPassenger.SILVER_REGISTRATION_DAYS) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	/**
	 * Upgrades the membership type of the Passenger
	 * @param passenger The passenger to be upgraded
	 * @throws CannotUpgradeMembershipException The Passenger is already at the highest upgrade
	 */
	public void updateMembership(Passenger passenger) throws CannotUpgradeMembershipException {
		passenger.setMembership(new GoldMember());
	}
	
	public String toString() {
		return "Silver Membership";
	}

	@Override
	public double getPriceReduction() {
		return PRICE_REDUCTION;
	}
}
