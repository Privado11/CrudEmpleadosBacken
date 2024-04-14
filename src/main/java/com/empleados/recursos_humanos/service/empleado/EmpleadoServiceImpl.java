package com.empleados.recursos_humanos.service.empleado;

import com.empleados.recursos_humanos.exception.RecursoNoEncontradoException;
import com.empleados.recursos_humanos.modelo.Empleado;
import com.empleados.recursos_humanos.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado buscarEmpleadoPorId(Long idEmpleado) {
        return empleadoRepository.findById(idEmpleado).orElseThrow(()->new RecursoNoEncontradoException("Empleado con id" + idEmpleado + "no encontrado"));
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Long idEmpleado) {
        Empleado empleado = empleadoRepository.findById(idEmpleado).orElseThrow(()->new RecursoNoEncontradoException("Empleado con id" + idEmpleado + "no encontrado"));
        empleadoRepository.delete(empleado);
    }

    @Override
    public Empleado editarEmpleado(Long idEmpleado, Empleado empleado) {
        return empleadoRepository.findById(idEmpleado)
        .map(empleadoAux->{
            empleadoAux.setCodigo(empleado.getCodigo());
            empleadoAux.setNombre(empleado.getNombre());
            empleadoAux.setApellido(empleado.getApellido());
            empleadoAux.setDireccion(empleado.getDireccion());
            empleadoAux.setTelefono(empleado.getTelefono());
            empleadoAux.setEmail(empleado.getEmail());
            empleadoAux.setDepartamento(empleado.getDepartamento());
            empleadoAux.setSueldo(empleado.getSueldo());
            empleadoAux.setCargo(empleado.getCargo());

            return empleadoRepository.save(empleadoAux);
        }).orElseThrow(()->new RecursoNoEncontradoException("Empleado con id" + idEmpleado + "no encontrado"));
    }

    @Override
    public List<Empleado> buscarEmpleadoPorDepartamento(String nombreDepartamento) {
        return empleadoRepository.findByCargo_Departamento_Nombre(nombreDepartamento);
    }

    @Override
    public List<Empleado> buscarEmpleadoPorCargo(String nombreCargo) {
        return empleadoRepository.findByCargo_Nombre(nombreCargo);
    }
}
