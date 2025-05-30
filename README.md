# 📂 File Parser – Spring Boot REST API

**Author:** Oreneile Emmanuel Sejeso  
**Updated:** May 2025  
**Tech Stack:** Java 17, Spring Boot 3, Maven, Swagger UI

---

## 📝 Project Overview

This application allows users to upload text-based files via a REST API and performs basic content analysis:
- Total number of lines
- Total number of words
- Word frequency breakdown
- Top 10 most frequent words

It demonstrates clean Spring Boot architecture, Maven-based project structure, and RESTful design best practices.

---

## 🚀 Features

- REST API to upload text files
- File content analysis: line count, word count, word frequency
- Swagger UI documentation for interactive testing
- Console and file-based reporting (optional)
- Comprehensive unit tests for service and controller
- Error handling for invalid, empty, or missing files

---

## 📂 Supported File Formats

The current implementation supports the following plain-text formats:
- `.txt` – standard plain text files
- `.csv` – comma-separated value files (processed as raw text)
- `.log` – typical log file structure
- `.md` – markdown files

Files are treated as **text streams**. The parser does not currently interpret format-specific structure (e.g., CSV columns).

---

## 📘 Swagger UI

After starting the app, open:
```
http://localhost:8080/swagger-ui/index.html
```

Use the **`/api/files/upload`** endpoint to upload and analyze a file.

---

## 🧪 Sample Response

```json
{
  "lineCount": 12,
  "wordCount": 96,
  "wordFrequency": {
    "data": 11,
    "file": 9,
    "parser": 6
  }
}
```

---

## ▶️ How to Run

### Prerequisites

- Java 17+
- Maven 3.6+
- Internet connection (for dependency resolution)

### Steps

```bash
# 1. Clone or unzip the project
cd file-parser

# 2. Build the application
mvn clean install

# 3. Run the Spring Boot application
mvn spring-boot:run
```

Open [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) to access the API interface.

---

## 🧪 Running Tests

To run unit and integration tests:

```bash
mvn test
```

Test coverage includes:
- File parsing logic via `ParserServiceTest`
- REST controller upload functionality via `FileControllerTest`
- Edge cases: large files, empty files, no file upload

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/oreneile/fileparser/
│   │   ├── Main.java
│   │   ├── controller/FileController.java
│   │   └── service/
│   │       ├── ParserService.java
│   │       └── ReportService.java
│   └── resources/application.properties
├── test/
│   └── java/com/oreneile/fileparser/
│       ├── ParserServiceTest.java
│       └── controller/FileControllerTest.java
pom.xml
README.md
```

---

## 🔐 License

This project is open for educational and demonstration purposes.  
All rights reserved by the author unless stated otherwise.

