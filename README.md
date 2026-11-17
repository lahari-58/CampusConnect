# CampusConnect – Campus Lost and Found Portal

## About the Project
CampusConnect is a web-based Lost and Found portal developed using Java Spring Boot. It helps students report lost and found items on campus and makes it easier to identify and return belongings to their owners.

## Features
- Report lost items.
- Report found items.
- View all reported items.
- Search items by name.
- Mark items as returned.
- Dashboard showing item counts.
- Store records using an H2 database.

## Technologies Used
- **Java 21** – Backend programming.
- **Spring Boot** – Application framework.
- **Spring Data JPA** – Database operations.
- **Thymeleaf, HTML and CSS** – User interface.
- **H2 Database** – Data storage.
- **Maven** – Project build management.
- **Git and GitHub** – Version control and source code hosting.
- **Docker** – Application containerization.
- **GitHub Actions** – Automated Docker image building and publishing.
- **GitHub Container Registry (GHCR)** – Docker image hosting.

## Run Locally

### Prerequisites
- Java 21
- Maven

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/lahari-58/CampusConnect.git
   ```

2. Open the project folder:
   ```bash
   cd CampusConnect
   ```

3. Start the application:
   ```bash
   mvn spring-boot:run
   ```

4. Open the browser:
   ```text
   http://localhost:8080
   ```

## Run Using Docker

Pull the published Docker image:

```bash
docker pull ghcr.io/lahari-58/campusconnect:latest
```

Run the application:

```bash
docker run -d --name campusconnect -p 8080:8080 -v campusconnect-data:/app/data ghcr.io/lahari-58/campusconnect:latest
```

Open:

```text
http://localhost:8080
```

## Docker Image
**GHCR Image:** `ghcr.io/lahari-58/campusconnect:latest`

## GitHub Repository
https://github.com/lahari-58/CampusConnect

## Developed By
Lahari M

**Project:** CampusConnect – Campus Lost and Found Portal