package com.myblog.myblog11;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class TestClass2 {

    public static void main(String[] args) {
       List<Employee> employees= Arrays.asList(
                new Employee("mike", 30,"chennai"),
                new Employee("stallin", 25,"chennai"),
                new Employee("adam", 35,"pune"),
                new Employee("sam", 35,"bengaluru")
       );
//        List<Employee> emps = employees.stream().filter(emp -> emp.getAge() > 30).collect(Collectors.toList());
//        for (Employee e:emps){
//            System.out.println(e.getName());
//            System.out.println(e.getAge());
//            System.out.println(e.getCity());
//        }
        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(e -> e.getCity()));
        System.out.println(collect);
        for(Map.Entry<String,List<Employee>> entry : collect.entrySet()){
            String city = entry.getKey();
            List<Employee> empWithCity=entry.getValue();

            System.out.println("employee with city " + city + ":" +empWithCity);
            for(Employee e : empWithCity){
                System.out.println(e.getName());
                System.out.println(e.getCity());
                System.out.println(e.getAge());
            }


        }


        Map<Integer, List<Employee>> collect1 = employees.stream().collect(Collectors.groupingBy(e -> e.getAge()));
        System.out.println(collect1);
        for(Map.Entry<Integer,List<Employee>> entry : collect1.entrySet()){
            int age = entry.getKey();
            List<Employee> empWithAge=entry.getValue();

            System.out.println("employee with age " + age + ":" +empWithAge);
            for(Employee e : empWithAge){
                System.out.println(e.getName());
                System.out.println(e.getCity());
                System.out.println(e.getAge());
            }


        }




        List<Integer> numbers = Arrays.asList(10,12,13,15,17,20);
        List<Integer> data = numbers.stream().filter(n1 -> n1 % 2 == 0).map(n2 -> n2 * n2).collect(Collectors.toList());
        System.out.println(data);

    }


}
