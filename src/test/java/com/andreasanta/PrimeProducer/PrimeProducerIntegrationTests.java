package com.andreasanta.PrimeProducer;

import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import net.minidev.json.JSONArray;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import static net.javacrumbs.jsonunit.spring.JsonUnitResultMatchers.json;

@SpringBootTest
@AutoConfigureMockMvc
class PrimeProducerIntegrationTests {

	@Autowired
	private MockMvc mockMvc;

	private static final int FIRST_HUNDRED_PRIMES[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
			61, 67, 71, 73, 79, 83, 89, 97 };

	/*
	 * SQRT brute force
	 */

	@Test
	void sqrtBruteforceFirst100() throws Exception {
		mockMvc.perform(get("/bruteforce/100").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.Initial").value(100)).andExpect(jsonPath("$.Primes").isArray())
				.andExpect(json().node("Primes").isEqualTo(FIRST_HUNDRED_PRIMES));
	}

	@Test
	void sqrtBruteforceError() throws Exception {

		mockMvc.perform(get("/bruteforce/abcd")).andDo(print()).andExpect(status().isBadRequest());
	}

	/*
	 * Vedic brute force
	 */

	@Test
	void vedicBruteforceFirst100() throws Exception {
		mockMvc.perform(get("/vedic/100").accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.Initial").value(100)).andExpect(jsonPath("$.Primes").isArray())
				.andExpect(json().node("Primes").isEqualTo(FIRST_HUNDRED_PRIMES));
	}

	@Test
	void vedicBruteforceError() throws Exception {

		mockMvc.perform(get("/vedic/abcd")).andDo(print()).andExpect(status().isBadRequest());
	}

	/*
	 * Atkin brute force
	 */

	@Test
	void atkinBruteforceFirst100() throws Exception {
		mockMvc.perform(get("/atkin/100").accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.Initial").value(100)).andExpect(jsonPath("$.Primes").isArray())
				.andExpect(json().node("Primes").isEqualTo(FIRST_HUNDRED_PRIMES));
	}

	@Test
	void atkinBruteforceError() throws Exception {

		mockMvc.perform(get("/atkin/abcd")).andDo(print()).andExpect(status().isBadRequest());
	}

	/*
	 * Eratosthenes
	 */
	@Test
	void eraBruteforceFirst100() throws Exception {
		mockMvc.perform(get("/eratosthenes/100").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.Initial").value(100)).andExpect(jsonPath("$.Primes").isArray())
				.andExpect(json().node("Primes").isEqualTo(FIRST_HUNDRED_PRIMES));
	}

	@Test
	void eraBruteforceError() throws Exception {

		mockMvc.perform(get("/eratosthenes/abcd")).andDo(print()).andExpect(status().isBadRequest());
	}

	/*
	 * Sundaram
	 */
	@Test
	void sunBruteforceFirst100() throws Exception {
		mockMvc.perform(get("/sundaram/100").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.Initial").value(100)).andExpect(jsonPath("$.Primes").isArray())
				.andExpect(json().node("Primes").isEqualTo(FIRST_HUNDRED_PRIMES));
	}

	@Test
	void sunBruteforceError() throws Exception {

		mockMvc.perform(get("/sundaram/abcd")).andDo(print()).andExpect(status().isBadRequest());
	}
}
