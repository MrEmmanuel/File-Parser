package com.oreneile.fileparser.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileReaderService {
    public List<String> readLines(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}

