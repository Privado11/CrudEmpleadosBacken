package com.empleados.recursos_humanos.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "empleados")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    private String direccion;
    private String telefono;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String departamento;

    private Double sueldo;

    @ManyToOne
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;
}
