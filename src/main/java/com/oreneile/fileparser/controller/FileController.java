package com.oreneile.fileparser.controller;

import com.oreneile.fileparser.service.ParserService;
import com.oreneile.fileparser.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/files")
@Tag(name = "File Upload Controller", description = "Upload and analyze text files")
public class FileController {

    @Autowired
    private ParserService parserService;

    @Autowired
    private ReportService reportService;

    @PostMapping("/upload")
    @Operation(summary = "Upload and analyze a text file")
    public ResponseEntity<Map<String, Object>> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            List<String> lines = new BufferedReader(
                    new InputStreamReader(file.getInputStream())
            ).lines().collect(Collectors.toList());

            Map<String, Object> stats = parserService.analyzeContent(lines);
            reportService.printReport(stats); // optional: log to console
            return ResponseEntity.ok(stats);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Failed to process file: " + e.getMessage()));
        }
    }
}