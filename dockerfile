# Stage 1: Build the JAR file
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy the project files
COPY . .

# Build the application and skip tests
RUN mvn clean package -DskipTests

# Stage 2: Create a lightweight runtime image
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/sb-ecom-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
