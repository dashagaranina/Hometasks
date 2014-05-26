package core;

import service.impl.OrderServiceImpl;
import service.proxy.OrderServiceProxy;

public class Factory {

    private static Factory factory = new Factory();

    private Factory() {}

    public static Factory getInstance() {
        return factory;
    }

    public Object getBean(String name) {
        if(name.equals("orderService")) {
            return new OrderServiceProxy(new OrderServiceImpl());
        }

        throw new IllegalArgumentException();
    }
}
