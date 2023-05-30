package ineuron.SpringBoot08;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController 
{
	@Value("${spring.datasource.url}")
    private String databaseUrl;

    @GetMapping("/database-url")
    public String getDatabaseUrl() 
    {
        return databaseUrl;
    }
}
