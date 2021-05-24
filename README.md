# payment-module
This is having two modules. One service is for creating a payment and another service is for executing the payment. Kafka server being used to communicate micro services asynchronously.

Below are two micro services. Developed using SPring-boot framework
--------------------------------------------------------------------
payment-create - This service is responisble for creating the payment
payment-executor - This service is responsible for executing the payment
Email-Service - Sending notification messages

Kafka Server to send messages from payment-create service to payment-executor service by asynchronously
--------------------------------------------------------------------------------------------------------

1) Donwload the Kafka by using wget 2.12

sudo wget "sudo wget "https://apachemirror.sg.wuchna.com/kafka/2.8.0/kafka_2.12-2.8.0.tgz""

2) Dowbload 3.5.6
sudo wget "https://apachemirror.sg.wuchna.com/zookeeper/zookeeper-3.6.3/apache-zookeeper-3.6.3-bin.tar.gz"

3) Now we need to extract the tar

sudo tar -xzf kafka_2.12-2.8.0.tgz

sudo tar -xzf apache-zookeeper-3.6.3-bin.tar.gz

4) go to kafka directory
cd kafka_2.12-2.8.0

create the environment variable for kafka and zookeeper
export ZOOKEEPER_HOME=/home/ubuntu/lamp_kafka_cluster/apache-zookeeper-3.6.3-bin
export PATH=$PATH:$ZOOKEEPER_HOME/bin
export KAFKA_HOME=/home/ubuntu/lamp_kafka_cluster/kafka_2.12-2.8.0
export PATH=$PATH:$KAFKA_HOME/bin

 Need permissions
 
 ubuntu@lx20devappdb01:~/lamp_kafka_cluster$ sudo chmod 775 kafka_2.12-2.8.0
ubuntu@lx20devappdb01:~/lamp_kafka_cluster$ sudo chmod 775 apache-zookeeper-3.6.3-bin


5) Kafka uses zoo keeper so we need to first start a zookeeper server. Always remember kafka brokers runs on zoo keeper server
zookeeper-server-start.sh ../config/zookeeper.properties

nohup zookeeper-server-start.sh -daemon ../config/zookeeper.properties > /dev/null 2>&1 &

6) After zoo keeper server is on, we need to bring ypto kafka server

bin/kafka-server-start.sh  config/server.properties

kafka-server-start.sh ../config/server.properties

nohup kafka-server-start.sh -daemon ../config/server.properties > /dev/null 2>&1 &

Try to find out the process id's for both kafka and zoo keeper. Hope both are running

7) Create a topic name - LAMP123

sudo bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic Lamp123

now we need to run below command to write message
sudo bin/kafka-topics.sh --list --bootstrap-server localhost:9092

Try to write some messages
sudo bin/kafka-console-producer.sh --broker-list localhost:9092 --topic Lamp123

sudo bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Lamp123 --from-beginning

To retreive one message and exit
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Lamp123 --partition 0 --offset 34537263 --max-messages 1

kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Lamp123 --partition 0 --offset 34537263 --max-messages 100

To retrive last 10 messages from the beginning
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning  --max-messages 10
