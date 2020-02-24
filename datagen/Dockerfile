FROM maven:3.6-jdk-8-slim AS builder

RUN mkdir -p /opt/datagen;
COPY user_behavior.log /opt/datagen
COPY flink-sql-demo.jar /opt/datagen

WORKDIR /opt/datagen
ENV DATEGEN_HOME /opt/datagen