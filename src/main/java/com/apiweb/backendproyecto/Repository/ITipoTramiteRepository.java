package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.TipoTramiteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ITipoTramiteRepository extends JpaRepository<TipoTramiteModel, Integer> {
    /**
     * Consulta nativa en la bd, devuelve el tipo de tramite mas recurrente.
     *
     *@return Retorna una lista de Map<String, Integer> donde el String es el tipo de tramite y el Integer es el numero de tramites con este tipo.
     */
    @Query (value = "select tp.tipo, count(idTipo) as num_registros from tramite " +
            "join tipo_tramite as tp using(idTipo) " +
            "group by idTipo " +
            "having count(idTipo)=( " +
            "  select max(numRegistros) " +
            "    from (select t.idTipo, count(t.idTipo) as numRegistros " +
            "          from tramite as t group by t.idTipo) as subQuery)", nativeQuery = true)
    List<Map<String, Integer>> TipoTramiteMasRecurrente();
}
