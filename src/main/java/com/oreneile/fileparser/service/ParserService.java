package com.oreneile.fileparser.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ParserService {
    public Map<String, Object> analyzeContent(List<String> lines) {
        Map<String, Object> stats = new HashMap<>();
        int lineCount = lines.size();
        int wordCount = 0;
        Map<String, Integer> wordFreq = new HashMap<>();

        for (String line : lines) {
            String[] words = line.trim().split("\\s+");
            wordCount += words.length;
            for (String word : words) {
                if (!word.isEmpty()) {
                    word = word.toLowerCase().replaceAll("[^a-z]", "");
                    wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
                }
            }
        }

        stats.put("lineCount", lineCount);
        stats.put("wordCount", wordCount);
        stats.put("wordFrequency", wordFreq);
        return stats;
    }
}