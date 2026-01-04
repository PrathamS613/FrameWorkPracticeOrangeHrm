# FrameWorkPracticeOrangeHrm
Selenium Hybrid Automation Orange HRM FrameWork 
# 🚀 Selenium Hybrid Automation Framework

This repository contains a **Hybrid Automation Framework** built using **Selenium WebDriver**, **TestNG**, **Page Object Model (POM)**, and **Data-Driven Testing**.
It integrates **properties files**, **Excel-based test data**, and **modular reusable components** to create a scalable automation solution.

---

## 📌 Features

### 🔹 **1. Page Object Model (POM)**

* Separates UI actions & locators
* Improves readability and reusability
* Reduces code duplication

### 🔹 **2. Data-Driven Framework**

* Test data stored in **Excel files**
* Utility functions for reading data from **Excel (Apache POI)**
* Easy to update/add multiple test scenarios

### 🔹 **3. Hybrid Framework**

* Combines **POM + Data Driven + TestNG**
* Supports **parameterization**, **parallel execution**, and **cross-browser testing**
* Handles validations, reports, logs, and reusable helper functions

### 🔹 **4. TestNG Integration**

* Supports annotations (`@Test`, `@BeforeClass`, `@DataProvider`, etc.)
* Generates HTML reports
* Enables grouping and priority handling
* Parallel test execution using `testng.xml`

### 🔹 **5. Properties File Support**

* Centralized configuration in `config.properties`
* Stores: URLs, browser type, timeout values, credentials, etc.
* Reduces hard-coding in test scripts

### 🔹 **6. Utility Components**

* WebDriver Manager integration
* Excel Reader
* Screenshot Utility
* Logger Utility
* Wait Helpers
* Browser Factory

---

## 📁 **Project Structure**

```
📦 HybridAutomationFramework
 ┣ 📂 src/main/java
 │  ┣ 📂 base
 │  ┣ 📂 pages
 │  ┣ 📂 utilities
 │  ┣ 📂 config
 ┣ 📂 src/test/java
 │  ┣ 📂 testCases
 │  ┣ 📂 dataProviders
 ┣ 📂 testData
 │  ┗ TestData.xlsx
 ┣ 📄 testng.xml
 ┣ 📄 pom.xml
 ┣ 📄 config.properties
 ┗ 📄 README.md
```

---

## 🛠️ **Tools & Technologies**

| Tool                        | Purpose                              |
| --------------------------- | ------------------------------------ |
| **Java**                    | Programming language                 |
| **Selenium WebDriver**      | Browser automation                   |
| **TestNG**                  | Test execution + Reporting           |
| **Apache POI**              | Excel data reading                   |
| **Maven**                   | Dependency management                |
| **POM (Page Object Model)** | Test structure design                |
| **Hybrid Framework**        | Combines multiple testing approaches |
| **Properties Files**        | Configuration management             |

---

## ▶️ **How to Run the Tests**

### **1️⃣ Clone the project**

```bash
git clone https://github.com/your-username/your-repository.git
```

### **2️⃣ Install Maven dependencies**

```bash
mvn clean install
```

### **3️⃣ Execute Test Suite**

```bash
mvn test
```

or directly from:

```
testng.xml
```

---

## 📊 Reporting

* TestNG Default HTML Reports
* Screenshots for failed tests
* Log files if logging is enabled



Let me know if you want me to:
✔ Add badges (Java, Selenium, Maven, TestNG)
✔ Add GIF/screenshots of your framework
✔ Generate a professional LinkedIn description for this project
✔ Improve folder structure diagram
