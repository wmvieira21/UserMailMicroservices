# User registry

I developed two microservices (emailSenderService, and userRegistryService) to register and send a welcome email to the new user. 

Using a message broker (RabbitMQ), the microservice userRegistryService is responsible for yielding an endpoint so that consumers of this API can register new users. The users are  saved in the database "user" and a message to the broker is published in the queue.

The emailSenderService microservice is responsible for listening to the messages published and sending an email to the new user using Google SMTP. It also saves the email data in a separate database called "mail";


## Dependencies
* Spring Mail
* Sring Logging
* Google SMTP
* Spring AMQP
* RabbitMQ
* Log4j2


## Demonstration
![Design sem nome](https://github.com/wmvieira21/UserMailMicroservices/assets/90009567/87f35f8c-46b3-4957-b766-7ad49d5eec3b)
