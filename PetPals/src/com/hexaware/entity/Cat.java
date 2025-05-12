package com.hexaware.entity;

public class Cat extends Pet {
    private String catColor;


    //Parameterized Constructors
    public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cat(String name, int age, String breed) {
		super(name, age, breed);
		// TODO Auto-generated constructor stub
	}
	
	//Default Constructors
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
