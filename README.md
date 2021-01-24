# Prime Generation Frenzy

Java Spring Boot service implementing several algorightms for prime generation. 

As instructed, all algorithms have a more optimized parallel version and all
controller methods have a `@Cacheable` annotation which caches the results.

## Getting started

After installing maven, execute the following command in the root project directory:

`./mvnw spring-boot:run`

This should compile and execute the web app, and boot it on http://localhost:8080/.

In order to ensure the app has booted properly, try and access a basic prime number
generator, such as:

http://localhost:8080/bruteforce/100

This should return:

```json
    {
        "Initial": 100,
        "Primes": [
            2,
            3,
            5,
            7,
            11,
            13,

            ...

            97
        ]
    }
```

## Implemented algoritms

The following algos have been implemented both in parallel and non parallel fashion:

    - Sqrt bruteforce
    - Sieve of Eratosthenes
    - Sieve of Sundaram
    - Sieve of Atkin
    - Vedic Bruteforce (limited to 100.000 max)

## Endpoints and responses

The endpoints return _either XML or JSON content_, according to the `Accept` HTTP header.

This is a list of the currently created endpoints:
### /bruteforce/{number}
Executes an optimized bruteforce up to the specified number.
### /parallel_bruteforce/{number}
Executes a parallel bruteforce up to the specified number.
### /vedic/{number}
Executes vedic bruteforce up to the specified number.
### /parallel_vedic/{number}
Executes a parallel vedic bruteforce up to the specified number.
### /eratosthenes/{number}
Executes a Sieve of Erathostenes up to the specified number.
### /parallel_eratosthenes/{number}
Executes a Parallel Sieve of Erathostenes up to the specified number.
### /sundaram/{number}
Executes a Sieve of Sundaram up to the specified number.
### /parallel_sundaram/{number}
Executes a Parallel Sieve of Sundaram up to the specified number.
### /atkin/{number}
Executes a Sieve of Atkin up to the specified number.
### /parallel_atkin/{number}
Executes a Parallel Sieve of Atkin up to the specified number.
## Testing

As usual with Spring Boot, running the test suite is as simple as

`mvnw test`

This shouls result in all tests passing.

## TODO / Future improvements

- Create a StrategyFactory class to instantiate the proper stategy based on the request URL
- Separate unit tests in different files
- Separate integration tests in different files
- Add integration tests for XML results
- Add unit/integration tests for Parallel Algorithms
- Return the number of milliseconds per each calculation for comparison
- Limit the maximum time for calculation for big numbers
- Add more comments to the code