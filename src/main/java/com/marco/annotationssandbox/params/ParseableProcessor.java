package com.marco.annotationssandbox.params;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
@Slf4j
public class ParseableProcessor {

    @SneakyThrows
    public void process(Object object) {
        for (Field field: object.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(Parseable.class)){
                Parser parser = getParserAnnotatedOver(field);
                String fieldValue = geFieldValue(object, field);
                String parsedValue = parser.parse(fieldValue);
                log.info("Field {} parsed by {} to {}", field.getName(), parser.getClass().getSimpleName(), parsedValue );
            }
        }
    }

    @SneakyThrows
    private Parser getParserAnnotatedOver(Field field) {
        Parseable annotation = field.getAnnotation(Parseable.class);
        Class<? extends Parser> parserClass = annotation.parser();
        return parserClass.getDeclaredConstructor().newInstance();
    }

    @SneakyThrows
    private String geFieldValue(Object object, Field field) {
        field.setAccessible(true);
        return (String) field.get(object);
    }
}
