package ineuron.SpringBoot05;
import org.springframework.stereotype.Service;

@Service
public class SampleService 
{
	public int add(int a, int b) 
	{
        return a + b;
    }
	public String concatenate(String a, String b) 
	{
        return a + b;
    }
}
