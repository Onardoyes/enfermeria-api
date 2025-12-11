# FASE 1: BUILD (Compilación)
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
# Descarga dependencias para optimizar el caché de Maven
RUN mvn dependency:go-offline
COPY src ./src
# Compila y empaqueta la aplicación
RUN mvn clean install -DskipTests

# FASE 2: RUN (Ejecución)
# Usa la imagen base de OpenJDK para una imagen final pequeña
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copia el JAR compilado de la fase 'build'
COPY --from=build /app/target/enfermeria-0.0.1-SNAPSHOT.jar app.jar
# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]