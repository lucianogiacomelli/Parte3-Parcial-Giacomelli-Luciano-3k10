package com.example.Parte1Parcial.services;

import com.example.Parte1Parcial.Dto.Estadisticas;
import com.example.Parte1Parcial.repositories.EstadisticasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EstadisticasService {

    @Autowired
    private EstadisticasRepository estadisticasRepository;

    public EstadisticasService (EstadisticasRepository estadisticasRepository){
        this.estadisticasRepository = estadisticasRepository;
    }

    @Transactional
    public Estadisticas getEstadisticas() throws Exception {
    try {
        long contadorMutante = estadisticasRepository.contadorMutante();
        long contadorHumano = estadisticasRepository.contadorHumano();
        double proporcion = estadisticasRepository.contadorMutante() / estadisticasRepository.contadorHumano();

        return new Estadisticas(contadorMutante, contadorHumano, proporcion);
    } catch (Exception e){
        throw new Exception(e.getMessage());
    }
    }

    }

