package com.herp.service.skeletonjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.boot.CommandLineRunner;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class MyServiceApplication implements CommandLineRunner{
    private static final Logger logger = LoggerFactory.getLogger(MyServiceApplication.class);
    @Autowired
    private Environment env;

        
    public static void main(String[] args) {
	SpringApplication.run(MyServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
	// Start logger
        logger.info("{}", env.getProperty("JAVA_HOME"));
        logger.info("{}", env.getProperty("app.name"));

	// Read Service Properties
	Map<String, String> serviceInfo = readServiceProps();
	String herpURI = env.getProperty("com.herp.uri");

	System.out.printf("\nService %s started and reachable under %s\n\n", serviceInfo.get("name"), serviceInfo.get("host"));

	// Register Service to hERP
	try{
	    HerpProxy herpProxy = new HerpProxy(herpURI);
	    herpProxy.register(serviceInfo);
	}
	catch(Exception e){
	    logger.error("Was not able to communicate with herp. Please Check configuration.", e);
	}
    }

    private Map<String, String> readServiceProps(){
	Map<String, String> serviceInfo = new HashMap<String, String>();
	serviceInfo.put("name",env.getProperty("spring.application.name"));
	serviceInfo.put("title", env.getProperty("spring.application.title"));
	serviceInfo.put("description",env.getProperty("spring.application.description"));
	serviceInfo.put("version", env.getProperty("spring.application.version"));
	serviceInfo.put("host", "127.0.0.1:".concat(env.getProperty("server.port").toString()));
	return serviceInfo;
    }
}
