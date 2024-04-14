package com.empleados.recursos_humanos.controller;

import com.empleados.recursos_humanos.dto.departamento.DepartamentoDto;
import com.empleados.recursos_humanos.dto.departamento.DepartamentoToSaveDto;
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
    public ResponseEntity<List<DepartamentoDto>> obtenerDepartamentos() {
        List<DepartamentoDto> departamentos = departamentoService.getAllDepartamentos();
        departamentos.forEach(departamento -> logger.info(departamento.toString()));
        return ResponseEntity.ok().body(departamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoDto> obtenerDepartamentoPorId(@PathVariable("id") Long idDepartamento) {
        var departamento = departamentoService.buscarDepartamentoPorId(idDepartamento);
        logger.info("Departamento encontrado: " + departamento);
        return ResponseEntity.ok().body(departamento);
    }

    @PostMapping()
    public ResponseEntity<DepartamentoDto> agregarDepartamento(@RequestBody DepartamentoToSaveDto departamento) {
        logger.info("Departamento a guardar: " + departamento);
        var departamentoG = departamentoService.guardarDepartamento(departamento);
        return ResponseEntity.ok().body(departamentoG);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoDto> editarDepartamento(@PathVariable("id") Long idDepartamento, @RequestBody DepartamentoToSaveDto departamento) {
        logger.info("Departamento editado: " + departamento);
        var departamentoE = departamentoService.editarDepartamento(idDepartamento, departamento);
        return ResponseEntity.ok().body(departamentoE);
    }

    @DeleteMapping("/{id}")
    public void eliminarDepartamento(@PathVariable("id") Long idDepartamento) {
        logger.info("Departamento eliminado: " + idDepartamento);
        departamentoService.eliminarDepartamento(idDepartamento);
    }

    @GetMapping("/nombre/{nombreDepartamento}")
    public ResponseEntity<DepartamentoDto> buscarDepartamentoPorNombre(@PathVariable("nombreDepartamento") String nombreDepartamento) {
        var departamento = departamentoService.buscarDepartamentoPorNombre(nombreDepartamento);
        logger.info("Departamento encontrado: " + departamento);
        return ResponseEntity.ok().body(departamento);
    }
}
