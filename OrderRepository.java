package ineuron.SpringBoot02;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> 
{
	List<Order> findByUser(User user);
}
