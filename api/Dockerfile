FROM openjdk:11.0.4-jre-slim

RUN useradd worker
WORKDIR /app

EXPOSE 8880
ADD ./target/app.jar /app/app.jar

USER worker
ENTRYPOINT ["java","-jar","/app/app.jar"]



