package com.hexaware.dao;

// Represents a physical item donation (e.g., food, toys).
//Extends the abstract Donation class.

public class ItemDonation extends Donation {
    private String itemType;

    //Default Constructors
  public ItemDonation(String donorName, double amount, String itemType) {
		super(donorName, amount);
		this.itemType = itemType;
	}

   //Parameterized Constructors
    public ItemDonation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemDonation(String donorName, double amount) {
		super(donorName, amount);
		// TODO Auto-generated constructor stub
	}

	// Getter and Setter for itemType
    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    //Implementation of abstract method to record an item donation.
    @Override
    public void recordDonation() {
        System.out.println(" Item Donation Recorded:");
        System.out.println("  Donor: " + donorName);
        System.out.println("  Item: " + itemType);
        System.out.println("  Estimated Value: $" + amount);
    }
}
