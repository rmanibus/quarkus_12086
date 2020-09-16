#!/bin/bash

docker run --name mongo \
--restart always \
-v mongodata:/data/db \
-p 27017:27017 \
-d mongo:4.0