package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.TipoTramiteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITipoTramiteRepository extends JpaRepository<TipoTramiteModel, Integer> {
    @Query (value = "select tp.tipo from tramite " +
            "join tipo_tramite as tp using(idTipo) " +
            "group by idTipo " +
            "having count(idTipo)=( " +
            "  select max(numRegistros) " +
            "    from (select t.idTipo, count(t.idTipo) as numRegistros " +
            "          from tramite as t group by t.idTipo) as subQuery)", nativeQuery = true)
    List<String> TipoTramiteMasRecurrente();
}
