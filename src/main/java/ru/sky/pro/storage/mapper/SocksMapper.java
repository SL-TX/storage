package ru.sky.pro.storage.mapper;

import ru.sky.pro.storage.dto.SocksDto;
import ru.sky.pro.storage.entity.Socks;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SocksMapper {
    Socks toEntity(SocksDto socksDto);

    @Named("socksToSocksDto")
    SocksDto toDto(Socks socks);
    @IterableMapping(qualifiedByName = "socksToSocksDto")
    List<SocksDto> toDtos(List<Socks> socks);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Socks partialUpdate(SocksDto socksDto, @MappingTarget Socks socks);
}