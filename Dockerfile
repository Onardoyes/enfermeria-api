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
# Esta línea se mantiene para instalar la herramienta.
RUN apk update && apk add unzip

# Copia el JAR compilado de la fase 'build'
COPY --from=build /app/target/enfermeria-0.0.1-SNAPSHOT.jar app.jar

# *** PASO CRÍTICO DE EXTRACCIÓN DEL CERTIFICADO (Cambio de /tmp a /app) ***
# Extrae el certificado 'root.crt' a la carpeta de trabajo del contenedor (/app).
# El usuario de ejecución de Java tendrá permisos para leer archivos en /app.
RUN unzip -o -j app.jar BOOT-INF/classes/root.crt -d /app

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]