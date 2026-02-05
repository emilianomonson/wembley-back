# Paso 1: Compilar
FROM maven:3.8.4-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests -Dmaven.resources.filtering=false

# Paso 2: Correr (Usamos Amazon Corretto 17, que es más confiable)
FROM amazoncorretto:17-alpine-jdk
COPY --from=build /target/utileria-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]