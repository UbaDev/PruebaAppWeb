package com.prueba.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.app.model.PersonaRepository;
import com.prueba.app.model.entities.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Service
public class DirectorioServiceImpl implements IDirectorioService {

    private PersonaRepository personaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public DirectorioServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }
    
    @Transactional
    @Override
    public List<Persona> findPersonas() {
        // TODO Auto-generated method stub
        return personaRepository.findAll();
    }

    @Transactional
    @Override
    public void deletePersonaByIdentification(Integer identificacion) {
        // TODO Auto-generated method stub
         personaRepository.deleteByIdentificacion(identificacion);
    }

    @Transactional
    @Override
    public Persona storePersona(Persona persona) {
        // TODO Auto-generated method stub
        return personaRepository.save(persona);
    }

    @Transactional
    @Override
    public Persona findPersonaByIdentification(Integer identificacion) {
        // TODO Auto-generated method stub
       return personaRepository.findByIdentificacion(identificacion);
    }
    
}
