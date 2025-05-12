package com.hexaware.entity;

public class Pet {
    private String name;
    private int age;
    private String breed;

 // Parameterized constructor
    public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Default Constructors
    public Pet(String name, int age, String breed) {
        super(); 
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Breed: " + breed;
    }
}
