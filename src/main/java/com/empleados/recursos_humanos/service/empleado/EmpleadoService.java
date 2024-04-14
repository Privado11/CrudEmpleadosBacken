package com.empleados.recursos_humanos.service.empleado;

import com.empleados.recursos_humanos.dto.empleado.EmpleadoDto;
import com.empleados.recursos_humanos.dto.empleado.EmpleadoToSaveDto;

import java.util.List;

public interface EmpleadoService {
    public List<EmpleadoDto> getAllEmpleados();

    public EmpleadoDto buscarEmpleadoPorId(Long idEmpleado);

    public EmpleadoDto guardarEmpleado(EmpleadoToSaveDto empleado);

    public void eliminarEmpleado(Long idEmpleado);

    public EmpleadoDto editarEmpleado(Long idEmpleado, EmpleadoToSaveDto empleado);

    public List<EmpleadoDto> buscarEmpleadoPorDepartamento(String nombreDepartamento);

    public List<EmpleadoDto> buscarEmpleadoPorCargo(String nombreCargo);
}
