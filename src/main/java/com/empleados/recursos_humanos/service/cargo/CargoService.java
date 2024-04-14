package com.empleados.recursos_humanos.service.cargo;

import com.empleados.recursos_humanos.modelo.Cargo;

import java.util.List;

public interface CargoService {
    public List<Cargo> getAllCargos();

    public Cargo buscarCargoPorId(Long idCargo);

    public Cargo guardarCargo(Cargo cargo);

    public void eliminarCargo(Long idCargo);

    public Cargo editarCargo(Long idCargo, Cargo cargo);

    public Cargo buscarCargoPorNombre(String nombreCargo);

}
