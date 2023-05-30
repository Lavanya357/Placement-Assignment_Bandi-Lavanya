package ineuron.SpringBoot09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService 
{
	private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) 
    {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() 
    {
        return productRepository.findAll();
    }

    public Page<Product> getProductsByCriteria(Specification<Product> spec, Pageable pageable) 
    {
        return productRepository.findAll(spec, pageable);
    }

	public Page<Product> getProductsByCriteria(Specification<Product> spec, PageRequest pageRequest) 
	{
		return null;
	}
}
