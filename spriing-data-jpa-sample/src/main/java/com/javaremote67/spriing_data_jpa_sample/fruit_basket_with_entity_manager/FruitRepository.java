package com.javaremote67.spriing_data_jpa_sample.fruit_basket_with_entity_manager;


import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class FruitRepository {

    private final EntityManager entityManager;

    //READ - FIND(hibernate) - SELECT(sql)
    public Optional<Fruit> findById(final Long id) {
        return Optional.ofNullable(this.entityManager.find(Fruit.class, id));
    }

    public List<Fruit> findAll() {
        return entityManager.createQuery("SELECT f FROM fruits f", Fruit.class).getResultList();
    }

    //CREATE/UPDATE - PERSIST(hibernate) - INSERT/UPDATE(sql)
    public Fruit saveFruit(final Fruit fruit) {
        this.entityManager.persist(fruit);
        return fruit;
    }

    //DELETE - REMOVE(hibernate) - DELETE(sql)
    public void deleteByObject(final Fruit fruit) {
        this.entityManager.remove(fruit);
    }

    public void deleteById(final Long id) {
        this.entityManager.createQuery("DELETE FROM fruits f WHERE f.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
