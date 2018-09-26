# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="rupesh.deshmukh@atos.net"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/wlodc-techhub-web-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Set the environment variables.
ENV MYSQL_JDBC_URL="jdbc:mysql://localhost:3306/wlodc_techhub"
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=root

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]