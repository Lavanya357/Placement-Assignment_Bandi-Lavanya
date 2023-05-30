package ineuron.SpringBoot04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExampleController 
{
	private final ExampleRepository exampleRepository;

    @Autowired
    public ExampleController(ExampleRepository exampleRepository) 
    {
        this.exampleRepository = exampleRepository;
    }

    @PostMapping("/example")
    public Example createExampleEntity(@RequestBody Example exampleEntity) 
    {
        return exampleRepository.save(exampleEntity);
    }
}
