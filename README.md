# Brazukas Project - Web Edition

This is a web-based application for managing a soccer team. It provides separate views for a Manager and a Coach to handle player rosters and starting lineups.

## How to Use This Project

### Prerequisites

*   **Java 11:** Ensure you have Java 11 (or later) installed.
*   **Maven:** This project uses Maven for building.

### 1. Building the Project

This is a multi-module Maven project that builds both the backend and frontend. To build the entire application, run the following command from the project's root directory:

```bash
mvn clean install
```

This will produce a single executable JAR file located at `backend/target/backend-1.0-SNAPSHOT.jar`.

### 2. Running the Application

Once the build is complete, you can start the application with this command:

```bash
java -jar backend/target/backend-1.0-SNAPSHOT.jar
```

The web server will start on port `8080`.

### 3. Accessing the Application

Open your web browser and navigate to:

**http://localhost:8080**

You can use the navigation bar to switch between the **Manager** and **Coach** views to manage the team.
