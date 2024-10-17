package com.example.Parte1Parcial.Dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor

public class Estadisticas {
    private long contadorMutanteADN;

    private long contadorHumanoADN;

    private double proporcion;
}
