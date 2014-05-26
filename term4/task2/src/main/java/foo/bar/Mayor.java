package foo.bar;

import org.springframework.stereotype.Component;

import javax.lang.model.element.Element;
import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 13.02.14
 * Time: 0:23
 * To change this template use File | Settings | File Templates.
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Mayor {
    String value() default "";
}
