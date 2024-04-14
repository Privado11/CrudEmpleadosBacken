package com.empleados.recursos_humanos.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "departamentos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @OneToOne
    @JoinColumn(name = "id_jefe")
    private Empleado empleado;

    @OneToMany(mappedBy = "departamento")
    private List<Cargo> cargos;
}
