package com.hexaware.dao;

	import java.util.ArrayList;
	import java.util.List;

	import com.hexaware.entity.Pet;


	 //Represents a pet shelter that can hold and manage pets available for adoption.
	 //Implements IAdoptable to participate in adoption events.
	 
	public class PetShelter implements IAdoptable {

	    // List to store pets available for adoption
	    private List<Pet> availablePets;

	    // Constructor initializes the availablePets list
	    public PetShelter() {
	        this.availablePets = new ArrayList<>();
	    }

	    //Adds a pet to the shelter's available list.
	    public void addPet(Pet pet) {
	        if (pet != null) {
	            availablePets.add(pet);
	            System.out.println("Pet added to shelter: " + pet.getName());
	        } else {
	            System.out.println(" Cannot add null pet.");
	        }
	    }

	    //Removes a pet from the shelter's available list.
	    public void removePet(Pet pet) {
	        if (availablePets.remove(pet)) {
	            System.out.println("Pet removed: " + pet.getName());
	        } else {
	            System.out.println(" Pet not found in shelter.");
	        }
	    }

	 
	     //Gets the list of all pets currently available for adoption.

	    public List<Pet> listAvailablePets() {
	        return availablePets;
	    }

	    
	     //Implements adopt() from IAdoptable interface.
	     //Called during an adoption event.
	     
	    @Override
	    public void adopt() {
	        if (availablePets.isEmpty()) {
	            System.out.println(" No pets available for adoption right now.");
	        } else {
	            for (Pet pet : availablePets) {
	                System.out.println(" Available Pet: " + pet.toString());
	            }
	        }
	    }
	}