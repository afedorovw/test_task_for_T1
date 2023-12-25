FROM amazoncorretto:17.0.3-alpine
ARG jarFile=target/test_task_for_T1-1.0.jar
WORKDIR /opt/app
COPY ${jarFile} testT1.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "testT1.jar"]
