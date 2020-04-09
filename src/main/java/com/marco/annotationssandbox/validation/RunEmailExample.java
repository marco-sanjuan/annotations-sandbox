package com.marco.annotationssandbox.validation;

import com.marco.annotationssandbox.reflection.InvokeOnDemandProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@SpringBootApplication
public class RunEmailExample implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RunEmailExample.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        EmailUsageExample example = new EmailUsageExample("badEmail.com");

        Set<ConstraintViolation<EmailUsageExample>> violations = validator.validate(example);

        violations.stream()
                .filter(violation -> !violation.getMessage().isEmpty())
                .findAny().ifPresent(violation -> {
                    throw new RuntimeException(violation.getMessage() + ": " + violation.getInvalidValue());
                });
    }
}
