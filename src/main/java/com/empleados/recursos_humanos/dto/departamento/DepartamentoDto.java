package com.empleados.recursos_humanos.dto.departamento;

import com.empleados.recursos_humanos.dto.empleado.EmpleadoDto;
import com.empleados.recursos_humanos.modelo.Empleado;

public record DepartamentoDto(
        Long id,
        String nombre
        //EmpleadoDto jefe
) {
}
