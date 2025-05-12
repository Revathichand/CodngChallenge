package com.hexaware.main;

import com.hexaware.entity.*;          // Pet, Dog, Cat
import com.hexaware.dao.*;            // PetShelter, Donations, AdoptionEvent
import com.hexaware.util.*;           // DB utility classes
import com.hexaware.exception.*;      // Custom exceptions

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

// Main menu-driven application for PetPals platform.
 
public class MainModule {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetShelter shelter = new PetShelter();

        try {
            // Load DB connection properties and connect
            Properties props = DBPropertyUtil.loadProperties("resources/db.properties");
            Connection conn = DBConnUtil.getConnection(props);
            System.out.println(" Connected successfully!");

            boolean exit = false;

            while (!exit) {
                System.out.println("\n--- PetPals Menu ---");
                System.out.println("1. Add Pet");
                System.out.println("2. List Pets");
                System.out.println("3. Make Donation");
                System.out.println("4. Host Adoption Event");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                switch (choice) {
                    case 1:
                        System.out.print("Enter pet name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter pet age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        if (age <= 0) {
                            throw new InvalidPetAgeException(" Pet age must be positive.");
                        }

                        System.out.print("Enter pet breed: ");
                        String breed = scanner.nextLine();

                        System.out.print("Enter type (dog/cat/other): ");
                        String type = scanner.nextLine().toLowerCase();

                        Pet pet;
                        switch (type) {
                            case "dog":
                                System.out.print("Enter dog breed: ");
                                String dogBreed = scanner.nextLine();
                                pet = new Dog(name, age, breed, dogBreed);
                                break;
                            case "cat":
                                System.out.print("Enter cat color: ");
                                String catColor = scanner.nextLine();
                                pet = new Cat(name, age, breed);
                                ((Cat) pet).setCatColor(catColor);
                                break;
                            default:
                                pet = new Pet(name, age, breed);
                        }

                        shelter.addPet(pet);
                        System.out.println(" Pet added to shelter.");
                        break;

                    case 2:
                        List<Pet> pets = shelter.listAvailablePets();
                        if (pets.isEmpty()) {
                            System.out.println(" No pets currently available.");
                        } else {
                            for (Pet p : pets) {
                                if (p.getName() == null || p.getBreed() == null) {
                                    throw new NullPetPropertyException(" Pet has missing info.");
                                }
                                System.out.println(p);
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter donor name: ");
                        String donor = scanner.nextLine();
                        System.out.print("Enter amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();

                        if (amount < 10) {
                            throw new InsufficientFundsException(" Minimum donation is $10.");
                        }

                        System.out.print("Is this a cash or item donation? ");
                        String donationType = scanner.nextLine().toLowerCase();

                        Donation donation;
                        if (donationType.equals("cash")) {
                            donation = new CashDonation(donor, amount, LocalDate.now());
                        } else {
                            System.out.print("Enter item type (e.g., food, toys): ");
                            String itemType = scanner.nextLine();
                            donation = new ItemDonation(donor, amount, itemType);
                        }

                        donation.recordDonation(); // Just a log here — optionally save to DB
                        break;

                    case 4:
                        System.out.println(" Hosting Adoption Event...");
                        AdoptionEvent event = new AdoptionEvent();
                        event.registerParticipant(shelter); // Shelter implements IAdoptable
                        event.hostEvent(); // Calls adopt() on each participant
                        break;

                        

                    case 5:
                        exit = true;
                        System.out.println(" Exiting PetPals. Goodbye!");
                        System.out.println(" Have a nice day!!");
                        break;

                    default:
                        System.out.println(" Invalid choice. Please try again.");
                }
            }

            conn.close();

        } catch (InvalidPetAgeException | NullPetPropertyException | InsufficientFundsException e) {
            System.err.println(" Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println(" File error: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println(" Database error: " + e.getMessage());
        }

        scanner.close();
    }
}
