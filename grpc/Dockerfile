FROM openjdk:11.0.4-jre-slim

RUN useradd worker
WORKDIR /app

EXPOSE 8885
ADD ./target/grpc-0.0.1-SNAPSHOT.jar /app/app.jar

USER worker
ENTRYPOINT ["java","-jar","/app/app.jar"]



