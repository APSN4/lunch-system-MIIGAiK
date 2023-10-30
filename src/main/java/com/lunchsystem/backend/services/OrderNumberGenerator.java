package com.lunchsystem.backend.services;

import com.lunchsystem.backend.model.Customer;
import com.lunchsystem.backend.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

@Component
public class OrderNumberGenerator {

    protected CustomerRepository customerRepository;
    public Integer generateFourDigits() {
        int i = 0;
        while (i < 9999) {
            Random random = new Random();
            Integer randomValue = Integer.valueOf(String.valueOf(random.nextInt(9999)));
            Optional<Customer> customer = customerRepository.findByOrderNumber(randomValue);
            if (customer.isEmpty()) return randomValue;
            i++;
        }
        throw new NoSuchElementException("No such free element");
    }

}
