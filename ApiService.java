package ineuron.SpringBoot10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService 
{
	private final CircuitBreaker circuitBreaker;

    @Autowired
    public ApiService(Resilience4JCircuitBreakerFactory circuitBreakerFactory) {
        this.circuitBreaker = circuitBreakerFactory.create("apiService");
    }

    public String callExternalApi() 
    {
        return circuitBreaker.run(() -> {
            RestTemplate restTemplate = new RestTemplate();
            String apiUrl = "https://example.com/api"; // Replace with your API URL
            return restTemplate.getForObject(apiUrl, String.class);
        }, throwable -> {
            // Handle fallback logic or return default response in case of failure
            return "Fallback response";
        });
    }

	public String callExternalApi1() 
	{
		return null;
	}
}
