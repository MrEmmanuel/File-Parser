package com.oreneile.fileparser;

import com.oreneile.fileparser.service.ParserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ParserServiceTest {

	@Test
	public void testAnalyzeContent() {
		ParserService parser = new ParserService();
		List<String> lines = List.of("Hello world", "Hello again");

		Map<String, Object> result = parser.analyzeContent(lines);

		assertEquals(2, result.get("lineCount"));
		assertEquals(4, result.get("wordCount"));

		@SuppressWarnings("unchecked")
		Map<String, Integer> freq = (Map<String, Integer>) result.get("wordFrequency");
		assertEquals(2, freq.get("hello"));
		assertEquals(1, freq.get("world"));
		assertEquals(1, freq.get("again"));
	}
}