package core;

import service.decorator.Decorator;
import service.impl.OrderServiceImpl;

public class Factory {

    private static Factory factory = new Factory();

    private Factory() {}

    public static Factory getInstance() {
        return factory;
    }

    public Object getBean(String name) {
        if(name.equals("orderService")) {
            return  new Decorator(new OrderServiceImpl());
            //return new OrderServiceProxy(new OrderServiceImpl());
        }

        throw new IllegalArgumentException();
    }
}
