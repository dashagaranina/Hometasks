package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.OrderService;

public class App {
	public static void main(String[] args) throws Exception {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-Customer.xml");

        OrderService orderService = (OrderService) appContext.getBean(OrderService.class);
        orderService.addOrder("qwe", Long.parseLong("0"));
        orderService.getOrder("qwe");


	}
}