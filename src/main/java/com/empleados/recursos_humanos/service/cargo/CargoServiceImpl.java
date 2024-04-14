package com.empleados.recursos_humanos.service.cargo;

import com.empleados.recursos_humanos.exception.RecursoNoEncontradoException;
import com.empleados.recursos_humanos.modelo.Cargo;
import com.empleados.recursos_humanos.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService{
    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public List<Cargo> getAllCargos() {
        return cargoRepository.findAll();
    }

    @Override
    public Cargo buscarCargoPorId(Long idCargo) {
        return cargoRepository.findById(idCargo).orElseThrow(() -> new RecursoNoEncontradoException("Cargo con id " + idCargo + " no encontrado"));
    }

    @Override
    public Cargo guardarCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public void eliminarCargo(Long idCargo) {
        Cargo cargo = cargoRepository.findById(idCargo).orElseThrow(() -> new RecursoNoEncontradoException("Cargo con id " + idCargo + " no encontrado"));
        cargoRepository.delete(cargo);
    }

    @Override
    public Cargo editarCargo(Long idCargo, Cargo cargo) {
        return cargoRepository.findById(idCargo)
                .map(cargoAux -> {
                    cargoAux.setNombre(cargo.getNombre());
                    cargoAux.setDepartamento(cargo.getDepartamento());
                    cargo.setEmpleados(cargo.getEmpleados());
                    return cargoRepository.save(cargoAux);
                }).orElseThrow(() -> new RecursoNoEncontradoException("Cargo con id " + idCargo + " no encontrado"));
    }

    @Override
    public Cargo buscarCargoPorNombre(String nombreCargo) {
        return cargoRepository.findByNombreLike(nombreCargo);
    }

}
