# Stage 1: Build the application
FROM maven:3.9-eclipse-temurin-17 AS build

# Work dir inside container
WORKDIR /app

# Copy Maven config and source code
COPY pom.xml .
COPY src ./src

# Build the Spring Boot jar 
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jre

WORKDIR /app


COPY --from=build /app/target/*.jar app.jar


EXPOSE 8080

# App start command
ENTRYPOINT ["java","-jar","/app/app.jar"]
