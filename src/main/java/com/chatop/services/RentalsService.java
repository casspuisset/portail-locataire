package com.chatop.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatop.repository.RentalsRepository;
import com.chatop.dto.RentalsRequestDto;
import com.chatop.model.Rentals;

import lombok.Data;

@Data
@Service
public class RentalsService {

    @Autowired
    private RentalsRepository rentalsRepository;

    public Optional<Rentals> getRental(final Long id) {
        return rentalsRepository.findById(id);
    }

    public Iterable<Rentals> getAllRentals() {
        return rentalsRepository.findAll();
    }

    public Rentals postRentals(RentalsRequestDto rentals) {
        Rentals newRental = new Rentals();

        newRental.setName(rentals.getName());
        newRental.setSurface(rentals.getSurface());
        newRental.setPrice(rentals.getPrice());
        newRental.setPicture(rentals.getPicture());
        newRental.setDescription(rentals.getDescription());
        newRental.setOwnerId(rentals.getOwnerId());
        newRental.setCreatedAt(LocalDateTime.now());
        newRental.setUpdatedAt(LocalDateTime.now());

        return rentalsRepository.save(newRental);
    }
}
