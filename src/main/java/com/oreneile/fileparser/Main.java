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
public class Main implements CommandLineRunner {

	@Autowired
	private FileReaderService fileReaderService;

	@Autowired
	private ParserService parserService;

	@Autowired
	private ReportService reportService;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length == 0) {
			System.out.println("Usage: java -jar file-parser.jar <file_path>");
			return;
		}

		String filePath = args[0];
		List<String> lines = fileReaderService.readLines(filePath);
		Map<String, Object> stats = parserService.analyzeContent(lines);
		reportService.printReport(stats);
		reportService.writeReportToFile(stats, "analysis_report.txt");
	}
}
