package com.empleados.recursos_humanos.service.cargo;

import com.empleados.recursos_humanos.dto.cargo.CargoDto;
import com.empleados.recursos_humanos.dto.cargo.CargoMapper;
import com.empleados.recursos_humanos.dto.cargo.CargoToSaveDto;
import com.empleados.recursos_humanos.exception.RecursoNoEncontradoException;
import com.empleados.recursos_humanos.modelo.Cargo;
import com.empleados.recursos_humanos.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService{

    private CargoRepository cargoRepository;
    private CargoMapper cargoMapper;

    @Autowired
    public CargoServiceImpl(CargoRepository cargoRepository, CargoMapper cargoMapper) {
        this.cargoRepository = cargoRepository;
        this.cargoMapper = cargoMapper;
    }

    @Override
    public List<CargoDto> getAllCargos() {
        return cargoRepository.findAll()
                .stream()
                .map(cargo -> cargoMapper.toDto(cargo))
                .toList();
    }

    @Override
    public CargoDto buscarCargoPorId(Long idCargo) {
        Cargo cargoE = cargoRepository.findById(idCargo).orElseThrow(() -> new RecursoNoEncontradoException("Cargo con id " + idCargo + " no encontrado"));

        return cargoMapper.toDto(cargoE);
    }

    @Override
    public CargoDto guardarCargo(CargoToSaveDto cargo) {
        Cargo cargoG = cargoMapper.toSaveToEntity(cargo);
        return cargoMapper.toDto(cargoRepository.save(cargoG));
    }

    @Override
    public void eliminarCargo(Long idCargo) {
        Cargo cargo = cargoRepository.findById(idCargo).orElseThrow(() -> new RecursoNoEncontradoException("Cargo con id " + idCargo + " no encontrado"));
        cargoRepository.delete(cargo);
    }

    @Override
    public CargoDto editarCargo(Long idCargo, CargoToSaveDto cargo) {
        return cargoRepository.findById(idCargo)
                .map(cargoAux -> {
                    cargoAux.setNombre(cargo.nombre());
                    cargoAux.setDepartamento(cargo.departamento());

                    return cargoMapper.toDto(cargoRepository.save(cargoAux));
                }).orElseThrow(() -> new RecursoNoEncontradoException("Cargo con id " + idCargo + " no encontrado"));
    }

    @Override
    public CargoDto buscarCargoPorNombre(String nombreCargo) {
        return cargoMapper.toDto(cargoRepository.findByNombreLike(nombreCargo));
    }

}
