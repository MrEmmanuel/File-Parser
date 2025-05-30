# 📂 File Parser – Spring Boot REST API

**Author:** Oreneile Emmanuel Sejeso  
**Updated:** May 2025  
**Tech Stack:** Java 17, Spring Boot 3, Maven, Swagger UI

---

## 📝 Project Overview

This application allows users to upload plain text files via a REST API and generates simple analytics:
- Total lines
- Total words
- Word frequency
- Top 10 most frequent words

> ✅ Recently updated from a personal project to a professional, Maven-structured Spring Boot application, demonstrating clean code, modular design, RESTful best practices, and testability.

---

## 🚀 Features

- REST API to upload `.txt` files
- Automatic file content analysis
- Console and optional file report logging
- Swagger UI documentation
- JUnit 5 test coverage with `MockMvc`
- Error handling for empty/missing/invalid files

---

## 🧪 Sample Endpoints

### 🔄 Upload a File
```
POST /api/files/upload
Content-Type: multipart/form-data
```

Form field: `file` → upload your `.txt` file

### 📘 Swagger UI

> http://localhost:8080/swagger-ui/index.html

---

## 📊 Sample Output

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

## 📁 Supported Formats

Currently supports:
- `.txt` (plain text)

Planned enhancements:
- `.csv`, `.log`, `.md`

---

## 🧪 Testing

To run all tests:
```bash
mvn test
```

Test coverage includes:
- File parsing logic
- REST API endpoint
- Invalid input (empty or missing file)
- Large file simulation

---

## 🛠 Requirements

- Java 17+
- Maven 3.6+
- Internet for dependency downloads

---

## ▶️ Running the App

```bash
# Clone or unzip project
cd file-parser

# Build and run
mvn clean install
mvn spring-boot:run
```

Then visit: http://localhost:8080/swagger-ui/index.html

---

## 📂 Project Structure

```
src/
├── main/
│   ├── java/com/oreneile/fileparser/
│   │   ├── Main.java
│   │   ├── controller/FileController.java
│   │   └── service/{ParserService, ReportService}.java
│   └── resources/application.properties
├── test/
│   └── java/com/oreneile/fileparser/controller/FileControllerTest.java
```

---

## 🔐 License

This code is submitted exclusively for review by the NWU Centre for Text Technologies. Intellectual Property remains with the author.

---

## 💬 Notes

- This is a personal project originally built 2 years ago and recently modernized for showcase purposes.
- Code from current professional work was not authorized for disclosure.
