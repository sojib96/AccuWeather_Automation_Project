# AccuWeather_Automation_Project

This is a UI automation project that automates the user interface (UI) of AccuWeather. It includes test cases to verify key functionalities like using the current location label, recent location searches, and city search for weather updates. The project employs data-driven testing for multiple city search scenarios. Docker and Jenkins are utilized for containerization and Continuous Integration (CI), streamlining the testing process and ensuring consistency across environments.

## Table of Contents

- [Features](#features)
- [Test Case](#test-case)
    - [Current Location Label Test](#current-location-label-test)
    - [Recent Locations Test](#recent-locations-test)
    - [Search City Test](#search-city-test)
- [Libraries and Technologies Used](#libraries-and-technologies-used)
- [Project Setup](#project-setup)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Running the Tests Locally](#running-the-tests-locally)
    - [Generating the Allure Report](#generating-the-allure-report)
    - [Running Tests in Docker](#running-tests-in-docker)
- [Conclusion](#conclusion)


## Features

- **UI Automation**: Automates interactions with the AccuWeather UI to perform actions like using the current location, searching for cities, and viewing weather details, ensuring the expected behavior at each step.
- **Data-Driven Testing**: Utilizes different city names in scenarios to validate the functionality of city searches and recent location features with varying inputs.
- **Containerization**: The project is containerized using Docker to provide a consistent environment for testing across different systems.
- **Continuous Integration (CI)**: Automated tests are integrated with Jenkins, enabling continuous testing and seamless integration into the development pipeline.

## Test Case:

#### Test Case Name: **Current Location Label Test**

1. **Step**: Accept Data Usage Consent
    - **Action**: The user accepts the consent.

2. **Step**: Click Search Field
    - **Action**: Locate and click on the search field on the main page.
    - **Expectation**: The "Use your current location" label is visible on the UI.

    
#### Test Case Name: **Recent Locations Test**

1. **Step**: Accept Data Usage Consent
    - **Action**: The user accepts the consent.

2. **Step**: Input City and Display Search Results
    - **Action**: In the search box, input a city name (e.g., "New York").
    - **Expectation**: The search results list is displayed.

3. **Step**: Click First Search Result
    - **Action**: Click on the first search result from the list.

4. **Step**: Go Back to Main Page
    - **Action**: Go back to the main page.

5. **Step**: Select First City from Recent Locations
    - **Action**: From the "Recent Locations" section, select the first city.
    - **Expectation**: The weather page header contains the correct city name.

    
#### Test Case Name: **Search City Test**

1. **Step**: Accept Data Usage Consent
    - **Action**: The user accepts the consent.

2. **Step**: Input City and Display Search Results
    - **Action**: In the search box, input a city name (e.g., "New York").
    - **Expectation**: The search results list is displayed.

3. **Step**: Click First Search Result
    - **Action**: Click on the first search result from the list.
    - **Expectation**: The header contains the correct city name.

## Libraries and Technologies Used

- **Selenium WebDriver**: For automating browser actions and UI interactions on the AccuWeather platform, ensuring smooth navigation and user interaction testing.
- **Aquality Automation Framework**: Used for creating and managing UI automation tests in a structured manner. It integrates well with Selenium WebDriver for efficient test execution.
- **Maven**: Manages project dependencies, builds the project, and handles the lifecycle of tests. It also ensures proper versioning and dependency management for tools used.
- **TestNG**: Organizes tests, provides annotations, and structures the test suite. It's used for executing the test scenarios defined in the feature files, ensuring systematic test execution.
- **Cucumber**: Provides a behavior-driven development (BDD) approach for writing tests in Gherkin syntax. It integrates with TestNG, allowing for clear and readable test scenarios that align with business requirements.
- **Gherkin**: A language used for defining test scenarios in Cucumber. It enables writing tests in a natural language format, ensuring that test cases are easy to understand by both technical and non-technical stakeholders.
- **Data-Driven Testing (DDT)**: Implemented using Cucumber scenarios with multiple examples, enabling the execution of the same test with different data inputs, such as different cities for search and location functionality.
- **Gson**: For serializing Java objects to JSON format and deserializing JSON responses, helping with managing data used in tests, especially for API-based validations.
- **Lombok**: Used for reducing boilerplate code such as getters, setters, and constructors, mainly in model classes related to city searches and recent location features.
- **Allure**: For generating detailed and interactive test reports. It provides insights into test execution, including logs and results, helping track the status of each test case.
- **Docker**: Ensures that the project is containerized for consistent environments, allowing seamless test execution across different machines and systems.
- **Jenkins**: Automates the test execution process by integrating tests into a Continuous Integration (CI) pipeline. It triggers test execution on every code change, ensuring consistent quality checks.
- **AspectJ**: Used in combination with Selenium and Maven for handling aspect-oriented programming tasks, such as logging and performance monitoring, without cluttering the core test logic.


## Project Setup

### Prerequisites

1. **Java**: Ensure that Java is installed on your system.
2. **Maven**: For managing project dependencies and building the project.
3. **Allure**: Install Allure Commandline to generate detailed and interactive test reports.
4. **Cucumber & Gherkin**: Ensure that Cucumber and Gherkin are set up to write and execute BDD-based test scenarios.
5. **Docker**: Install Docker to containerize the project and run tests in a consistent and controlled environment.
6. **Jenkins**: A Jenkins server to trigger automated test runs as part of the Continuous Integration (CI) pipeline.
7. **IDE (Optional)**: An Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse for development and managing project files.

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/sojib96/AccuWeather_Automation_Project.git
    cd Wikipedia_Mini_Project
    ```

2. Open the project in your preferred IDE.



### Running the Tests Locally

1. Clean the projects using Maven:

    ```bash
    mvn clean
    ```

2. Run the test using Maven:

    ```bash
    mvn test -DisRemote=false
   ```

### Generating the Allure Report

#### For Temporary Viewing (This will generate and open the Allure report in your browser for quick viewing)
1. Navigate to the `target` directory:
    ```bash
    cd target
    ```

2. Serve the Allure report temporarily:
    ```bash
    allure serve
    ```

#### For Sharing with Others (This will create a html file for viewing and sharing)
1. Generate the Allure report as a single file:
    ```bash
    allure generate target/allure-results --single-file
    ```

2. Open the generated report:
    ```bash
    allure open
    ```

### Running Tests in Docker

1. Pull the Chrome Docker Image 

    ```bash
    docker pull selenium/standalone-chrome
    ```
   
2. Run the Docker Container with Chrome Image

    ```bash
    docker run -d --name selenium-chrome -p 4444:4444 selenium/standalone-chrome 
    ```
   
3. Build the Docker image with the following command:

    ```bash
    docker build -t accuweather .
    ```

4. Run the container in interactive mode, mapping port 9090 (or another port of your choice):

    ```bash
    docker run -it --rm --name project-container --link selenium-chrome:selenium-chrome -p 9090:9090 accuweather bash
    ```

5. This above command will open a Bash shell inside the Docker container. Once inside the container, clean and run the tests using Maven:

    ```bash
    mvn clean test
    ```

6. After the tests have completed, navigate to the `target` directory:

    ```bash
    cd target
    ```
   Then, serve the Allure report:

    ```bash
    allure serve --port 9090
    ```

7. Open `http://localhost:9090` in your web browser to view the Allure report.

## Conclusion

This project automates UI testing for the AccuWeather application using Selenium WebDriver, Cucumber with Gherkin, and Allure for reporting. It leverages Docker for consistent test environments and Data-Driven Testing for flexibility, ensuring reliable test execution and detailed reporting.
   
