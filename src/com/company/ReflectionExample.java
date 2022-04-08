package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ReflectionExample {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {

        // 리플렉션으로 클래스 받아오기
        System.out.println("---------------------------");
        Class c = "StringExample".getClass(); // String의 클래스를 가져옴
        System.out.println(c);

        byte[] bytes = new byte[1024];
        Class c1 = bytes.getClass();
        System.out.println(c1);

        HashSet<String> s = new HashSet<>();
        Class c2 = s.getClass();
        System.out.println(c2);


        // 클래스의 인스턴스인지 확인하기
        System.out.println("-------------------");
        Class pClass2 = Class.forName("com.company.Person");
        boolean isInstance = pClass2.isInstance(new Person("string", Arrays.asList("string")));
        System.out.println(isInstance); // true


        // 리플렉션 - 클래스 메서드
        System.out.println("-----------------");
        Method getNameMethod = pClass2.getMethod("getName");

        Method privateMethod = pClass2.getDeclaredMethod("privateMethod", String.class);
        privateMethod.setAccessible(true);

        Method publicMethodWithParam = pClass2.getMethod("publicMethodWithParam", String.class);

        Class[] parameterTypes1 = privateMethod.getParameterTypes();
        for (Class<?> paramClass : parameterTypes1) {
            System.out.println(paramClass.getName());
        }

        Person personInstance = new Person("person name", Arrays.asList("f1", "f2"));
        privateMethod.invoke(personInstance, "paramExample");


        // 리플렉션 - 클래스 메서드 여러개 한 번에 가져오기
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


        // 리플렉션 - 클래스 생성자
        System.out.println("----------------------------");
        Class pClass = Class.forName("com.company.Person");
        Constructor constructor = pClass.getConstructor(new Class[]{String.class, List.class});
        System.out.println("---------------");
        System.out.println(constructor.getName());
        System.out.println(constructor.getParameterCount());
        System.out.println(constructor.getAnnotations());
        System.out.println(constructor.getDeclaringClass());
        System.out.println(constructor.getClass());


        // 리플렉션 - 클래스 생성자 한 번에 가져오기
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


        // 리플렉션 - 클래스 필드
        System.out.println("-----------------------");
        Field[] fields = pClass2.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Field name = pClass2.getDeclaredField("name");
        Field friends = pClass2.getDeclaredField("friends");
        friends.setAccessible(true);
        name.setAccessible(true);
        System.out.println(name);
        System.out.println(name.getName());

        System.out.println(friends);
        System.out.println(friends.getName());


        // 리플렉션 - 클래스 필드 값 set,get
        System.out.println("----------------");
        Class<Person> pClass3 = Person.class;
        Field nameField = pClass3.getDeclaredField("name");
        Person personInstance1 = new Person("name Example", Arrays.asList("f1", "f2"));

        nameField.setAccessible(true);
        Object value = nameField.get(personInstance);
        System.out.println(value.toString());

        nameField.set(personInstance, "new name");
        System.out.println(personInstance.getName());

    }
}
