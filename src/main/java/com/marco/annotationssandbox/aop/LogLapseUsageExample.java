package com.marco.annotationssandbox.aop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogLapseUsageExample {

    @SneakyThrows
    @LogLapse
    public String exampleMethod(){

        Thread.sleep(3000);
        return "DONE";
    }
}
