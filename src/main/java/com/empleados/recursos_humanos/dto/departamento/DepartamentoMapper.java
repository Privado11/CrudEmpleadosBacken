package com.empleados.recursos_humanos.dto.departamento;

import com.empleados.recursos_humanos.dto.empleado.EmpleadoMapper;
import com.empleados.recursos_humanos.modelo.Departamento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface DepartamentoMapper {

    DepartamentoMapper INSTANCE = Mappers.getMapper(DepartamentoMapper.class);

    Departamento toEntity(DepartamentoDto departamentoDto);
    Departamento toSaveDtoToEntity(DepartamentoToSaveDto departamentoToSaveDto);
    DepartamentoDto toDto(Departamento departamento);
}
