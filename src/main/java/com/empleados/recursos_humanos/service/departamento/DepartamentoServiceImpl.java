package com.empleados.recursos_humanos.service.departamento;

import com.empleados.recursos_humanos.exception.RecursoNoEncontradoException;
import com.empleados.recursos_humanos.modelo.Departamento;
import com.empleados.recursos_humanos.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento buscarDepartamentoPorId(Long idDepartamento) {
        return departamentoRepository.findById(idDepartamento)
                .orElseThrow(() -> new RecursoNoEncontradoException("Departamento con id " + idDepartamento + " no encontrado"));
    }

    @Override
    public Departamento guardarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public void eliminarDepartamento(Long idDepartamento) {
        Departamento departamento = departamentoRepository.findById(idDepartamento)
                .orElseThrow(() -> new RecursoNoEncontradoException("Departamento con id " + idDepartamento + " no encontrado"));
        departamentoRepository.delete(departamento);
    }

    @Override
    public Departamento editarDepartamento(Long idDepartamento, Departamento departamento) {
        return departamentoRepository.findById(idDepartamento)
                .map(departamentoAux -> {
                    departamentoAux.setNombre(departamento.getNombre());
                    departamentoAux.setJefeDepartamento(departamento.getJefeDepartamento());
                    departamentoAux.setCargos(departamento.getCargos());

                    return departamentoRepository.save(departamentoAux);
                }).orElseThrow(() -> new RecursoNoEncontradoException("Departamento con id " + idDepartamento + " no encontrado"));
    }

    @Override
    public Departamento buscarDepartamentoPorNombre(String nombreDepartamento) {
        return departamentoRepository.findByNombreLike(nombreDepartamento);
    }
}
