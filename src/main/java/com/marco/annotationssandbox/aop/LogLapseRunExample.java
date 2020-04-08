package com.marco.annotationssandbox.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogLapseRunExample implements CommandLineRunner {

    @Autowired
    private LogLapseUseExample logLapseUseExample;

    public static void main(String[] args) {
        SpringApplication.run(LogLapseRunExample.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logLapseUseExample.exampleMethod();
    }
}
