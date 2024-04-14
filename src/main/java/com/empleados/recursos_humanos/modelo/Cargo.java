package com.empleados.recursos_humanos.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "cargos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "cargo")
    private List<Empleado> empleados;

    @ManyToOne
    @JoinColumn(name = "id_departamento", nullable = false)
    private Departamento departamento;
}
