# sentiment-analysis
This repository contains a full-stack web application built with Spring Boot (backend) and React (frontend).

## Prerequisites
Before you begin, ensure you have met the following requirements:
- [Java 21](https://www.oracle.com/java/technologies/downloads/) or higher
- [Maven 3.9.5](https://maven.apache.org/download.cgi) or higher
- [Node.js v20.12.2](https://nodejs.org/en/download/package-manager) or higher
- [Docker](https://www.docker.com/get-started) (if you want to use Docker)

## Getting Started
### Database Configuration
1. **Navigate to the database directory:**
    ```bash
    cd database
    ```
2. **Start the MySQL database:**
    ```bash
    docker-compose up -d
   ```

### Backend (Spring Boot)
1. **Navigate to the backend directory:**
   ```bash
    cd data-service
    ```
2. **Build the project:**

    ```bash
    ./mvnw clean install
    ```

3. **Run the Spring Boot application:**

    ```bash
    ./mvnw spring-boot:run
    ```

   The backend server will start on `http://localhost:8080`.

### Frontend (React)

1. **Navigate to the frontend directory:**

    ```bash
    cd sentiment-analysis
    ```

2. **Install dependencies:**

    ```bash
    npm install
    ```

3. **Start the React application:**

    ```bash
    npm start
    ```

   The frontend application will start on `http://localhost:3000`.

## Running the Application with Docker

### Building backend Docker Images
1. **Navigate to the backend directory:**
   ```bash
    cd data-service
    ```
2. **Build the backend Docker Image:**

    ```bash
    ./mvnw clean compile jib:build
    ```

### Building frontend Docker Images

1. **Navigate to the frontend directory:**

    ```bash
    cd sentiment-analysis
    ```

2. **Build and run the backend image:**

    ```bash
    docker build -t <username>/<image-name> .
    ```

### Pushing Docker Images to Docker Hub

1. **Tag and push the backend image:**

    ```bash
    docker push <username>/<image-name>
    ```

2. **Tag and push the frontend image:**

    ```bash
    docker push <username>/<image-name>
    ```
### Running the Application with Docker Compose
1. **Navigate to the root directory:**
    ```bash
    cd sentiment-analysis-NLP
    ```
2. **Start the application:**

    ```bash
    docker-compose up -d
    ```

    The application will start on `http://localhost`.

## Accessing the Application

- **Backend API**: `http://localhost:8080`
- **Frontend UI**: `http://localhost:3000`

## Additional Information

## License