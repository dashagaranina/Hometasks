package foo.bar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 09.02.14
 * Time: 19:59
 * To change this template use File | Settings | File Templates.
 */

@Component
public class House {
    Landlord landlord;

    @Autowired
    public void setLandlord(@Qualifier("landlordPeter") Landlord landlord) {
        this.landlord = landlord;
    }

    public void payFor (String smth) {
        if (landlord!=null)
        System.out.println(landlord.toString()+" should pay for "+ smth);
    }
}
