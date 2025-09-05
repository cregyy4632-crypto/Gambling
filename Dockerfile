# Use the official OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Copy the Maven wrapper and project definition file
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Make the mvnw script executable
RUN chmod +x mvnw

# Copy the full source code
COPY src ./src

# Build the application, creating an executable JAR
RUN ./mvnw clean package -DskipTests

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "target/your-application.jar"]