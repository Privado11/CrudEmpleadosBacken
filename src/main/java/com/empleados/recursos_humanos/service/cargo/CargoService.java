package com.empleados.recursos_humanos.service.cargo;

import com.empleados.recursos_humanos.dto.cargo.CargoDto;
import com.empleados.recursos_humanos.dto.cargo.CargoToSaveDto;


import java.util.List;

public interface CargoService {
    public List<CargoDto> getAllCargos();

    public CargoDto buscarCargoPorId(Long idCargo);

    public CargoDto guardarCargo(CargoToSaveDto cargo);

    public void eliminarCargo(Long idCargo);

    public CargoDto editarCargo(Long idCargo, CargoToSaveDto cargo);

    public CargoDto buscarCargoPorNombre(String nombreCargo);

}
