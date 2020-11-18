<img src="https://herp.app/herp-logo.svg" width="200">
# hERP service java skeleton built on spring and maven
This is a simple example for a service for hERP built in Java. You can start from here to create your own service for [hERP](https://herp.app). 

If you are not familiar with Services read the [documentation here](https://herp.app/docs/services/hello-world-service/) to get started.

## Features 
This skeleton does already: 
* Start a webserver with necessary endpoints */do* and */install*
* Basic Configuration via application.properties or command line
* Register itself to a running hERP server

## How to use

## Develop
To start developement you may do the following steps.

```
git clone git@github.com:herp-app/herp-service-skeleton-java.git
cd herp-service-skeleton-java
./mvnw clean install
./mvnw spring-boot:run
```
This will start a Spring-Boot Webserver on port 8080 after downloading the necessary dependencies. Use the **DoController.java** file to start your custom code from. It is necessary to tell the service, how to reach hERP. This is done by passing the command line argument **herp_uri** but you can also use src/main/resources/application.properties file to adjust this configuration and skip the command line arguments. 
You can also intercept a specific port and herp_uri by command line: 
``` 
-Dspring-boot.run.arguments=--server.port=8080--herp_uri="http://localhost:5050"
```

To change the inputs and outputs of your service, which define the interface for communication with hERP, use the Classes ***com.herp.service.skeletonjava.ProvidedInput*** and ***com.herp.service.skeletonjava.ProvidedOutput***. 
