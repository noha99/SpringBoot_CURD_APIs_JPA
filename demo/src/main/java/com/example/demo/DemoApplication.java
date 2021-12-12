package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
//to run app on different port
//  java -jar demo-0.0.1-SNAPSHOT.jar --server.port=8088

//Identify and stop the process that's listening on port 8080.
//    https://stackoverflow.com/questions/39632667/how-do-i-kill-the-process-currently-using-a-port-on-localhost-in-windows
//        netstat -ano | findstr :<PORT>
//        >> output Locate the PID of the process that's using the port you want.
//        taskkill /PID <PID> /F