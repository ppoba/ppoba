#FROM openjdk:11-jdk
#LABEL maintainer="ppoba-backend"
#
#RUN echo "why why why1"
#ARG JAR_FILE=./build/libs/ppoba-0.0.1-SNAPSHOT.jar
#ADD ${JAR_FILE} ppoba.jar
#RUN echo "why why why2"
#
#ENTRYPOINT ["java", "-jar", "/ppoba.jar"]


#FROM amazoncorretto:11
#LABEL maintainer="ppoba-backend"
#ARG JAR_FILE_PATH=./build/libs/ppoba-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE_PATH} ppoba.jar
#ENTRYPOINT ["java", "-Dspring.profiles.active=test", "-jar", "ppoba.jar"]
#EXPOSE 9990
#CMD ["java", "-jar", "ppoba.jar"]

FROM amazoncorretto:11
ARG JAR_FILE=./build/libs/ppoba-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ppoba.jar
#ENTRYPOINT ["java","-jar","ppoba.jar"]
ENTRYPOINT ["java", "-Dspring.profiles.active=test", "-jar", "ppoba.jar"]