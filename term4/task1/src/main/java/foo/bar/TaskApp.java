package foo.bar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaskApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        //внедрение значения
        Landlord landlord = (Landlord)context.getBean("landladyMary");
        System.out.println(landlord.getName());

        //внедрение ссылки (landlord) через setter
        House house = context.getBean(House.class);
        house.payFor("water");

        // внедрение ссылки через коллекции (tenants) и через конструктор (landlord)
        Kommunalka kommunalka = context.getBean(Kommunalka.class);
        kommunalka.greeting();

    }
}
