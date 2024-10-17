package com.example.Parte1Parcial.services;
import com.example.Parte1Parcial.entities.PruebasADN;
import com.example.Parte1Parcial.repositories.mutanteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.example.Parte1Parcial.entities.Algoritmo.mutantePrueba;

import java.util.List;
import java.util.Optional;


@Service
public class mutanteService implements BaseService<PruebasADN> {

    private mutanteRepository mutanteRepository;
    private mutantePrueba mutantePrueba;
    public mutanteService(mutanteRepository mutanteRepository, mutantePrueba mutanteprueba){
        this.mutanteRepository = mutanteRepository;
        this.mutantePrueba = mutanteprueba;
    }



    @Override
    @Transactional
    public List<PruebasADN> findAll() throws Exception {
    try{
        List <PruebasADN> entities = mutanteRepository.findAll();
        return entities;

    } catch (Exception e){
        throw new Exception(e.getMessage());
    }
    }

    @Override
    @Transactional
    public PruebasADN findByID(Long id) throws Exception {
        try{
            Optional<PruebasADN> entityOptional = mutanteRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }




    @Override
    @Transactional
    public PruebasADN save(PruebasADN entity) throws Exception {
        try{
            boolean esMutante = new mutantePrueba().esMutante(entity.getPrueba());
            entity.setResultado(esMutante);

            entity = mutanteRepository.save(entity);
            return entity;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public PruebasADN update(Long id, PruebasADN entity) throws Exception {
        try{
            Optional <PruebasADN> entityOptional = mutanteRepository.findById(id);
            PruebasADN pruebas = entityOptional.get();
            pruebas = mutanteRepository.save(entity);
            return pruebas;

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if (mutanteRepository.existsById(id)){
                mutanteRepository.deleteById(id);
                return true;
            }
            else {
                throw new Exception();
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


@Transactional
public boolean mutant(String[] dna) throws Exception {
    // No capture excepciones en este servicio, para hacerlo en el controlador debido a los errores de matriciales
    return mutantePrueba.esMutante(dna);
}

}
