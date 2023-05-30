package ineuron.SpringBoot05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class LoggingAspect 
{
	@Before("execution(* com.example.demo.service.*.*(..))")
    public void logMethodCall(JoinPoint joinPoint) 
	{
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getMethod().getName();
        Object[] arguments = joinPoint.getArgs();
        System.out.println("Calling method: " + methodName);
        System.out.println("Arguments: ");
        for (Object arg : arguments) 
        {
            System.out.println(arg);
        }
	}
	@AfterReturning(pointcut = "execution(* com.example.demo.service.*.*(..))", returning = "result")
    public void logMethodReturn(JoinPoint joinPoint, Object result) 
	{
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Method " + methodName + " returned: " + result);
    }
}
