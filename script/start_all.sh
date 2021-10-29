#!/bin/bash

sudo docker run -p 8080:8080 root:1
sudo docker run -p 8081:8080 account:1
sudo docker run -p 9090:8080 apigateway:1

exit