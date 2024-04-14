package com.empleados.recursos_humanos.service.departamento;

import com.empleados.recursos_humanos.dto.departamento.DepartamentoDto;
import com.empleados.recursos_humanos.dto.departamento.DepartamentoMapper;
import com.empleados.recursos_humanos.dto.departamento.DepartamentoToSaveDto;
import com.empleados.recursos_humanos.exception.RecursoNoEncontradoException;
import com.empleados.recursos_humanos.modelo.Departamento;
import com.empleados.recursos_humanos.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{


    private DepartamentoRepository departamentoRepository;
    private DepartamentoMapper departamentoMapper;

    @Autowired
    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository, DepartamentoMapper departamentoMapper) {
        this.departamentoRepository = departamentoRepository;
        this.departamentoMapper = departamentoMapper;
    }

    @Override
    public List<DepartamentoDto> getAllDepartamentos() {
        return departamentoRepository.findAll().stream()
                .map(departamento -> departamentoMapper.toDto(departamento))
                .toList();
    }

    @Override
    public DepartamentoDto buscarDepartamentoPorId(Long idDepartamento) {
        Departamento departamentoG = departamentoRepository.findById(idDepartamento)
                .orElseThrow(() -> new RecursoNoEncontradoException("Departamento con id " + idDepartamento + " no encontrado"));

        return departamentoMapper.toDto(departamentoG);
    }

    @Override
    public DepartamentoDto guardarDepartamento(DepartamentoToSaveDto departamento) {
        Departamento departamentoG = departamentoMapper.toSaveDtoToEntity(departamento);

        return departamentoMapper.toDto(departamentoRepository.save(departamentoG));
    }

    @Override
    public void eliminarDepartamento(Long idDepartamento) {
        Departamento departamento = departamentoRepository.findById(idDepartamento)
                .orElseThrow(() -> new RecursoNoEncontradoException("Departamento con id " + idDepartamento + " no encontrado"));
        departamentoRepository.delete(departamento);
    }

    @Override
    public DepartamentoDto editarDepartamento(Long idDepartamento, DepartamentoToSaveDto departamento) {
        return departamentoRepository.findById(idDepartamento)
                .map(departamentoAux -> {
                    departamentoAux.setNombre(departamento.nombre());

                    return departamentoMapper.toDto(departamentoRepository.save(departamentoAux));
                }).orElseThrow(() -> new RecursoNoEncontradoException("Departamento con id " + idDepartamento + " no encontrado"));
    }

    @Override
    public DepartamentoDto buscarDepartamentoPorNombre(String nombreDepartamento) {
        return departamentoMapper.toDto(departamentoRepository.findByNombreLike(nombreDepartamento));
    }
}
