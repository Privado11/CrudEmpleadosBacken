package com.empleados.recursos_humanos.dto.empleado;

import com.empleados.recursos_humanos.modelo.Cargo;

public record EmpleadoDto(
        Long id,
        String codigo,
        String nombre,
        String apellido,
        String direccion,
        String telefono,
        String email,
        Double sueldo,
        Cargo cargo
) {
}
