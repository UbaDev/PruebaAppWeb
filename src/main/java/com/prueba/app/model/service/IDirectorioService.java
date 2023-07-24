package com.prueba.app.model.service;

import java.util.List;

import com.prueba.app.model.entities.Persona;

public interface IDirectorioService {

    Persona findPersonaByIdentification(Integer identificacion);
    List <Persona> findPersonas();
    void deletePersonaByIdentification(Integer identificacion);
    Persona storePersona(Persona persona);
    
}
