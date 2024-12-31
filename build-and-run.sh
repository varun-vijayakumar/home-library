#!/bin/bash

# Script to build and run Spring Boot app with Maven

# Stop script on any error
set -e

# Clean and package the application
echo "Building the application..."
mvn clean package -DskipTests
#mvn clean install

echo "Running the application..."
mvn spring-boot:run
# Find the jar file (assuming one jar in target directory)
#JAR_FILE=$(ls target/*.jar | head -n 1)

# if [ -f "$JAR_FILE" ]; then
#    echo "Running the application: $JAR_FILE"
#    java -jar "$JAR_FILE"
#else
#    echo "ERROR: Jar file not found in target directory."
#    exit 1
#fi