package com.javaremote67.spriing_data_jpa_sample.fruit_basket_with_crud_repository;


import com.javaremote67.spriing_data_jpa_sample.fruit_basket_with_entity_manager.Fruit;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Order(2)
public class DbInitializerWithCrudRepo implements CommandLineRunner {

    private final FruitCrudRepository fruitCrudRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("~~~~ Repository with CrudRepository ~~~~");

        final Fruit fruitA = new Fruit("Apple", 3.2);
        final Fruit fruitB = new Fruit("Banana", 1.5);

        this.fruitCrudRepository.saveAll(List.of(fruitA, fruitB));
        this.fruitCrudRepository.findAll().forEach(System.out::println);

        System.out.println(this.fruitCrudRepository.count());
        System.out.println(this.fruitCrudRepository.existsById(2L));
        System.out.println(this.fruitCrudRepository.existsById(4L));

        System.out.println(this.fruitCrudRepository.findById(1L));
        System.out.println(this.fruitCrudRepository.findById(3L));

        System.out.println("\n");
    }
}
