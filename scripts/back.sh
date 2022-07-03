#!/bin/bash

cd ..
docker-compose -f docker-compose.dev.yml up -d
./mvnw compile quarkus:dev
