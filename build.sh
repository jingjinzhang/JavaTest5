#!/bin/bash

mvn clean package

mv Exam1/target/Exam.jar docker/java/

docker-compose build
