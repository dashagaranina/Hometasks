package foo.bar;

import foo.bar.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaskApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
        // overwrites  spring-config.xml
        context.register(SpringConfig.class);
        context.refresh();

        //внедрение значения
        Landlord landlord = (Landlord)context.getBean("landladyMary");
        System.out.println(landlord.getName());

        //внедрение ссылки (landlord) через setter
        House house = context.getBean(House.class);
        house.payFor("water");

        // внедрение ссылки через коллекции (tenants) и через конструктор (landlord)
        Kommunalka kommunalka = context.getBean(Kommunalka.class);
        kommunalka.greeting();

        // using annotation
        Town town = context.getBean(Town.class);
        town.hasMayor("Pleasantville");


        // scope tests
        System.out.println("Test singleton scope: " +
                (context.getBean("landlordPeter") == context.getBean("landlordPeter")));

        System.out.println("Test prototype scope: "+
                (context.getBean("landladyMary")==context.getBean("landladyMary")));


    }
}
