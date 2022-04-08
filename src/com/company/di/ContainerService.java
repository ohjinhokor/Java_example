package com.company.di;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.function.Consumer;

public class ContainerService {

    public static <T>  T getObject(Class<T> classType){
        T instance = createInstance(classType);

        Arrays.stream(classType.getDeclaredFields())
            .filter(field -> field.getAnnotation(Inject.class) != null)
            .forEach(field -> {
                Object repositoryObject = createInstance(field.getType());
                try{
                    field.set(instance, repositoryObject);
                }
                catch (IllegalAccessException e){
                    throw new RuntimeException(e);
                }
            });
        return instance;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
