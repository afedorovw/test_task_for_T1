FROM amazoncorretto:17.0.3-alpine
ARG jarFile=target/*.jar
WORKDIR /opt/app
COPY ${jarFile} testT1.jar
ENV SERVER_PORT=8081
CMD java -jar -Dserver.port=${SERVER_PORT} /opt/app/testT1.jar