# Detección de Mutantes - API

¡Te damos la bienvenida a **Detección de Mutantes**! Esta API REST permite analizar secuencias de ADN y determinar si pertenecen a un mutante. 

## Descripción

La API recibe una secuencia de ADN en un JSON enviado mediante una solicitud `POST`. A través de un algoritmo avanzado, la secuencia es evaluada para encontrar patrones específicos de mutantes, respondiendo si corresponde o no a un mutante. Además, puedes consultar las estadísticas de los análisis realizados utilizando una solicitud `GET`.

## Tecnologías Utilizadas

- **Java y Spring Boot**: Se usan para la gestión de la lógica de negocio y el procesamiento de las solicitudes HTTP.
- **H2 Database**: Base de datos en memoria, utilizada para almacenar las secuencias de ADN y los datos estadísticos temporalmente.
- **Postman**: Herramienta para realizar pruebas de los endpoints de la API.
- **Maven o Gradle**: Utilizada para la construcción y administración de dependencias del proyecto.
- **IntelliJ IDEA**: Entorno de desarrollo.

## Enlace de Despliegue

La API está actualmente en línea en Render. Puedes acceder a través de este enlace: https://parte3-parcial-giacomelli-luciano-3k10.onrender.com


## Endpoints Disponibles

### `POST /mutant`
Este endpoint recibe una secuencia de ADN en formato JSON y devuelve si corresponde a un mutante o no.

- **Ejemplo de Solicitud**:
  ```json
  {
    "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
  }

## Respuesta:

- `200 OK`: Si es un mutante.
- `403 Forbidden`: Si no es un mutante.

## GET /stats
Proporciona estadísticas sobre las secuencias de ADN analizadas, incluyendo el total de mutantes, el total de humanos y el ratio mutantes/humanos.


### Ejemplo en Postman
1. Abre Postman y selecciona el método POST.
2. Ingresa la URL de la API (ya sea local o el enlace de Render).
3. En la sección "Body", selecciona "raw" y elige el formato "JSON".
4. Copia el siguiente JSON para probar con una secuencia de mutante:
{
"dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}
6. Envía la solicitud y revisa la respuesta para verificar el resultado.


## Ejemplos de Secuencias de ADN
Mutante:
{
"prueba": ["AAAAA","TTTTT","GGGGG","GGGGG","GGGGG"]

}



## No Mutante:
{
"prueba": [
"ATGATG",
"GTCTTA",
"AATTGG",
"ACTAGT",
"GGATTC",
"AGGCAA"
]
}

## Pruebas Unitarias
El proyecto incluye pruebas unitarias para validar que el algoritmo de detección funcione correctamente en las distintas combinaciones de patrones (filas, columnas y diagonales), asegurando que los mutantes sean identificados con precisión.
