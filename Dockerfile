# STAGE 1: Build the application using Maven
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src
# Compile and package the application, skipping tests for speed
RUN mvn clean package -DskipTests

# STAGE 2: Run the application using a lightweight JRE
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copy the compiled JAR from the build stage
COPY --from=build /app/target/*.jar app.jar
# Expose port 8080 for the Spring Boot application
EXPOSE 8080
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
