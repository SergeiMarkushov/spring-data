package ru.gb.model.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.Product;
import ru.gb.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/{id}")
    public Product getCustomer(@PathVariable Long id) {
        return productRepository.getById(id);
    }

    @GetMapping("/all")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    @DeleteMapping
    public void deleteProductById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @GetMapping("/filterFromMax")
    public List<Product> filteredByCostMax(){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "cost"));
    }
    @GetMapping("/filterFromMin")
    public List<Product> filteredByCostMin(){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "cost"));
    }

    @GetMapping("/findBetween")
    public List<Product> findBetween(@PathVariable int maxCost, @PathVariable int minCost) {
        return productRepository.findAllByMaxMinCost(maxCost, minCost);
    }
}
