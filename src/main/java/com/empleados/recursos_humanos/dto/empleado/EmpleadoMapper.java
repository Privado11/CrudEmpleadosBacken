package com.empleados.recursos_humanos.dto.empleado;

import com.empleados.recursos_humanos.modelo.Empleado;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {

    EmpleadoMapper INSTANCE = Mappers.getMapper(EmpleadoMapper.class);

    Empleado toEntity(EmpleadoDto empleadoDto);
    Empleado toEmpleadoSaveDtoToEntity(EmpleadoToSaveDto empleadoToSaveDto);
    EmpleadoDto toDto(Empleado empleado);
}
