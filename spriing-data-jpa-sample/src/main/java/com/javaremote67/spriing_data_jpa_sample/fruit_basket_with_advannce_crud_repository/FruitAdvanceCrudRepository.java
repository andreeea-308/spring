package com.javaremote67.spriing_data_jpa_sample.fruit_basket_with_advannce_crud_repository;

import com.javaremote67.spriing_data_jpa_sample.fruit_basket_with_entity_manager.Fruit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FruitAdvanceCrudRepository extends CrudRepository<Fruit, Long> {

    Optional<Fruit> findByWeight(Double weight);
    Optional<Fruit> findByName(String name);
    Optional<Fruit> findByNameAndWeight(String name, Double weight);
    Optional<Fruit> findByNameOrWeight(String name, Double weight);

    List<Fruit> findAllDistinctByName(String name);
    List<Fruit> findTop3ByWeight(Double weight);

    List<Fruit> findByNameStartingWithAndWeightBetweenOrderByNameDesc(String nameStartingWith, Double minWeight, Double maxWeight);
    List<Fruit> findAllByWeightLessThan(Double maxWeight);

    @Query(value = "SELECT f FROM fruits f WHERE f.name = :name")
    List<Fruit> selectAllFruitsByProvidedName(@Param("name") String name);

}
