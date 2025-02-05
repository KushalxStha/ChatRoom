# Use the official Maven image to build the JAR file
FROM eclipse-temurin:17-jdk-alpine as builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files into the container
COPY . .

# Build the project using Maven
RUN ./mvnw clean package -DskipTests

# Use a lightweight JDK image to run the application
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/ChatRoom-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that Spring Boot is running on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]