# Swaglabs Acceptance Tests

## Description

The framework uses the standard Page Object Model that is a best practice for Selenium UI tests.
Spring for Dependency Injection is used over other Dependency Injection modules as it also allows me to create per environment test configuration files to control test data.
The Webdriver instance is created as a Spring Bean at the start of the test case and terminated at the end. Spring will create a new Bean for each test that runs.

## Prerequisites

- Java 8

## Usage

To run on a Windows machine run the command:

```java
mvn clean test
```

To run on a Mac run the command:

```java
mvn -Ddriver.os=mac clean test
```