package com.empleados.recursos_humanos.service.empleado;

import com.empleados.recursos_humanos.modelo.Empleado;

import java.util.List;

public interface EmpleadoService {
    public List<Empleado> getAllEmpleados();

    public Empleado buscarEmpleadoPorId(Long idEmpleado);

    public Empleado guardarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Long idEmpleado);

    public Empleado editarEmpleado(Long idEmpleado,Empleado empleado);

    public List<Empleado> buscarEmpleadoPorDepartamento(String nombreDepartamento);

    public List<Empleado> buscarEmpleadoPorCargo(String nombreCargo);
}
