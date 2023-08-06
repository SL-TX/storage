package ru.sky.pro.storage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Socks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String color;
    @Column(name = "cottonpart")
    private Integer cottonPart;
    private Integer quantity;
}
