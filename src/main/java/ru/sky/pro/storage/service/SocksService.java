package ru.sky.pro.storage.service;

import ru.sky.pro.storage.dto.SocksDto;

import java.util.List;

public interface SocksService {
    List<SocksDto> get(String color, String operation, Integer cottonPart);

    void setIncome(SocksDto dto);

    void setOutcome(SocksDto dto);
}
