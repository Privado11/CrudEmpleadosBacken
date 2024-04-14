package com.empleados.recursos_humanos.dto.cargo;

import com.empleados.recursos_humanos.dto.departamento.DepartamentoDto;
import com.empleados.recursos_humanos.modelo.Departamento;

public record CargoDto(
        Long id,
        String nombre,
        DepartamentoDto departamento
) {
}
