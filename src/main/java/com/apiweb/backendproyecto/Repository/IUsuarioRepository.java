package com.apiweb.backendproyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apiweb.backendproyecto.Model.UsuarioModel;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    @Query(value = "select u.nombre, count(idSolicitud) as numero_solicitudes from solicitud as s " +
            "join usuario as u using(idUsuario) " +
            "group by s.idUsuario " +
            "having count(idSolicitud) = ( " +
            "select max(numRegistros) " +
            "    from(select count(s.idSolicitud) as numRegistros " +
            "    from solicitud as s group by idUsuario) as subquery)", nativeQuery = true)
    List<Map<String, Integer>> UsuarioConMasSolicitudes();
}
