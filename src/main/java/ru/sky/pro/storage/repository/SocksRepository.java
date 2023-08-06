package ru.sky.pro.storage.repository;

import ru.sky.pro.storage.entity.Socks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocksRepository extends JpaRepository<Socks, Integer> {
    Socks findByColorAndCottonPart(String color, Integer cottonPart);
    List<Socks> findByColorAndCottonPartLessThan(String color, Integer cottonPart);
    List<Socks> findByColorAndCottonPartGreaterThan(String color, Integer cottonPart);

    boolean existsByColorAndCottonPart(String color, Integer cottonPart);
}