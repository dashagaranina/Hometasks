package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* service.OrderService.*(..)) ))")
    public void logBeforeOrder(JoinPoint joinPoint) {

        System.out.println("logBeforeOrder() is running!");
        System.out.println("method name : " + joinPoint.getSignature().getName());
        System.out.println("hijacked : " + joinPoint.getSignature().getModifiers());
        System.out.println("******");
    }

    @AfterThrowing(
            pointcut = "execution(* service.OrderService.getOrder(..))",
            throwing= "error")
    public void logAfterThrowingOrder(JoinPoint joinPoint, Throwable error) {

        System.out.println("logAfterThrowingOrder() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error);
        System.out.println("******");

    }

    @Around("execution(* service.OrderService.addOrder(..))")
    public void logAroundTime(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("logAroundTime() is running!");
        System.out.println("hijacked method : " + joinPoint.getSignature().getName());
      //  System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));

        Long start = System.nanoTime();
        System.out.println("Around before is running! Start time" + start);
        joinPoint.proceed();
        Long end = System.nanoTime();
        System.out.println("Around after is running!End time" + end);

        System.out.println("******");

    }
}