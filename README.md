# 📁 File Parser – Spring Boot & Maven Project

**Author:** Oreneile Emmanuel Sejeso  
**Version:** 1.0-SNAPSHOT  
**Language:** Java 17  
**Framework:** Spring Boot  
**Build Tool:** Maven

---

## 🧠 Project Overview

The File Parser is a Spring Boot-based Java application that reads text files, analyzes their contents, and generates detailed reports on word usage. Originally a personal console utility built two years ago, this project has been modernized with Spring Boot, Maven, modular service architecture, and test coverage to demonstrate professional-level development practices.

It is intended as a showcase for roles involving backend development, data/text analysis, or application engineering.

---

## ✨ Features

- ✅ Reads `.txt` files from a file path
- ✅ Parses line and word counts
- ✅ Calculates word frequency (case-insensitive, punctuation removed)
- ✅ Prints summary to console
- ✅ Writes report to an `.out` file
- ✅ Spring Boot-based structure
- ✅ Includes unit test for core logic
- ✅ Maven-enabled build and test process
- ✅ REST API for file upload and analysis

---

## 📂 Supported File Formats

- Plain text files (`.txt`)
- Log files (`.log`)
- CSV files (`.csv`) — reads as plain text; no structured CSV parsing yet

> ⚠️ Note: All files are treated as line-based plain text. Special formatting (like CSV columns) is not interpreted.

---

## 🛠 Technologies Used

- Java 17
- Spring Boot 3+
- Maven
- JUnit 5
- SLF4J (Logging placeholder)
- IntelliJ IDEA / VS Code

---

## 📂 Project Structure

```
file-parser/
├── src/
│   ├── main/
│   │   └── java/com/oreneile/fileparser/
│   │       ├── Main.java                # Spring Boot entry point
│   │       └── service/
│   │           ├── FileReaderService.java
│   │           ├── ParserService.java
│   │           └── ReportService.java
│   │       └── controller/
│   │           └── FileController.java  # REST API for file uploads
│   └── test/java/com/oreneile/fileparser/
│       └── ParserServiceTest.java       # Unit test
├── pom.xml                              # Maven build configuration
└── README.md                            # Project documentation
```

---

## 🚀 How to Build and Run

### ✅ Prerequisites

- Java 17+
- Maven 3.8+

### 💻 Run via Command Line

1. **Build the project**
```bash
mvn clean package
```

2. **Run the application (CLI Mode)**
```bash
java -jar target/file-parser-1.0-SNAPSHOT.jar path/to/your/textfile.txt
```

3. **Run the application (API Mode)**
```bash
mvn spring-boot:run
```
Access API at: `http://localhost:8080/api/files/upload`

4. **Output**
- Console: displays line/word count and top 10 most frequent words
- File: writes to `yourfile.txt.out`

### 🔍 Sample Output
```
--- File Analysis Report ---
Total Lines: 3
Total Words: 17
Top 10 Words:
this: 2
is: 2
a: 2
hello: 2
file: 1
parser: 1
java: 1
great: 1
again: 1
test: 1
```

---

## 🧪 Run Unit Tests

```bash
mvn test
```

Unit tests verify core parsing logic, including line/word counting and frequency map.

---

## 🌱 Ideas for Future Enhancements

- NLP integration (stopword removal, stemming)
- Web dashboard using Thymeleaf or React
- Database integration with Spring Data JPA
- Role-based access control (Spring Security)
- Swagger/OpenAPI documentation

---

## 📃 License

This code is provided for review and demonstration only. All rights reserved by the author.

---

## 📬 Contact

**Oreneile Emmanuel Sejeso**  
✉️ sejeso.oreneile@gmail.com  
🔗 GitHub: [github.com/MrEmmanuel](https://github.com/MrEmmanuel)
