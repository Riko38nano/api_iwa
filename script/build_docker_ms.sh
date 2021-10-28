#!/bin/bash

gradle :build
sudo docker build -t root:1 .

ls

cd ./apiGateway || exit
sudo docker build -t apigateway:1 .
cd ../

cd ./account || exit
sudo docker build -t account:1 .