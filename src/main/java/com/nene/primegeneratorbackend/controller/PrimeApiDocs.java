package com.nene.primegeneratorbackend.controller;

import com.nene.primegeneratorbackend.model.PrimeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Prime Number Generator", description = "API for calculating prime numbers up to a specified limit")
public interface PrimeApiDocs {

    @Operation(
            summary = "Get all prime numbers up to a limit",
            description = "Calculates and returns a list of all prime numbers from 2 up to and including the provided input number.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved list of primes"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid input"
                    )
            }
    )
    // Map the endpoint
    @GetMapping(
            value = "/primes/{num}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    PrimeResponse getPrimesUpToLimit(
            @Parameter(description = "The upper limit (inclusive) for prime number calculation, must be an integer >= 0")
            @PathVariable int num
    );
}
