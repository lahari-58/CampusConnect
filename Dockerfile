
# Stage 1: Build the CampusConnect application
# Maven is used to compile the Java application.
FROM maven:3.9-eclipse-temurin-21 AS build

# Set the working directory inside the container.
WORKDIR /app

# Copy the Maven project configuration.
COPY pom.xml .

# Copy the application's source code.
COPY src ./src

# Build the Spring Boot executable JAR file.
RUN mvn -B clean package -DskipTests

# Stage 2: Run the application
# Use a smaller Java runtime image.
FROM eclipse-temurin:21-jre

# Set the working directory.
WORKDIR /app

# Copy the generated JAR from the build stage.
COPY --from=build /app/target/*.jar app.jar

# Create a directory for the H2 database files.
RUN mkdir -p /app/data

# Keep the database directory available for persistent storage.
VOLUME ["/app/data"]

# Application uses port 8080.
EXPOSE 8080

# Start the CampusConnect application.
ENTRYPOINT ["java", "-jar", "app.jar"]
