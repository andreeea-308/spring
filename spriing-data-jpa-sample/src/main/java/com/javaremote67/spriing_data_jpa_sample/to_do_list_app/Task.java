package com.javaremote67.spriing_data_jpa_sample.to_do_list_app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;


@Entity(name = "tasks")
@Data
@RequiredArgsConstructor
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Date dateline;

    public Task() {
    }

}
