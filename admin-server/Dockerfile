#directorio del microservicio
#cd admin-server
#
## Construir la imagen
#docker build -t dave15d/admin-server .
#
#docker login
#docker push dave15d/admin-server

FROM eclipse-temurin:17-jdk-jammy

RUN mkdir /app
WORKDIR /app

COPY build/libs/admin-server-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]
