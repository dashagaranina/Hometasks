package foo.bar;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 09.02.14
 * Time: 20:44
 * To change this template use File | Settings | File Templates.
 */
public class Kommunalka {
    Landlord landlord;
    List<Tenant> tenants;

    public Kommunalka(Landlord landlord) {
        this.landlord = landlord;
    }

    public void setTenants(List<Tenant> tenants) {
        this.tenants = tenants;
    }

    public void greeting () {
        if (landlord!=null)
            System.out.println("Welcome to the communal apartments! " +
                    "This is " + landlord.toString()+"'s house. " +
                    "Last who came home is "+tenants.get(tenants.size()-1).getName()+".");
    }
}
