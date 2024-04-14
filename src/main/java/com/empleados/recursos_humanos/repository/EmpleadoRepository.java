package com.empleados.recursos_humanos.repository;

import com.empleados.recursos_humanos.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByCargo_Departamento_Nombre(String nombreDepartamento);
    List<Empleado> findByCargo_Nombre(String nombre);
}
