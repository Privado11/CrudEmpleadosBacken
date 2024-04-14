package com.empleados.recursos_humanos.repository;

import com.empleados.recursos_humanos.modelo.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    Departamento findByNombreLike(String nombre);
}
