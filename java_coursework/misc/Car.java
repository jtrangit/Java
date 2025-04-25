//Johnny Tran
//Assignment 9. Warm Up with Objects
//March 29. 2022
public class Car {
    String make;
    String model;
    int year;
    double MPG;
    double milesDriven;
    double fuelCapacity;
    double fuelRemaining;
    
    //Constructor for class Car
    public Car(String make, String model, int year, double MPG, double milesDriven, double fuelCapacity, double fuelRemaining) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.MPG = MPG;
        this.milesDriven = milesDriven;
        this.fuelCapacity = fuelCapacity;
        this.fuelRemaining = fuelRemaining;
    }

    //Function returns the amount of gas needed to fill tank up to full
    //Can not fill more than the car's total capacity 
    public double fillTank(double g) {
        this.fuelRemaining += g;

        if (this.fuelRemaining > this.fuelCapacity) {
            this.fuelRemaining = this.fuelCapacity;
        }
        
        return this.fuelRemaining;
    }

    //Adds to the total miles m driven and reduces the amount of gas based on the car's MPG
    public void drive(double m) {
        this.milesDriven += m;
        this.fuelRemaining -= m / MPG;
    }

    //String representation of the car
    public String toString() {
        return("This car is a " + this.make + " " + this.model + " " + this.year + " it has " + this.MPG + " miles per gallon and has " + this.milesDriven + " miles driven on it, with a fuel capacity of " + this.fuelCapacity + " gallons, and currently has " + this.fuelRemaining + " gallons of fuel left right now" );
    }

    //returns amount of fuel left in tank
    public double getFuelRemaining() {
        return this.fuelRemaining;
    }
}

