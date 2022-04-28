package com.example.gif;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import com.example.gif.models.Giphy;
import com.example.gif.services.GiphyService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GifApplicationTests {

	@Autowired
	private GiphyService giphySvc;

	@Test
	void shouldLoad10Images() {
		Optional<List<Giphy>> gifs = giphySvc.findGiphy("dog", 10, 0, "g", "en", "original");
		assertTrue(gifs.isPresent());
	}

}