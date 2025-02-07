# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container at /app
COPY target/springboot-tierlist-app-0.0.1-SNAPSHOT.jar /app/springboot-tierlist-app.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 8080

# Specify the command to run on container startup
CMD ["java", "-jar", "springboot-tierlist-app.jar"]
