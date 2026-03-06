# Multi-stage Dockerfile for Spring Boot (Java 23)
# Build stage: uses Maven with Temurin JDK 23 to compile the app
FROM maven:3.9-eclipse-temurin-23 AS build
WORKDIR /workspace

# Copy pom and resolve dependencies first (better layer caching)
COPY pom.xml .
RUN mvn -B -q -DskipTests dependency:go-offline

# Copy the rest of the source and build
COPY src ./src
RUN mvn -B -q -DskipTests package

# Runtime stage: small JRE-only image
FROM eclipse-temurin:23-jre-alpine
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /workspace/target/thinkMaven-0.0.1-SNAPSHOT.jar /app/app.jar

# Spring Boot default HTTP port
EXPOSE 8080

# Allow passing extra JVM flags with JAVA_OPTS
ENV JAVA_OPTS=""

# Start the Spring Boot application
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]
