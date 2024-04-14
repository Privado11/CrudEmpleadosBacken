package com.empleados.recursos_humanos.dto.cargo;

import com.empleados.recursos_humanos.modelo.Cargo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CargoMapper {

    CargoMapper INTANCE = Mappers.getMapper(CargoMapper.class);

    Cargo toEntity(CargoDto cargoDto);
    Cargo toSaveToEntity(CargoToSaveDto cargoToSaveDto);
    CargoDto toDto(Cargo cargo);
}
