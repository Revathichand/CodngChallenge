package com.hexaware.entity;

public class Dog extends Pet {
    private String dogBreed;

	//Parameterized Constructors
	public Dog(String name, int age, String breed, String dogBreed) {
		super(name, age, breed);
		this.dogBreed = dogBreed;
	}
	
	//Default Constructors
	public Dog(String name, int age, String breed) {
		super(name, age, breed);
		// TODO Auto-generated constructor stub
	}
	public String getDogBreed() { return dogBreed; }
    public void setDogBreed(String dogBreed) { this.dogBreed = dogBreed; }

    @Override
    public String toString() {
        return super.toString() + ", DogBreed: " + dogBreed;
    }
}
