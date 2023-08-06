package ru.sky.pro.storage.service;

import ru.sky.pro.storage.dto.SocksDto;
import ru.sky.pro.storage.entity.Socks;
import lombok.RequiredArgsConstructor;
import ru.sky.pro.storage.mapper.SocksMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.sky.pro.storage.repository.SocksRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocksServiceImpl implements SocksService {
    private final SocksRepository socksRepository;
    private final SocksMapper socksMapper;
    @Override
    public List<SocksDto> get(String color, String operation, Integer cottonPart) {
        List<Socks> ret = switch (operation) {
            case "moreThan" -> socksRepository.findByColorAndCottonPartGreaterThan(color, cottonPart);
            case "lessThan" -> socksRepository.findByColorAndCottonPartLessThan(color, cottonPart);
            case "equal" -> List.of(socksRepository.findByColorAndCottonPart(color, cottonPart));
            default -> throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        };
        return socksMapper.toDtos(ret);
    }

    @Override
    public void setIncome(SocksDto dto) {
        if(socksRepository.existsByColorAndCottonPart(dto.getColor(), dto.getCottonPart())){
            Socks existedSocks = socksRepository.findByColorAndCottonPart(dto.getColor(), dto.getCottonPart());
            existedSocks.setQuantity(existedSocks.getQuantity()+dto.getQuantity());
            socksRepository.save(existedSocks);
            return;
        }
        Socks socks = socksMapper.toEntity(dto);
        socksRepository.save(socks);
    }

    @Override
    public void setOutcome(SocksDto dto) {
        if(socksRepository.existsByColorAndCottonPart(dto.getColor(), dto.getCottonPart())){
            Socks existedSocks = socksRepository.findByColorAndCottonPart(dto.getColor(), dto.getCottonPart());
            if (existedSocks.getQuantity()-dto.getQuantity()<0){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
            existedSocks.setQuantity(existedSocks.getQuantity()-dto.getQuantity());
            socksRepository.save(existedSocks);
            return;
        }

    }
}
