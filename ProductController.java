package ineuron.SpringBoot06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/products")

public class ProductController 
{
	private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) 
    {
        this.productRepository = productRepository;
    }

    @GetMapping
    public Iterable<Product> getAllProducts() 
    {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) 
    {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) 
    {
        Product createdProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) 
    {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) 
        {
            product.setId(id);
            Product updatedProduct = productRepository.save(product);
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) 
    {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) 
        {
            productRepository.delete(optionalProduct.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
