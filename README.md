# Prime Generation Frenzy

Java Spring Boot service implementing several algorightms for prime generation.

## Implemented algoritms

### Non parallel
    - Sqrt bruteforce
    - Sieve of Eratosthenes
    - Sieve of Sundaram
    - Sieve of Atkin
    - Vedic Bruteforce (limited to 100.000 max)

### Parallel

-- TODO

## Endpoints and responses

The endpoints return either XML or JSON content, according to the `Accept` HTTP header.

## Testing

-- TODO

## TODO

- Create a StrategyFactory class to instantiate the proper stategy based on the request URL
- Return the number of milliseconds per each calculation
- Separate unit tests in different files
- Separate integration tests in different files
