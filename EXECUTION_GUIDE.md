# 🚀 Automation Execution Guide

This guide contains the essential commands to execute tests in the **Nishad IT Solutions Hybrid Framework**.

---

## 🛠️ Maven Commands (Terminal)

### 1. Run All Tests
Executes everything defined in `testng.xml` (Both BDD and TestNG).
```powershell
mvn clean test
```

### 2. Run ONLY Cucumber BDD Tests
Targets only the `TestRunner` class.
```powershell
mvn test "-Dtest=TestRunner"
```

### 3. Run ONLY Standard TestNG Tests
Targets a specific TestNG class (e.g., `HomeTest`).
```powershell
mvn test "-Dtest=HomeTest"
```

### 4. Run Tests by Cucumber Tags
Filters execution to only scenarios with a specific tag.
*   **Run ONLY UI Tests**: `mvn test "-Dcucumber.filter.tags=@UI"`
*   **Run ONLY API Tests**: `mvn test "-Dcucumber.filter.tags=@API"`

### 5. Run a Specific API Test (TestNG)
Targets only the API test class.
```powershell
mvn test "-Dtest=PostApiTest"
```

---

## 💡 PowerShell Syntax Tips
When running commands in PowerShell (VS Code Terminal), always follow these rules to avoid errors:
*   **Use Double Quotes**: Wrap parameters that contain dots or special characters in double quotes: `"-Dtest=TestRunner"`.
*   **Case Sensitivity**: Class names (like `TestRunner`) must exactly match the Java file name.

---

## 🖱️ IDE Execution (Right-Click)

### TestNG Suite
1.  Navigate to `src/test/resources/testng.xml`.
2.  Right-click the file -> **Run TestNG Suite**.

### Cucumber Runner
1.  Navigate to `src/test/java/com/nishad/runners/TestRunner.java`.
2.  Right-click -> **Run Test** (or click the Play icon in the gutter).

---

## 📊 Viewing Reports
After execution, you can find the results here:
*   **Cucumber HTML Report**: `target/cucumber-reports/cucumber.html`
*   **TestNG Reports**: `target/surefire-reports/index.html`
