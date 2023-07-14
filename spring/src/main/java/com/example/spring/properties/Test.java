package com.example.spring.properties;

import lombok.Builder;
import lombok.Data;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

public class Test {

    @Data
    @Builder
    static class Stu {

        private String name;

    }

    public static void main(String[] args) {
        ConversionService conversionServiceToUse = DefaultConversionService.getSharedInstance();

        String value = conversionServiceToUse.convert("zs", String.class);
        System.out.println(value);


        Object stu = Stu.builder().name("ll").build();
        Class stuClass = Stu.class;
        Object convert = conversionServiceToUse.convert(stu, stuClass);
        System.out.println(convert);

    }
}
