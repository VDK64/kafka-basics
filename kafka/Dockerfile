FROM alpine:latest
RUN apk update \
    && apk add curl \
    && apk add openjdk17 \
    && apk add bash

RUN mkdir ./home/kafka
WORKDIR /home/kafka
RUN curl -O https://downloads.apache.org/kafka/3.4.0/kafka_2.12-3.4.0.tgz
RUN tar zxvf kafka_2.12-3.4.0.tgz
RUN rm -f ./kafka_2.12-3.4.0.tgz
RUN mv ./kafka_2.12-3.4.0 ./kafka
WORKDIR /home/kafka/kafka
ENTRYPOINT [ "./bin/kafka-server-start.sh", "./config/server.properties" ]

