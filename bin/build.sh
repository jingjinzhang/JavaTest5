#!/bin/bash

mvn clean package

mv Exam1/target/Exam1.jar docker/java/

docker-compose build
