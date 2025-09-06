# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Copy the project definition file
COPY pom.xml ./

# Copy the full source code
COPY src ./src

# Build the application, creating an executable JAR
RUN mvn clean package -DskipTests

# Expose the port the app runs on
EXPOSE 8080

# Set environment variable for port
ENV PORT=8080

# Run the application
ENTRYPOINT ["java", "-jar", "target/gambling-0.0.1-SNAPSHOT.jar"]
CMD ["--server.port=8080"]