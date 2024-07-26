#directorio del microservicio
#cd app-authors
#
## Construir la imagen
#docker build -t dave15d/app-authors .
#
#docker login
#docker push dave15d/app-authors

FROM eclipse-temurin:17-jdk-jammy

RUN mkdir /app
WORKDIR /app

COPY build/libs/app-authors-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9090

CMD ["java", "-jar", "app.jar"]