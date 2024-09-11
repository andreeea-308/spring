package com.javaremote67.spriing_data_jpa_sample.fruit_basket_with_entity_manager;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Transactional
@Order(1)
public class DbInitializer implements CommandLineRunner {

    private final FruitRepository fruitRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("~~~~ Repository with EntityManager ~~~~");
        final Fruit fruitA = new Fruit("Apple", 20.3);
        final Fruit fruitB = new Fruit("Banana", 18.223);

        this.fruitRepository.saveFruit(fruitA);
        System.out.println(this.fruitRepository.findAll());
        this.fruitRepository.saveFruit(fruitB);
        System.out.println(this.fruitRepository.findAll());

        System.out.println(this.fruitRepository.findById(1L));

        this.fruitRepository.deleteById(2L);
        System.out.println(this.fruitRepository.findAll());
        this.fruitRepository.deleteByObject(fruitA);
        System.out.println(this.fruitRepository.findAll());

        System.out.println("\n");
    }
}
