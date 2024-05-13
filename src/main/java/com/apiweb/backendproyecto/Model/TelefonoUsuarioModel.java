package com.apiweb.backendproyecto.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="telefono_usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefonoUsuarioModel {
    @Id
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioModel IdUsuario;

}
