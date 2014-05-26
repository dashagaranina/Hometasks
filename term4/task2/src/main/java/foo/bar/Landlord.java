package foo.bar;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 09.02.14
 * Time: 20:14
 * To change this template use File | Settings | File Templates.
 */
public class Landlord {
    String name;

    public Landlord(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  name;
    }
}
