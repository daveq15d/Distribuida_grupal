#directorio del microservicio
#cd app-book
#
## Construir la imagen
#docker build -t dave15d/app-book .
#
#docker login
#docker push dave15d/app-book

FROM eclipse-temurin:17-jdk-jammy

RUN mkdir /app
WORKDIR /app

COPY build/libs/app-book-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8090

CMD ["java", "-jar", "app.jar"]
