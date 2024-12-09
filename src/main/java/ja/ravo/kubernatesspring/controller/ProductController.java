package ja.ravo.kubernatesspring.controller;

import ja.ravo.kubernatesspring.ProductRepository;
import ja.ravo.kubernatesspring.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World from Spring Boot Kubernates !";
    }

    @GetMapping("/product-list")
    public List<Product> productList() {
        return productRepository.findAll();
    }

    @PostConstruct
    public void init() {
        if (productRepository.count() == 0) {
            productRepository.save(Product.builder()
                    .price(new BigDecimal("35909.00"))
                    .name("Mangue")
                    .description("Test product").build());
            System.out.println(productRepository.findAll());
        } else {
            productRepository.findAll().forEach(System.out::println);
        }
    }
}
