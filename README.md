# Summer Internship EPAM
## Meetup Data-Stream
This application downloads meeting information from www.meetup.com and transfers them to the Apache Kafka topic.
> To change the target topic, retention.ms and address Apache Kafka, change the variables in the application.properties.
## Apache Kafka in Docker
> Version: 0.10

In this project, Kafka will be launched through the docker, the container configuration file is located in the *DockerKafka* folder.
To initially create and run containers, use the command in a folder with *.yml* file:
```sh
docker-compose up -d
```
To turn containers off and on, use the commands:
```sh
docker-compose stop
docker-compose start
```
Removing containers:
```sh
docker-compose down
```
To run Docker on the Windows operating system, you can use the following utility:
> https://docs.docker.com/toolbox/toolbox_install_windows/

If you use this, in order to go to the Kafka manager page, specify not the localhost, but the IP specified in the Docker Quickstart Terminal.
It is also necessary to make an entry in the hosts file with this IP of the following form:
```sh
*IP* kafkaserver
```
## Apache Spark in Docker
> Version 2.2.1 (Scala - 2.11.3)

Spark will be launched with Kafka in a docker.
For start Spark application use the follow command (for example):
```sh
./bin/spark-submit --packages org.apache.spark:spark-sql-kafka-0-10_2.11:2.2.1 --class sample.SparkJob --master spark://spark-master:7077 /tmp/sample.jar
```
