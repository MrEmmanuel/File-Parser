package com.oreneile.fileparser.service;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportService {
    public void printReport(Map<String, Object> stats) {
        System.out.println("\n--- File Analysis Report ---");
        System.out.println("Total Lines: " + stats.get("lineCount"));
        System.out.println("Total Words: " + stats.get("wordCount"));
        System.out.println("Top 10 Words:");

        printTopWords(stats);
    }

    public void writeReportToFile(Map<String, Object> stats, String outputPath) throws IOException {
        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write("--- File Analysis Report ---\n");
            writer.write("Total Lines: " + stats.get("lineCount") + "\n");
            writer.write("Total Words: " + stats.get("wordCount") + "\n");
            writer.write("Top 10 Words:\n");

            @SuppressWarnings("unchecked")
            Map<String, Integer> wordFreq = (Map<String, Integer>) stats.get("wordFrequency");
            wordFreq.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .limit(10)
                    .forEach(entry -> {
                        try {
                            writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    private void printTopWords(Map<String, Object> stats) {
        @SuppressWarnings("unchecked")
        Map<String, Integer> wordFreq = (Map<String, Integer>) stats.get("wordFrequency");
        wordFreq.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}

