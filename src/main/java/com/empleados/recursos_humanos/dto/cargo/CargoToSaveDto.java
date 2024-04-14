package com.empleados.recursos_humanos.dto.cargo;

import com.empleados.recursos_humanos.modelo.Departamento;

public record CargoToSaveDto(
        Long id,
        String nombre,
        Departamento departamento
) {
}
