package com.prueba.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.app.model.entities.Persona;
import com.prueba.app.model.service.DirectorioServiceImpl;
import com.prueba.app.model.service.IDirectorioService;

@RestController
@RequestMapping("/api")
public class DirectorioController {



    @Autowired
    private DirectorioServiceImpl directorioService;
    
    @PostMapping("/agregar-persona")
    public ResponseEntity<Persona> crearFactura(@RequestBody Persona persona) {

        Persona personaGuardada = directorioService.storePersona(persona);

        if (personaGuardada != null) {
            return new ResponseEntity<>(personaGuardada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/persona/{indentificacion}")
    public ResponseEntity<Persona> encontrarPersonaPorIdentificacion(@PathVariable int indentificacion) {
        Persona persona = directorioService.findPersonaByIdentification(indentificacion);

        if (persona != null) {
            return new ResponseEntity<>(persona, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/personas")
    public ResponseEntity<List<Persona>> encontrarTodasLasPersonas() {
        List<Persona> personas = directorioService.findPersonas();

        if (!personas.isEmpty()) {
            return new ResponseEntity<>(personas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/borrar-persona/{identificacion}")
    public ResponseEntity<Void> eliminarPersonaPorIdentificacion(@PathVariable int identificacion) {
        directorioService.deletePersonaByIdentification(identificacion);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
