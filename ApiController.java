package ineuron.SpringBoot10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController 
{
	private final ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) 
    {
        this.apiService = apiService;
    }

    @GetMapping("/data")
    public String getData() 
    {
        return apiService.callExternalApi1();
    }
}
