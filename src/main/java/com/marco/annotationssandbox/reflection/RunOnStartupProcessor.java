package com.marco.annotationssandbox.reflection;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.stream;

@Component
public class RunOnStartupProcessor {

    @Autowired
    private ApplicationContext applicationContext;

    public void runAnnotatedMethods() {
        stream(applicationContext.getBeanDefinitionNames())
                .map(name -> applicationContext.getBean(name))
                .forEach(bean ->
                    getMethodsAnnotatedWith(bean.getClass(), RunOnStartup.class)
                            .forEach(method -> invoke(bean, method))
                );

    }

    @SneakyThrows
    private Object invoke(Object bean, Method method) {
        return method.invoke(bean, new String[]{});
    }

    public static List<Method> getMethodsAnnotatedWith(final Class<?> type, final Class<? extends Annotation> annotation) {
        final List<Method> methods = new ArrayList<>();
        Class<?> clazz = type;
        while (clazz != Object.class) { // need to iterated thought hierarchy in order to retrieve methods from above the current instance
            // iterate though the list of methods declared in the class represented by clazz variable, and add those annotated with the specified annotation
            for (final Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(annotation)) {
                    Annotation annotInstance = method.getAnnotation(annotation);
                    // TODO process annotInstance
                    methods.add(method);
                }
            }
            // move to the upper class in the hierarchy in search for more methods
            clazz = clazz.getSuperclass();
        }
        return methods;
    }
}
