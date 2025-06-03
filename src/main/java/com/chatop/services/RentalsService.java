package com.chatop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatop.repository.RentalsRepository;
import com.chatop.model.Rentals;

import lombok.Data;

@Data
@Service
public class RentalsService {
    
    @Autowired
    private RentalsRepository rentalsRepository;
    public Optional<Rentals> getRental(final Long id){
        return rentalsRepository.findById(id);
    }
    // rentals get

    public Iterable<Rentals> getAllRentals(){
        return rentalsRepository.findAll();
    }
    //rentals getAll

    public Rentals postRentals(Rentals rentals){
        Rentals newRental = rentalsRepository.save(rentals);
        return newRental;
    }
    //rentals post

    //rentals put
}
