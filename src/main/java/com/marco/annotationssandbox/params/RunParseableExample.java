package com.marco.annotationssandbox.params;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunParseableExample implements CommandLineRunner {

    @Autowired
    private ParseableProcessor parseableProcessor;

    public static void main(String[] args) {
        SpringApplication.run(RunParseableExample.class, args);
    }

    @Override
    public void run(String... args) {
        ParseableUsageExample usageExample = new ParseableUsageExample(
                "example1",
                "example2"
        );

        parseableProcessor.process(usageExample);
    }



}
