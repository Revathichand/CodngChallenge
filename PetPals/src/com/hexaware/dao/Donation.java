package com.hexaware.dao;


 //Abstract base class representing a generic donation.
 //All donations (cash, item) will extend this class.
public abstract class Donation {
    protected String donorName;
    protected double amount;
    
    
    // Default Constructor
    public Donation(String donorName, double amount) {
        this.donorName = donorName;
        this.amount = amount;
    }

    
    //Parameterized Constructors
    public Donation() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    // Getter and Setter for donorName
    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    // Getter and Setter for amount
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    //Abstract method to be implemented by all types of donations.
     //Each subclass will define how to record the donation.
    public abstract void recordDonation();
}
