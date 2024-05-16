package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.UnidadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUnidadRepository extends JpaRepository<UnidadModel, Integer> {

    @Query(value = "select u.nombre from tramite as t " +
            "join unidad as u using(idUnidad) " +
            "group by t.idUnidad " +
            "having sum(t.costo)=( " +
            "select max(montoUnidad) " +
            "from(select sum(costo) as montoUnidad from tramite group by idUnidad) as subQuery)", nativeQuery = true)
    List<String> UnidadMasLucrativa();
}
