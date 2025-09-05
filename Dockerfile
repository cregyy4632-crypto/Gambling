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

# Set environment variable for port (Optional, but good practice)
ENV PORT=8080

# Run the application (MISSING ENTRYPOINT/CMD)
CMD ["sh", "-c", "java -jar target/*.jar --server.port=$PORT"]