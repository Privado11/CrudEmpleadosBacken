package com.empleados.recursos_humanos.service.departamento;

import com.empleados.recursos_humanos.modelo.Departamento;

import java.util.List;

public interface DepartamentoService {

    public List<Departamento> getAllDepartamentos();

    public Departamento buscarDepartamentoPorId(Long idDepartamento);

    public Departamento guardarDepartamento(Departamento departamento);

    public void eliminarDepartamento(Long idDepartamento);

    public Departamento editarDepartamento(Long idDepartamento, Departamento departamento);

    public Departamento buscarDepartamentoPorNombre(String nombreDepartamento);

}
