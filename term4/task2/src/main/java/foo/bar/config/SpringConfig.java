package foo.bar.config;

import foo.bar.House;
import foo.bar.Kommunalka;
import foo.bar.Landlord;
import foo.bar.Tenant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 12.02.14
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */

@Configuration
@ComponentScan("foo.bar")
public class SpringConfig {

    @Bean
    public Landlord landlordPeter (){
        return new Landlord("Peter");
    }

    @Bean
    @Scope("prototype")
    public Landlord landladyMary (){
        return new Landlord("Mary");
    }

    @Bean
    public Kommunalka kommunalka() {
        Kommunalka kommunalka = new Kommunalka(landladyMary());
        List<Tenant> tenants = new ArrayList<Tenant>();
        tenants.add(tenantJohn());
        tenants.add(tenantJeck());
        tenants.add(tenantJessy());
        kommunalka.setTenants(tenants);
        return kommunalka;
    }

    @Bean
    public Tenant tenantJohn (){
        Tenant  tenant = new Tenant("John");
        return tenant;
    }

    @Bean
    public Tenant tenantJeck (){
        Tenant  tenant = new Tenant("Jeck");
        return tenant;
    }

    @Bean
    public Tenant tenantJessy (){
        Tenant  tenant = new Tenant("Jessy");
        return tenant;
    }
}
