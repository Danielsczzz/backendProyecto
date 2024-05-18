package com.apiweb.backendproyecto.Repository;

import com.apiweb.backendproyecto.Model.ReciboModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReciboRepository extends JpaRepository<ReciboModel, Integer> {
}
