package com.marco.annotationssandbox.reflection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InvokeOnDemandUsageExample {

    @InvokeOnDemand(message = "the message")
    public void onStartup(){
        log.info(">>> Executed on startup!");
    }
}
