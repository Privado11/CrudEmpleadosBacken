package com.empleados.recursos_humanos.controller;

import com.empleados.recursos_humanos.modelo.Departamento;
import com.empleados.recursos_humanos.service.departamento.DepartamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/departamentos")
@CrossOrigin(value = "http://localhost:5173")
public class DepartamentoController {

    private static final Logger logger =
            LoggerFactory.getLogger(DepartamentoController.class);

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping()
    public ResponseEntity<List<Departamento>> obtenerDepartamentos() {
        List<Departamento> departamentos = departamentoService.getAllDepartamentos();
        departamentos.forEach(departamento -> logger.info(departamento.toString()));
        return ResponseEntity.ok().body(departamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> obtenerDepartamentoPorId(@PathVariable("id") Long idDepartamento) {
        Departamento departamento = departamentoService.buscarDepartamentoPorId(idDepartamento);
        logger.info("Departamento encontrado: " + departamento);
        return ResponseEntity.ok().body(departamento);
    }

    @PostMapping()
    public ResponseEntity<Departamento> agregarDepartamento(@RequestBody Departamento departamento) {
        logger.info("Departamento a guardar: " + departamento);
        Departamento departamentoG = departamentoService.guardarDepartamento(departamento);
        return ResponseEntity.ok().body(departamentoG);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> editarDepartamento(@PathVariable("id") Long idDepartamento, @RequestBody Departamento departamento) {
        logger.info("Departamento editado: " + departamento);
        Departamento departamentoE = departamentoService.editarDepartamento(idDepartamento, departamento);
        return ResponseEntity.ok().body(departamentoE);
    }

    @DeleteMapping("/{id}")
    public void eliminarDepartamento(@PathVariable("id") Long idDepartamento) {
        logger.info("Departamento eliminado: " + idDepartamento);
        departamentoService.eliminarDepartamento(idDepartamento);
    }

    @GetMapping("/nombre/{nombreDepartamento}")
    public ResponseEntity<Departamento> buscarDepartamentoPorNombre(@PathVariable("nombreDepartamento") String nombreDepartamento) {
        Departamento departamento = departamentoService.buscarDepartamentoPorNombre(nombreDepartamento);
        logger.info("Departamento encontrado: " + departamento);
        return ResponseEntity.ok().body(departamento);
    }
}
