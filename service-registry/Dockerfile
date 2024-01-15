FROM eclipse-temurin:17

LABEL mentainer="aj91063@gmail.com"

WORKDIR /app

COPY target/service-registry-0.0.1-SNAPSHOT.jar /app/service-registery.jar

ENTRYPOINT ["java", "-jar", "service-registery.jar"]