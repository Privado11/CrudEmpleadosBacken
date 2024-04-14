package com.empleados.recursos_humanos.service.departamento;

import com.empleados.recursos_humanos.dto.departamento.DepartamentoDto;
import com.empleados.recursos_humanos.dto.departamento.DepartamentoToSaveDto;

import java.util.List;

public interface DepartamentoService {

    public List<DepartamentoDto> getAllDepartamentos();

    public DepartamentoDto buscarDepartamentoPorId(Long idDepartamento);

    public DepartamentoDto guardarDepartamento(DepartamentoToSaveDto departamento);

    public void eliminarDepartamento(Long idDepartamento);

    public DepartamentoDto editarDepartamento(Long idDepartamento, DepartamentoToSaveDto departamento);

    public DepartamentoDto buscarDepartamentoPorNombre(String nombreDepartamento);

}
