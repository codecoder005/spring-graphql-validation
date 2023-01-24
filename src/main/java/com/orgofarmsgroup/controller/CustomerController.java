package com.orgofarmsgroup.controller;

import com.orgofarmsgroup.dto.CustomerDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerController {

    @PostMapping
    public CustomerDto post(@Valid @RequestBody CustomerDto customerDto) {
        return customerDto;
    }
}
