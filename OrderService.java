package ineuron.SpringBoot02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class OrderService 
{
	private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) 
    {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrdersByUser(User user) 
    {
        return orderRepository.findByUser(user);
    }
}
