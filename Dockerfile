FROM openjdk:8u121-jdk-alpine AS build-env

WORKDIR /build-env
ADD . /build-env
RUN ./gradlew build

FROM openjdk:8u121-jre-alpine
COPY --from=build-env /build-env/build/libs/card-service.jar /app/card-service.jar

CMD java -jar /app/card-service.jar
