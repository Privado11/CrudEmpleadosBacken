package com.empleados.recursos_humanos.controller;

import com.empleados.recursos_humanos.dto.cargo.CargoDto;
import com.empleados.recursos_humanos.dto.cargo.CargoToSaveDto;
import com.empleados.recursos_humanos.modelo.Cargo;
import com.empleados.recursos_humanos.service.cargo.CargoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cargos")
@CrossOrigin(value = "http://localhost:5173")
public class CargoController {
    private static final Logger logger = LoggerFactory.getLogger(CargoController.class);

    @Autowired
    private CargoService cargoService;

    @GetMapping()
    public ResponseEntity<List<CargoDto>> obtenerCargos() {
        List<CargoDto> cargos = cargoService.getAllCargos();
        cargos.forEach(cargo -> logger.info(cargo.toString()));
        return ResponseEntity.ok().body(cargos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoDto> obtenerCargoPorId(@PathVariable("id") Long idCargo) {
        var cargo = cargoService.buscarCargoPorId(idCargo);
        logger.info("Cargo encontrado: " + cargo);
        return ResponseEntity.ok().body(cargo);
    }

    @PostMapping()
    public ResponseEntity<CargoDto> agregarCargo(@RequestBody CargoToSaveDto cargo) {
        logger.info("Cargo a guardar: " + cargo);
        var cargoG = cargoService.guardarCargo(cargo);
        return ResponseEntity.ok().body(cargoG);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoDto> editarCargo(@PathVariable("id") Long idCargo, @RequestBody CargoToSaveDto cargo) {
        logger.info("Cargo editado: " + cargo);
        var cargoE = cargoService.editarCargo(idCargo, cargo);
        return ResponseEntity.ok().body(cargoE);
    }

    @DeleteMapping("/{id}")
    public void eliminarCargo(@PathVariable("id") Long idCargo) {
        logger.info("Cargo eliminado: " + idCargo);
        cargoService.eliminarCargo(idCargo);
    }

    @GetMapping("/nombre/{nombreCargo}")
    public ResponseEntity<CargoDto> buscarCargoPorNombre(@PathVariable("nombreCargo") String nombreCargo) {
        var cargo = cargoService.buscarCargoPorNombre(nombreCargo);
        logger.info("Cargo encontrado: " + cargo);
        return ResponseEntity.ok().body(cargo);
    }
}
