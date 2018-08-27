package hw1;

public class Cab {
	
	private double BaseFare;
	private double PerMileRate;
	private double Miles;
	private boolean Passenger;
	private double totalCash;
	private double totalMiles;
	public Cab(double givenBaseFare, double givenPerMileRate) {
		BaseFare = givenBaseFare;
		PerMileRate = givenPerMileRate;
		
	}
	
	//Starts a new ride, setting the meter to the base fare and setting the current rate to the per mile charge. 
	//If there had been a previous call to pickUp() without a corresponding call to dropOff(), the previous value on the meter is ignored.
	public void pickUp() {
		Miles = 0;
		Passenger = true;
	}
	
	//Ends the current ride, updating the total cash collected and resetting the meter and current rate to zero.
	public void dropOff() {
		totalCash += (Miles * PerMileRate) + BaseFare;
		Miles = 0;
		Passenger = false;
	}
	
	//Drives the cab the given number of miles, updating the total miles and possibly updating the meter.
	//In general, the current rate times the miles driven is added to the meter, but the current rate might be zero. 
	//This method does not modify the total cash. Parameters: miles - number of miles to drive
	public void drive(double miles) {
		Miles += miles;
		totalMiles += miles;
	}
	
	//Returns the total miles driven by this cab during its lifetime. Return: total miles driven
	public double getTotalMiles() {
		return totalMiles;
	}
	
	//Returns the total cash collected by this cab during its lifetime. Return: total cash collected
	public double getTotalCash() {
		
			return totalCash;
	}
	
	//Returns the amount of money shown on the meter for the current ride. This will always be zero before start() is called.
	//return: amount of money shown on the meter
	public double getMeter() {
		if (Passenger) {
			return (Miles * PerMileRate) + BaseFare;
		}else {
			return 0;
		}
	}
	
	//Returns the current per-mile rate, which is always either zero or the per-mile rate given in the constructor.
	//Return: the current per-mile rate
	public double getCurrentRate() {
		if (Passenger) {
			return PerMileRate;
		}else {
			return 0;
		}
	}
	
	//Determines whether the cab currently has a passenger (i.e., the current rate is nonzero).
	//true if the cab has a passenger, false otherwise
	public boolean hasPassenger() {
		return Passenger;
	}
	
	//Returns the average income earned by this cab per mile driven.
	//Return: average income per mile
	public double getAverageIncomePerMile() {
		return totalCash / totalMiles;
	}
}
