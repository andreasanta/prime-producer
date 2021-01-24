package com.andreasanta.PrimeProducer.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

import com.andreasanta.PrimeProducer.strategies.*;
import com.andreasanta.PrimeProducer.responses.SimpleResponse;

/**
 * Implements several endpoints with different prime calculation methods.
 */
@RestController
public class PrimeController {

    @RequestMapping(path = "/bruteforce/{target}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
    public ResponseEntity<SimpleResponse> bruteforce(@PathVariable int target) {
        SqrtBruteforceStrategy strategy = new SqrtBruteforceStrategy();
        List<Integer> primes = strategy.generate(target);

        return ResponseEntity.ok(new SimpleResponse(target, primes));
    }

    @RequestMapping(path = "/parallel_bruteforce/{target}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
    public ResponseEntity<SimpleResponse> parallelBruteforce(@PathVariable int target) {
        ParallelSqrtBruteforceStrategy strategy = new ParallelSqrtBruteforceStrategy();
        List<Integer> primes = strategy.generate(target);

        return ResponseEntity.ok(new SimpleResponse(target, primes));
    }

    @RequestMapping(path = "/eratosthenes/{target}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
    public ResponseEntity<SimpleResponse> eratosthenes(@PathVariable int target) {
        SieveOfEratosthenes strategy = new SieveOfEratosthenes();
        List<Integer> primes = strategy.generate(target);

        return ResponseEntity.ok(new SimpleResponse(target, primes));
    }

    @RequestMapping(path = "/parallel_eratosthenes/{target}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
    public ResponseEntity<SimpleResponse> parallelEratosthenes(@PathVariable int target) {
        ParallelSieveOfEratosthenes strategy = new ParallelSieveOfEratosthenes();
        List<Integer> primes = strategy.generate(target);

        return ResponseEntity.ok(new SimpleResponse(target, primes));
    }

    @RequestMapping(path = "/sundaram/{target}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
    public ResponseEntity<SimpleResponse> sundaram(@PathVariable int target) {
        SieveOfSundaram strategy = new SieveOfSundaram();
        List<Integer> primes = strategy.generate(target);

        return ResponseEntity.ok(new SimpleResponse(target, primes));
    }

    @RequestMapping(path = "/parallel_sundaram/{target}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
    public ResponseEntity<SimpleResponse> parallelSundaram(@PathVariable int target) {
        ParallelSieveOfSundaram strategy = new ParallelSieveOfSundaram();
        List<Integer> primes = strategy.generate(target);

        return ResponseEntity.ok(new SimpleResponse(target, primes));
    }

    @RequestMapping(path = "/vedic/{target}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
    public ResponseEntity<SimpleResponse> vedic(@PathVariable int target) {
        VedicBruteforceStrategy strategy = new VedicBruteforceStrategy();
        List<Integer> primes = strategy.generate(target);

        return ResponseEntity.ok(new SimpleResponse(target, primes));
    }

    @RequestMapping(path = "/parallel_vedic/{target}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
    public ResponseEntity<SimpleResponse> parallelVedic(@PathVariable int target) {
        ParallelVedicBruteforceStrategy strategy = new ParallelVedicBruteforceStrategy();
        List<Integer> primes = strategy.generate(target);

        return ResponseEntity.ok(new SimpleResponse(target, primes));
    }

    @RequestMapping(path = "/atkin/{target}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
    public ResponseEntity<SimpleResponse> atkin(@PathVariable int target) {
        SieveOfAtkin strategy = new SieveOfAtkin();
        List<Integer> primes = strategy.generate(target);

        return ResponseEntity.ok(new SimpleResponse(target, primes));
    }

    @RequestMapping(path = "/parallel_atkin/{target}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
    public ResponseEntity<SimpleResponse> parallelAtkin(@PathVariable int target) {
        ParallelSieveOfAtkin strategy = new ParallelSieveOfAtkin();
        List<Integer> primes = strategy.generate(target);

        return ResponseEntity.ok(new SimpleResponse(target, primes));
    }
}
