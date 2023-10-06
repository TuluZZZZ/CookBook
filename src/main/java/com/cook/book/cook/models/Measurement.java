package com.cook.book.cook.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Measurements")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "conversion")
    private Double conversion_to_grams;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "measurement")
    private List<Ingredient> ingredients=new ArrayList<>();


}
