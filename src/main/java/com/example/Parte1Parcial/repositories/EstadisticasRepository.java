package com.example.Parte1Parcial.repositories;

import com.example.Parte1Parcial.entities.PruebasADN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstadisticasRepository extends JpaRepository<PruebasADN, Long> {
    @Query("SELECT COUNT(p) FROM PruebasADN p WHERE p.resultado = true")
    int contadorMutante();

    @Query("SELECT COUNT(p) FROM PruebasADN p WHERE p.resultado = false")
    int contadorHumano();
}
