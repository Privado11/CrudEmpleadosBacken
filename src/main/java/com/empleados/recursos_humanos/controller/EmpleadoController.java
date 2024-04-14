package com.empleados.recursos_humanos.controller;

import com.empleados.recursos_humanos.dto.empleado.EmpleadoDto;
import com.empleados.recursos_humanos.dto.empleado.EmpleadoToSaveDto;
import com.empleados.recursos_humanos.modelo.Empleado;
import com.empleados.recursos_humanos.service.empleado.EmpleadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/empleados")
@CrossOrigin(value = "http://localhost:5173")
public class EmpleadoController {

    private static final Logger logger =
            LoggerFactory.getLogger(EmpleadoController.class);

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping()
    public ResponseEntity<List<EmpleadoDto>> obtenerEmpleados(){
        var empleados = empleadoService.getAllEmpleados();
        empleados.forEach((empleado -> logger.info(empleado.toString())));
        return ResponseEntity.ok().body(empleados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDto> obtenerEmpleadoPorId(@PathVariable("id") Long idEmpleado){
        var empleado = empleadoService.buscarEmpleadoPorId(idEmpleado);
        logger.info("Empleado encontrado: " + empleado);
        return ResponseEntity.ok().body(empleado);
    }

    @PostMapping()
    public ResponseEntity<EmpleadoDto> agregarEmpleado(@RequestBody EmpleadoToSaveDto empleado){
        logger.info("Empleado a guardar: " + empleado);
        var empleadoG = empleadoService.guardarEmpleado(empleado);
        return ResponseEntity.ok().body(empleadoG);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDto> editarEmpleado(@PathVariable("id") Long idEmpleado, @RequestBody EmpleadoToSaveDto empleado){
        logger.info("Empleado editado: " + empleado);
        var empleadoE = empleadoService.editarEmpleado(idEmpleado,empleado);
        return ResponseEntity.ok().body(empleadoE);
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable("id") Long idEmpleado){
        logger.info("Empleado eliminado: " + idEmpleado);
        empleadoService.eliminarEmpleado(idEmpleado);
    }

    @GetMapping("/departamento/{nombreDepartamento}")
    public ResponseEntity<List<EmpleadoDto>> buscarEmpleadoPorDepartamento(@PathVariable("nombreDepartamento") String nombreDepartamento){
        var empleados = empleadoService.buscarEmpleadoPorDepartamento(nombreDepartamento);
        empleados.forEach((empleado -> logger.info(empleado.toString())));
        return ResponseEntity.ok().body(empleados);
    }

    @GetMapping("/cargo/{nombreCargo}")
    public ResponseEntity<List<EmpleadoDto>> buscarEmpleadoPorCargo(@PathVariable("nombreCargo") String nombreCargo){
        var empleados = empleadoService.buscarEmpleadoPorCargo(nombreCargo);
        empleados.forEach((empleado -> logger.info(empleado.toString())));
        return ResponseEntity.ok().body(empleados);
    }
}
