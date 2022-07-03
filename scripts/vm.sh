#!/bin/bash

# function cd_up() {
#   cd $(printf "%0.s../" $(seq 1 $1 ));
# }
# alias 'cd..'='cd_up'
# (You could define this in ~/.bashrc if you want it in every instance).

cd ..
./mvnw clean package -DskipTests
docker-compose -f docker-compose.vm.yml up -d