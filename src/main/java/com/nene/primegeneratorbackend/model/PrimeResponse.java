package com.nene.primegeneratorbackend.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// Annotations for XML serialization
@JacksonXmlRootElement(localName = "Primes")
@Getter
@Setter
public class PrimeResponse {

    @JacksonXmlElementWrapper(localName = "Numbers")
    @JacksonXmlProperty(localName = "PrimeNumber")
    private List<Integer> primes;
    private int initial;

    // Default constructor
    public PrimeResponse() {
    }

    public PrimeResponse(List<Integer> primes, int initial) {
        this.primes = primes;
        this.initial = initial;
    }
}
