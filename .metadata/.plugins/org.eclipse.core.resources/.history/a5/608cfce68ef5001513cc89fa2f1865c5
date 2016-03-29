package com.java.practice;

public class Mercedes extends Car implements VehicleInterface {

	public void vehicleType() {
		System.out.println("Vehicle type is: Sedan Car");
	}

	public void fuelType() {
		System.out.println("Fuel type is: Diesel");
	}

	public void brandName(String brandName) {
		System.out.println("Brand of the Car is: " + brandName);
	}

	public void calculateSpeed(double dist, double time) throws InvalidTimeExeception {
		if (time <= 0)
			throw new InvalidTimeExeception("Invalid value entered for Time");
		double speed = dist / time;
		System.out.println("Speed of the vehicle is: " + speed + " km/h");

	}

	public void numberOfGears(int numberOfGears) {
		System.out.println("Number of gears are: " + numberOfGears);
	}

	public static void main(String args[]) {
		
		Mercedes merc = new Mercedes();
		merc.brandName("Mercedes");
		merc.vehicleType();
		merc.fuelType();
		merc.numberOfGears(7);
		try{
		merc.calculateSpeed(2000, 10);
		}catch(Exception e){
			System.out.println("Exception Occurred: "+e);
		}
	
	}

}