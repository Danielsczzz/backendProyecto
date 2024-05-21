package com.apiweb.backendproyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apiweb.backendproyecto.Model.UsuarioModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    /**
     * Consulta nativa en la bd, devuleve el usuario con mas solicitudes.
     *
     *@return Retorna una lista de Maps<String, Integer> donde el String es el nombre del usuario y el Integer es la cantidad de solicitudes;
     */
    @Query(value = "select u.nombre, count(idSolicitud) as numero_solicitudes from solicitud as s " +
            "join usuario as u using(idUsuario) " +
            "group by s.idUsuario " +
            "having count(idSolicitud) = ( " +
            "select max(numRegistros) " +
            "    from(select count(s.idSolicitud) as numRegistros " +
            "    from solicitud as s group by idUsuario) as subquery)", nativeQuery = true)
    List<Map<String, Integer>> UsuarioConMasSolicitudes();

    /**
     * Consulta nativa en la bd, devuleve un objeto con la informacion del usuario para el reporte.
     *
     *@param usuarioId el id del usuario a consultar
     *
     *@return Retorna un array de objetos con el idUsuario, nombre y correo;
     */
    @Query(value = "select nombre, correo, profesion " +
            "from usuario where idUsuario=:usuarioId",
            nativeQuery = true)
    Object[] infoUsuario(@Param("usuarioId") int usuarioId);

    /**
     * Consulta nativa en la bd,
     *
     * @param usuarioId el id del usuario a consultar
     * @return Retorna un array de objetos con el idUsuario, nombre y correo;
     */
    @Query(value = "select count(idSolicitud) as numero_solicitudes " +
            "from solicitud as s " +
            "join usuario as u using(idUsuario) " +
            "where u.idUsuario =:usuarioId " +
            "group by s.idUsuario",
            nativeQuery = true)
    Object[] cantidadSolicitudesDeUsuario(@Param("usuarioId") int usuarioId);

    /**
     * Consulta nativa en la bd, cuanto ha facturado en solicitudes el usuario.
     *
     * @param usuarioId el id del usuario a consultar
     * @return Retorna un array de objetos con el idUsuario, nombre y correo;
     */
    @Query(value = "select sum(t.costo) as cant_facturado from usuario as u " +
            "join solicitud as s using(idUsuario) " +
            "join tramite as t using(idTramite) " +
            "where u.idUsuario =:usuarioId " +
            "group by u.idUsuario",
            nativeQuery = true)
    Object[] cantidadFacturadoDeUsuario(@Param("usuarioId") int usuarioId);

}
