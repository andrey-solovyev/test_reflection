package com.company;

import java.io.FileInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {
    public <T> void injector(T tClass) {
        Class carClass = tClass.getClass();
        Field[] declaredFields = carClass.getDeclaredFields();
        for (Field field : declaredFields) {
            try {


            Annotation annotation = field.getAnnotation(AutoInjectable.class);
            if (annotation==null){
                return;
            } else {
                String name = getFromProperty(field.getType().getCanonicalName());
                field.set(tClass, Class.forName(name).getDeclaredConstructor().newInstance());
            }
            //System.out.println(annotation);
            //System.out.println(field.getType().getCanonicalName());
            } catch (Exception e){
                System.err.println(e);
            }
        }
    }
    private String getFromProperty(String name){
        String output=new String();
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("C:\\Users\\andru\\IdeaProjects\\Reflection\\src\\com\\company\\data.properties");
            property.load(fis);

            output = property.getProperty(name);

        } catch (Exception e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        return output;
    }
}
