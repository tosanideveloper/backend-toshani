# Start with a base image containing Java runtime
FROM adoptopenjdk/openjdk11

# Add Maintainer Info
LABEL maintainer="lakshman@socialtalentagency.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8004 available to the world outside this container
EXPOSE 8004

# The application's jar file
ARG JAR_FILE=target/notification-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} notification.jar

# Run the jar file 
ENTRYPOINT ["java","-Dspring.profiles.active=${ENV}","-jar","/notification.jar"]
