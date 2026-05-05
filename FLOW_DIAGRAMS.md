# 📊 Automation Flow Diagrams

This document visualizes the internal logic and execution flow of the **Nishad IT Solutions** framework.

---

## 🖥️ 1. UI Automation Flow (Selenium + BDD)
This diagram shows how a Gherkin scenario translates into browser actions.

```mermaid
graph TD
    A[Feature File - .feature] -->|1. Reads Steps| B(Step Definitions - Java Methods)
    B -->|2. Calls Page Methods| C{Page Object Model - HomePage.java}
    C -->|3. Finds Locators| D[Browser Driver - Selenium WebDriver]
    D -->|4. Action| E[Web Browser - Chrome/Firefox]
    E -->|5. Result| D
    D -->|6. Assertion| B
    B -->|7. Success/Failure| F[Cucumber Report]
    
    subgraph Initialization
    G[Hooks - @Before] -->|Setup Browser| D
    H[Hooks - @After] -->|Close Browser| D
    end
```

---

## 📡 2. API Automation Flow (Rest Assured + BDD)
This diagram shows the direct communication between the script and the server.

```mermaid
graph LR
    A[Feature File - .feature] -->|1. Triggers| B(Step Definitions - Rest Assured Logic)
    B -->|2. Given: Set URI| C{Request Specification}
    C -->|3. When: GET/POST| D[REST API Server - jsonplaceholder.typicode.com]
    D -->|4. HTTP Response| E{Response Object}
    E -->|5. Then: Validate Status| B
    E -->|6. Then: Parse JSON| B
    B -->|7. Final Verdict| F[TestNG/Cucumber Results]
```

---

## 🏗️ 3. The Hybrid Framework Architecture
The overall structure of how our components interact.

```mermaid
flowchart TB
    subgraph Test_Layer
        TR[TestRunner]
        TC[TestNG Classes]
    end

    subgraph Logic_Layer
        SD[Step Definitions]
        PO[Page Objects]
    end

    subgraph Core_Layer
        DM[DriverManager]
        CR[ConfigReader]
        UT[Utils]
    end

    subgraph External
        BW[Browser]
        SV[API Server]
    end

    TR --> SD
    TC --> PO
    SD --> PO
    PO --> DM
    DM --> BW
    SD --> SV
    PO -.-> CR
    Core_Layer -.-> Logic_Layer
```

### 🔑 Architecture Legend

| Abbreviation | Long Form | Description |
| :--- | :--- | :--- |
| **TR** | **TestRunner** | The engine that triggers Cucumber feature files. |
| **TC** | **TestNG Classes** | Standard Java test classes using TestNG annotations. |
| **SD** | **Step Definitions** | The bridge between Gherkin steps and Java logic. |
| **PO** | **Page Objects** | Classes representing web pages and their actions. |
| **DM** | **DriverManager** | Handles the lifecycle of the Selenium WebDriver. |
| **CR** | **ConfigReader** | Reads environment settings from `config.properties`. |
| **UT** | **Utils** | Reusable helper methods (logs, screenshots, waits). |
| **BW** | **Browser** | The target UI (Chrome, Firefox, Edge). |
| **SV** | **API Server** | The target REST API endpoint. |
