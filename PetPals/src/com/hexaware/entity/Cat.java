package com.hexaware.entity;

public class Cat extends Pet {
    private String catColor;


    //Default Constructors
    public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    //Parameterized Constructors
	public Cat(String name, int age, String breed) {
		super(name, age, breed);
		// TODO Auto-generated constructor stub
	}
	public Cat(String catColor) {
		super();
		this.catColor = catColor;
	}
	
	public String getCatColor() { return catColor; }
    public void setCatColor(String catColor) { this.catColor = catColor; }

    @Override
    public String toString() {
        return super.toString() + ", CatColor: " + catColor;
    }
}
