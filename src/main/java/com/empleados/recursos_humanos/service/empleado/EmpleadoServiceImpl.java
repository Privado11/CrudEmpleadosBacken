package com.empleados.recursos_humanos.service.empleado;

import com.empleados.recursos_humanos.dto.empleado.EmpleadoDto;
import com.empleados.recursos_humanos.dto.empleado.EmpleadoMapper;
import com.empleados.recursos_humanos.dto.empleado.EmpleadoToSaveDto;
import com.empleados.recursos_humanos.exception.RecursoNoEncontradoException;
import com.empleados.recursos_humanos.modelo.Empleado;
import com.empleados.recursos_humanos.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{


    private EmpleadoRepository empleadoRepository;
    private EmpleadoMapper empleadoMapper;

    @Autowired
    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository, EmpleadoMapper empleadoMapper) {
        this.empleadoRepository = empleadoRepository;
        this.empleadoMapper = empleadoMapper;
    }

    @Override
    public List<EmpleadoDto> getAllEmpleados() {
        return empleadoRepository.findAll()
                .stream()
                .map(empleado -> empleadoMapper.toDto(empleado))
                .toList();
    }

    @Override
    public EmpleadoDto buscarEmpleadoPorId(Long idEmpleado) {
        Empleado empleadoE = empleadoRepository.findById(idEmpleado)
                .orElseThrow(()->
                        new RecursoNoEncontradoException("Empleado con id" + idEmpleado + "no encontrado")
                );

        return empleadoMapper.toDto(empleadoE);
    }

    @Override
    public EmpleadoDto guardarEmpleado(EmpleadoToSaveDto empleado) {
        Empleado empleadoG = empleadoMapper.toEmpleadoSaveDtoToEntity(empleado);
        return empleadoMapper.toDto(empleadoRepository.save(empleadoG));
    }

    @Override
    public void eliminarEmpleado(Long idEmpleado) {
        Empleado empleado = empleadoRepository.findById(idEmpleado).orElseThrow(()->new RecursoNoEncontradoException("Empleado con id" + idEmpleado + "no encontrado"));
        empleadoRepository.delete(empleado);
    }

    @Override
    public EmpleadoDto editarEmpleado(Long idEmpleado, EmpleadoToSaveDto empleado) {
        return empleadoRepository.findById(idEmpleado)
        .map(empleadoAux->{
            empleadoAux.setCodigo(empleado.codigo());
            empleadoAux.setNombre(empleado.nombre());
            empleadoAux.setApellido(empleado.apellido());
            empleadoAux.setDireccion(empleado.direccion());
            empleadoAux.setTelefono(empleado.telefono());
            empleadoAux.setEmail(empleado.email());
            empleadoAux.setSueldo(empleado.sueldo());
            empleadoAux.setCargo(empleado.cargo());

            Empleado empleadoG = empleadoRepository.save(empleadoAux);
            return empleadoMapper.toDto(empleadoG);
        }).orElseThrow(()->new RecursoNoEncontradoException("Empleado con id" + idEmpleado + "no encontrado"));
    }

    @Override
    public List<EmpleadoDto> buscarEmpleadoPorDepartamento(String nombreDepartamento) {
        return empleadoRepository.findByCargo_Departamento_Nombre(nombreDepartamento)
                .stream()
                .map(empleado -> empleadoMapper.toDto(empleado))
                .toList();
    }

    @Override
    public List<EmpleadoDto> buscarEmpleadoPorCargo(String nombreCargo) {
        return empleadoRepository.findByCargo_Nombre(nombreCargo)
                .stream()
                .map(empleado -> empleadoMapper.toDto(empleado))
                .toList();
    }
}
