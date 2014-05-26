package service.proxy;

import service.OrderService;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 24.03.14
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
public class OrderServiceProxy implements OrderService {
    private OrderService target;

    public OrderServiceProxy(OrderService orderService) {
        target = orderService;
    }


    @Override
    public String getOrder(String orderNumber) {
        System.out.println("logBeforeGet() is running!");
        System.out.println("ParamTypes: "+orderNumber);
        try {

            target.getOrder(orderNumber);
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
        target.addOrder(orderNumber, amount);
        Long end = System.nanoTime();
        System.out.println("End: "+end);
        System.out.println("ParamTypes: "+orderNumber+ ", "+ amount);
        System.out.println("*************************************");

        return null;

    }
}
