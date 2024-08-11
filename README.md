

# Selenium BDD Java Project

## Project Overview
This project is a test automation framework built using **Selenium** for browser automation and **Cucumber** for Behavior-Driven Development (BDD). The framework is designed to execute UI tests in parallel across multiple browsers, including Chrome and Firefox, and is based on the Page Object Model (POM) design pattern.

## Features
- **Cross-Browser Testing:** Supports Chrome and Firefox browsers.
- **BDD with Cucumber:** Write test scenarios in Gherkin language for better readability and collaboration.
- **Parallel Execution:** Run tests concurrently to reduce execution time.
- **Page Object Model:** Maintainable and scalable test automation with POM design.
- **Data-Driven Testing:** Easily manage test data using external files like Excel or JSON.
- **Configuration Management:** Centralized configuration using properties files for better flexibility.

## Project Structure
- **src/test/java:** Contains the Page Object classes and utility classes, the step definitions, hooks, and test runners.
- **src/test/resources:** Contains the feature files written in Gherkin, and the configuration properties files.
- **target:** Stores the compiled test results, logs, and other artifacts generated during test execution.
