package com.example.Parte1Parcial.controller;

import com.example.Parte1Parcial.services.EstadisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticasControlador {
    @Autowired
    private EstadisticasService estadisticasService;

    @GetMapping("/stats")
    public ResponseEntity<?> getEstadisticas(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estadisticasService.getEstadisticas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
}
