# FASE 1: BUILD (Compilación)
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
# Descarga dependencias para optimizar el caché de Maven
RUN mvn dependency:go-offline
COPY src ./src
# Compila y empaqueta la aplicación
RUN mvn clean install -DskipTests

# ----------------------------------------------------------------------
# FASE 2: RUN (Ejecución) - CAMBIOS APLICADOS AQUÍ
# ----------------------------------------------------------------------
# Usa la imagen base de OpenJDK para una imagen final pequeña
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Instalar 'unzip': Necesario en Alpine para extraer archivos del JAR.
RUN apk update && apk add unzip

# Copia el JAR compilado de la fase 'build'
COPY --from=build /app/target/enfermeria-0.0.1-SNAPSHOT.jar app.jar

# *** PASO CRÍTICO DE EXTRACCIÓN DEL CERTIFICADO ***
# El archivo 'root.crt' fue empaquetado por Spring Boot dentro del JAR en la ruta BOOT-INF/classes/root.crt.
# Usamos unzip (-o: sobrescribe; -j: ignora la estructura de directorios interna) para extraerlo a /tmp/,
# una ruta estándar y limpia en el sistema de archivos del contenedor.
RUN unzip -o -j app.jar BOOT-INF/classes/root.crt -d /tmp

# Ejecuta la aplicación
# El comando de inicio es simple, ya que la extracción se hizo en la etapa RUN
ENTRYPOINT ["java", "-jar", "app.jar"]