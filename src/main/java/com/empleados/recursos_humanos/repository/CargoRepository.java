package com.empleados.recursos_humanos.repository;

import com.empleados.recursos_humanos.modelo.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CargoRepository extends JpaRepository<Cargo, Long> {
    Cargo findByNombreLike(String nombre);
}

