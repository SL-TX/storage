package ru.sky.pro.storage.controller;

import ru.sky.pro.storage.dto.SocksDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sky.pro.storage.service.SocksService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("socks")
public class SocksController {
    private final SocksService socksService;

    @GetMapping
    public List<SocksDto> get(@RequestParam String color,
                              @RequestParam String operation,
                              @RequestParam Integer cottonPart){
        return socksService.get(color,operation,cottonPart);
    }

    @PostMapping("income")
    public ResponseEntity setIncome(@RequestBody SocksDto dto){
        socksService.setIncome(dto);
        return ResponseEntity.ok().build();
    }
    @PostMapping("outcome")
    public ResponseEntity setOutcome(@RequestBody SocksDto dto){
        socksService.setOutcome(dto);
        return ResponseEntity.ok().build();
    }
}
