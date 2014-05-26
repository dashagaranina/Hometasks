package core;

import service.OrderService;

public class App {
	public static void main(String[] args) throws Exception {

        Factory factory = Factory.getInstance();
        OrderService order = (OrderService) factory.getBean("orderService");
        order.addOrder("DeadLine", Long.parseLong("666"));
        order.getOrder("Task12");
	}
}