package ineuron.SpringBoot09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController 
{
	private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) 
    {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() 
    {
        return productService.getAllProducts();
    }

    @GetMapping("/search")
    public Page<Product> searchProducts(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "minPrice", required = false) Double minPrice,
            @RequestParam(value = "maxPrice", required = false) Double maxPrice,
            @RequestParam(value = "sort", defaultValue = "id") String sort,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        Specification<Product> spec = Specification.where(null);
        
        if (name != null) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("name"), "%" + name + "%"));
        }

        if (minPrice != null) 
        {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
        }

        if (maxPrice != null) 
        {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
        }

        Sort.Direction direction = Sort.Direction.ASC;
        if (sort.startsWith("-")) 
        {
            direction = Sort.Direction.DESC;
            sort = sort.substring(1);
        }

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(direction, sort));

        return productService.getProductsByCriteria(spec, pageRequest);
    }
}
