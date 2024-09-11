package com.javaremote67.spriing_data_jpa_sample.to_do_list_app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

}
