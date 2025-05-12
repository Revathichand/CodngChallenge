package com.hexaware.dao;

import java.time.LocalDate;


 //Represents a cash donation made by a donor.
  //Extends the abstract Donation class.
 
public class CashDonation extends Donation {
    private LocalDate donationDate;

	// Default Constructor
    public CashDonation(String donorName, double amount, LocalDate donationDate) {
        super(donorName, amount);
        this.donationDate = donationDate;
    }

    
    //Parameterized Constructor
    public CashDonation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CashDonation(String donorName, double amount) {
		super(donorName, amount);
		// TODO Auto-generated constructor stub
	}


    // Getter and Setter for donationDate
    public LocalDate getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    //Implementation of abstract method to record a cash donation.
     
    @Override
    public void recordDonation() {
        System.out.println(" Cash Donation Recorded:");
        System.out.println("  Donor: " + donorName);
        System.out.println("  Amount: $" + amount);
        System.out.println("  Date: " + donationDate);
    }
}
