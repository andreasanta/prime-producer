package com.andreasanta.PrimeProducer.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@JacksonXmlRootElement(localName = "Result")
public class SimpleResponse {
    @JsonProperty("Initial")
    @JacksonXmlProperty
    private final int Initial;

    @JsonProperty("Prime")
    @JacksonXmlProperty(localName = "Prime")
    @JacksonXmlElementWrapper(localName = "Primes")
    private final List<Integer> Primes;
}
