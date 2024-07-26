#directorio del microservicio
#cd app-gateway
#
## Construir la imagen
#docker build -t dave15d/app-gateway .
#
#docker login
#docker push dave15d/app-gateway

FROM eclipse-temurin:17-jdk-jammy

RUN mkdir /app
WORKDIR /app

COPY build/libs/app-gateway-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
