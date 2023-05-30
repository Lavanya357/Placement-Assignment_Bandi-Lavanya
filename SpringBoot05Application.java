package ineuron.SpringBoot05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringBoot05Application 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBoot05Application.class, args);
	}
}
