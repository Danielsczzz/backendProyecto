package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.UnidadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;


public interface IUnidadRepository extends JpaRepository<UnidadModel, Integer> {

    /**
     * Metodo que obtiene la unidad que mas dinero genera
     *
     *@return Retorna Map<String, Double> donde el String es el nombre de la unidad y el Double es el monto.
     */
    @Query(value = "select u.nombre, sum(t.costo) as monto from tramite as t " +
            "join unidad as u using(idUnidad) " +
            "group by t.idUnidad " +
            "having sum(t.costo)=( " +
            "select max(montoUnidad) " +
            "from(select sum(costo) as montoUnidad from tramite group by idUnidad) as subQuery)", nativeQuery = true)
    List<Map<String, Double>> UnidadMasLucrativa();
}
