package foo.bar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 13.02.14
 * Time: 0:20
 * To change this template use File | Settings | File Templates.
 */

@Component("town")
public class Town {

    @Autowired
    @Qualifier("mayorPain")
    private Official mayorPain;

    public void hasMayor (String city) {
         if (mayorPain!=null){
             System.out.println("Mr.Pain is mayor of "+city+" city ");
         }
    }


}
