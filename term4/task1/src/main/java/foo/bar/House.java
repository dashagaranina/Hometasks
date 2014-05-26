package foo.bar;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 09.02.14
 * Time: 19:59
 * To change this template use File | Settings | File Templates.
 */
public class House {
    Landlord landlord;

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public void payFor (String smth) {
        if (landlord!=null)
        System.out.println(landlord.toString()+" should pay for "+ smth);
    }
}
