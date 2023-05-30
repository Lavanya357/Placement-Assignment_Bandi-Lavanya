package ineuron.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService 
{
	private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) 
    {
        this.personRepository = personRepository;
    }

    public Person savePerson(Person person) 
    {
        return personRepository.save(person);
    }
}


