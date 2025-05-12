package com.hexaware.dao;


 //Interface for any entity that can participate in the adoption process.
 //For example: shelters, future adopters, etc.
public interface IAdoptable {

    
     //This method will be called when an adoption is initiated.
     //Implementing classes define their own adoption behavior.
   
    void adopt();
}
