package com.api.practica05api.controladores;

import com.api.practica05api.modelos.Piloto;
import com.api.practica05api.servicios.PilotoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebController {

    @Autowired
    private PilotoServicio pilotoServicio;

    //MongoDB Pilotos

    @GetMapping(value = "/api/pilotos")
    public ResponseEntity<List<Piloto>> getPilotos() {
        return ResponseEntity.ok(pilotoServicio.findAllPilotos());
    }

    @GetMapping(value = "/api/pilotos/{id}")
    public ResponseEntity<Piloto> getPiloto(@PathVariable("id") String id) {
        return ResponseEntity.ok(pilotoServicio.findPiloto(id));
    }

    @PostMapping(value = "/api/pilotos")
    public ResponseEntity<Piloto> addPiloto(@RequestBody Piloto piloto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pilotoServicio.createPiloto(piloto));
    }

    @PutMapping(value = "/api/pilotos/{id}")
    public ResponseEntity<Piloto> updatePiloto(@PathVariable("id") String id, @RequestBody Piloto piloto) {
        Piloto pilotoExistente = pilotoServicio.findPiloto(piloto.getId());

        if (pilotoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(pilotoServicio.updatePiloto(piloto));
    }

    @DeleteMapping(value = "/api/pilotos/{id}")
    public ResponseEntity<Piloto> removePiloto(@PathVariable("id") String id) {
        return ResponseEntity.ok(pilotoServicio.deletePiloto(id));
    }
}
