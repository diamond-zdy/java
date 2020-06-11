package zdy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zdy.model.Duck;
import zdy.model.DuckShop;
import zdy.model.Person;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applications.xml");
        Duck duck1 = (Duck) context.getBean("duck1");
        System.out.println(duck1);
        Duck duck2 = (Duck) context.getBean("duck2");
        System.out.println(duck2);
        DuckShop duckShop = (DuckShop) context.getBean("duckShop");
        System.out.println(duckShop);
        Duck duck3 = (Duck) context.getBean("duck3");
        System.out.println(duck3);
        Person p1 = (Person) context.getBean(Person.class);
        System.out.println(p1);
        Duck duck4 = (Duck) context.getBean("duck4");
        System.out.println(duck4);
    }
}