package com.javaremote67.spriing_data_jpa_sample.fruit_basket_with_advannce_crud_repository;


import com.javaremote67.spriing_data_jpa_sample.fruit_basket_with_entity_manager.Fruit;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DbInitializerWithAdvanceCrudRepository implements CommandLineRunner {

    private final FruitAdvanceCrudRepository fruitAdvanceCrudRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("~~~~ Repository with advance crud ~~~~");

        Fruit fr1 = fruitAdvanceCrudRepository.save(new Fruit("watermelon", 40.2));
        Fruit fr2 = fruitAdvanceCrudRepository.save(new Fruit("papaya", 3.2));
        Fruit fr3 = fruitAdvanceCrudRepository.save(new Fruit("banana", 1.1));
        Fruit fr4 = fruitAdvanceCrudRepository.save(new Fruit("apple", 0.5));
        Fruit fr5 = fruitAdvanceCrudRepository.save(new Fruit("orange", 1.5));

        System.out.println(this.fruitAdvanceCrudRepository.findByWeight(fr4.getWeight()));
        System.out.println(this.fruitAdvanceCrudRepository.findByName(fr2.getName()));

        System.out.println(this.fruitAdvanceCrudRepository.findByNameAndWeight(fr1.getName(), fr1.getWeight()));
        System.out.println(this.fruitAdvanceCrudRepository.findByNameAndWeight(fr1.getName(), fr5.getWeight()));
        System.out.println(this.fruitAdvanceCrudRepository.findByNameOrWeight(fr3.getName(), fr3.getWeight()));
        System.out.println(this.fruitAdvanceCrudRepository.findByNameOrWeight("orange", 56.2));
        System.out.println(this.fruitAdvanceCrudRepository.findByNameOrWeight("chocolate", 0.5));
        System.out.println(this.fruitAdvanceCrudRepository.findByNameOrWeight("chocolate", 44.21));

        System.out.println(this.fruitAdvanceCrudRepository.findAllDistinctByName("banana"));
        System.out.println(this.fruitAdvanceCrudRepository.findTop3ByWeight(2.0)); //!!!!

        System.out.println(this.fruitAdvanceCrudRepository.findByNameStartingWithAndWeightBetweenOrderByNameDesc("a", 0.4, 1.0));
        System.out.println(this.fruitAdvanceCrudRepository.findAllByWeightLessThan(2.0));
        System.out.println(this.fruitAdvanceCrudRepository.selectAllFruitsByProvidedName("watermelon"));

        System.out.println("\n");

    }
}
