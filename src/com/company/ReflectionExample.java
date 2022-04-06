package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ReflectionExample {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {

        Class c = "StringExample".getClass(); // String의 클래스를 가져옴
        System.out.println(c);

        byte[] bytes = new byte[1024];
        Class c1 = bytes.getClass();
        System.out.println(c1);

        HashSet<String> s = new HashSet<>();
        Class c2 = s.getClass();
        System.out.println(c2);

        Class pClass = Class.forName("com.company.Person");
        Constructor constructor = pClass.getConstructor(new Class[]{String.class, List.class});
        System.out.println("---------------");
        System.out.println(constructor.getName());
        System.out.println(constructor.getParameterCount());
        System.out.println(constructor.getAnnotations());
        System.out.println(constructor.getDeclaringClass());
        System.out.println(constructor.getClass());

        System.out.println("-------------------");
        Class pClass2 = Class.forName("com.company.Person");
        boolean isInstance = pClass2.isInstance(new Person("string", Arrays.asList("string")));
        System.out.println(isInstance); // true

        System.out.println("-------------------");
        Method[] declaredMethods = pClass2.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
            System.out.println(declaredMethod.getDeclaringClass());

            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType);
            }
        }

        System.out.println("---------------");
        Constructor[] declaredConstructors = pClass2.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getName());
            System.out.println(declaredConstructor.getDeclaringClass());


            Class[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.println(parameterType);
            }
        }

        System.out.println("-----------------------");
        Field[] fields = pClass2.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Field name = pClass2.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name);
        System.out.println(name.getName());
//        Field nameField = pClass2.getField("name");
        System.out.println("----------------");
//        System.out.println(nameField);



    }

}
