FROM eclipse-temurin:17
LABEL maintainer="anschaugui"
WORKDIR /app
COPY target/movieFlix-0.0.1-SNAPSHOT.jar /app/aula-docker.jar
ENTRYPOINT ["java", "-jar", "aula-docker.jar"]
