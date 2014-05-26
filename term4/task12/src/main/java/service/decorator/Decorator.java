package service.decorator;

import service.OrderService;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 25.03.14
 * Time: 22:00
 * To change this template use File | Settings | File Templates.
 */
public class Decorator implements OrderService {
    private OrderService orderService;

    public Decorator(OrderService orderService) {
        this.orderService = orderService;
    }


    @Override
    public String getOrder(String orderNumber) {
        System.out.println("logBeforeGet() is running!");
        System.out.println("ParamTypes: "+orderNumber);
        try {

            orderService.getOrder(orderNumber);
        } catch (Exception e) {
            String s = e.toString();
            System.out.println("Message: " + s);
            System.out.println("*************************************");

        }   return null;
    }

    @Override
    public String addOrder(String orderNumber, Long amount) {
        System.out.println("logBeforeAdd() is running!");
        Long start = System.nanoTime();

        System.out.println("Start: "+start);
        orderService.addOrder(orderNumber, amount);
        Long end = System.nanoTime();
        System.out.println("End: "+end);
        System.out.println("ParamTypes: "+orderNumber+ ", "+ amount);
        System.out.println("*************************************");

        return null;
    }
}
