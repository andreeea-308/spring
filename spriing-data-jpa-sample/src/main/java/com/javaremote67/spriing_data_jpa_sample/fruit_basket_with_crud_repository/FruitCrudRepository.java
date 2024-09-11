package com.javaremote67.spriing_data_jpa_sample.fruit_basket_with_crud_repository;

import com.javaremote67.spriing_data_jpa_sample.fruit_basket_with_entity_manager.Fruit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitCrudRepository extends CrudRepository<Fruit, Long> {
}
