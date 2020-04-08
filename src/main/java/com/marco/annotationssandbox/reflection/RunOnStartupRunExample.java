package com.marco.annotationssandbox.reflection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunOnStartupRunExample implements CommandLineRunner {

    @Autowired
    private RunOnStartupProcessor processor;

    public static void main(String[] args) {
        SpringApplication.run(RunOnStartupRunExample.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        processor.runAnnotatedMethods();
    }
}
