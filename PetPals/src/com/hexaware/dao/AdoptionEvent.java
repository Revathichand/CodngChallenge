package com.hexaware.dao;

import java.util.ArrayList;
import java.util.List;


 //Manages an adoption event and the participants involved.
 //Participants must implement the IAdoptable interface.
public class AdoptionEvent {
    private List<IAdoptable> participants;

    // Constructor initializes the list of participants
    public AdoptionEvent() {
        participants = new ArrayList<>();
    }

    //Registers an adoptable entity (e.g., a shelter) to the event.
     
     
    public void registerParticipant(IAdoptable participant) {
        participants.add(participant);
        System.out.println(" Participant registered for adoption event.");
    }
    
     //Starts the adoption event.
     //Calls the adopt() method on all registered participants.
     
    public void hostEvent() {
        System.out.println(" Hosting Adoption Event...");
        for (IAdoptable participant : participants) {
            participant.adopt();
        }
    }
}
