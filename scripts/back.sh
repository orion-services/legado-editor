#!/bin/bash

# function cd_up() {
#   cd $(printf "%0.s../" $(seq 1 $1 ));
# }
# alias 'cd..'='cd_up'
# (You could define this in ~/.bashrc if you want it in every instance).

cd ..
cd src/main/docker
docker-compose up -d
cd ../../..
./mvnw compile quarkus:dev