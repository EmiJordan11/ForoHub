# Construcción
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Ejecución
FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
COPY --from=build /app/target/foro_hub-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
