package com.apiweb.backendproyecto.Model;
import com.apiweb.backendproyecto.Model.ENUM.Profesion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String correo;

    @Column(name = "profesion", nullable = false)
    @Enumerated(EnumType.STRING)
    private Profesion profesion;
}
