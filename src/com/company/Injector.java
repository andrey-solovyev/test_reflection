package com.company;

import java.io.FileInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {
    public <T> T inject(T tClass) {
        Class carClass = tClass.getClass();
        Field[] declaredFields = carClass.getDeclaredFields();
        for (Field field : declaredFields) {
            try {


            Annotation annotation = field.getAnnotation(AutoInjectable.class);
            if (annotation==null){

            } else {
                String name = getFromProperty(field.getType().getCanonicalName());
                field.setAccessible(true);
                field.set(tClass, Class.forName(name).getDeclaredConstructor().newInstance());
            }
            } catch (Exception e){
                System.err.println(e);
            }
        }
        return tClass;

    }
    private String getFromProperty(String name){
        String output=new String();
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("path");
            property.load(fis);

            output = property.getProperty(name);

        } catch (Exception e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        return output;
    }
}
