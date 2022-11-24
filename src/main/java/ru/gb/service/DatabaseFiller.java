package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.gb.model.Product;
import ru.gb.repository.ProductRepository;

@Component
public class DatabaseFiller {

    @Autowired
    private ProductRepository productRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabaseOnStartApplication(){
        productRepository.save(createProduct("Milk", 100));
        productRepository.save(createProduct("Carrot", 80));
        productRepository.save(createProduct("Water", 30));
        productRepository.save(createProduct("Cigarers", 150));
        productRepository.save(createProduct("Lighter", 50));
        productRepository.save(createProduct("Apple", 10));
        productRepository.save(createProduct("Orange", 15));
        productRepository.save(createProduct("Bread", 37));
        productRepository.save(createProduct("Butter", 99));
        productRepository.save(createProduct("Glasses", 3000));
        productRepository.save(createProduct("Cup", 300));
        productRepository.save(createProduct("Tea", 450));
        productRepository.save(createProduct("Coffe", 500));
        productRepository.save(createProduct("Sugar", 100));
        productRepository.save(createProduct("Souce", 170));
        productRepository.save(createProduct("Cream", 80));
        productRepository.save(createProduct("Cheese", 340));
        productRepository.save(createProduct("Pancake", 700));
        productRepository.save(createProduct("Lemon", 12));
        productRepository.save(createProduct("Potato", 110));
    }

    private Product createProduct(String title, int cost) {
        Product product = new Product();
        product.setTitle(title);
        product.setCost(cost);
        return product;
    }

}
