# JDBC Employee Management System

A simple Java application using **JDBC (Java Database Connectivity)** to manage employee and department data in a MySQL database.

## 🚀 Features

- Insert employee and department data into MySQL tables
- Uses JDBC for database connectivity
- Exception handling for SQL errors
- Organized using separate classes like `DBUtil`, `DepartmentInserter`, and `Main`

## 🛠️ Technologies Used

- Java 17+
- JDBC API
- MySQL
- MySQL Connector/J (JAR)

## 🧾 Requirements

- JDK 17 or later
- MySQL Server (running on `localhost:3306`)
- Database: `company`  
- Table: `employees`
- MySQL Connector JAR (`mysql-connector.jar`)

## 📂 Project Structure

JDBC-Employee-Management/
├── JDBC/
│   ├── DBUtil.java
│   ├── DepartmentInserter.java
│   ├── Main.java
│   └── employee.sql
├── mysql-connector.jar
└── README.md

## ⚙️ How to Run

1. Compile:
   javac -cp ".;mysql-connector.jar" JDBC/*.java

2. Run:
   java -cp ".;mysql-connector.jar" JDBC.Main

> Ensure your MySQL database and tables are correctly set up before running.

## 🧠 Author

**Faraz Rahim Khan**  
GitHub: https://github.com/faraz-frk

---

Feel free to modify this file to include more details, screenshots, or usage instructions!
