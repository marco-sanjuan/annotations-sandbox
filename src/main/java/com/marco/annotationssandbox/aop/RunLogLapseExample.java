package com.marco.annotationssandbox.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunLogLapseExample implements CommandLineRunner {

    @Autowired
    private LogLapseUsageExample logLapseUseExample;

    public static void main(String[] args) {
        SpringApplication.run(RunLogLapseExample.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logLapseUseExample.exampleMethod();
    }
}
