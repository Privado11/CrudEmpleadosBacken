package com.empleados.recursos_humanos.dto.empleado;

import com.empleados.recursos_humanos.modelo.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record EmpleadoToSaveDto(
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
