package com.chatop.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.dto.RentalsRequestDto;
import com.chatop.model.Rentals;
import com.chatop.services.RentalsService;

@RestController
public class RentalsController {

    @Autowired
    private RentalsService rentalsService;

    @GetMapping("/rentals")
    public Iterable<Rentals> getAllRentals() {
        return rentalsService.getAllRentals();
    }

    @GetMapping("/rentals/:id")
    public Optional<Rentals> getRental(final Long id) {
        return rentalsService.getRental(id);
    }

    @PostMapping("rentals")
    public Rentals postRentals(RentalsRequestDto rentals) {
        return rentalsService.postRentals(rentals);
    }

    // @PutMapping("rentals/:id")

}

/**
 * routes à mettre ici:
 * /messages PostMapping
 * /rentals GetMapping
 * /rentals/:id GetMapping
 * /rentals PostMapping
 * /rentals/:id PutMapping
 * /user/:id GetMapping
 */