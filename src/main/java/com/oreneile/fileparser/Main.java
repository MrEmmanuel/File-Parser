package com.oreneile.fileparser;

import com.oreneile.fileparser.service.FileReaderService;
import com.oreneile.fileparser.service.ParserService;
import com.oreneile.fileparser.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;

/*
 * File Parser Project - Spring Boot & Maven Structure
 * Author: Oreneile Emmanuel Sejeso
 */

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}