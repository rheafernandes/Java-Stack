FROM openjdk:10-jdk

ADD /target/movie-service-0.0.1-SNAPSHOT.jar /dockerfs/app/movie-service-0.0.1-SNAPSHOT.jar
WORKDIR /dockerfs/app
ENTRYPOINT ["java","-jar","movie-service-0.0.1-SNAPSHOT.jar"]