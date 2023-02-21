package com.api.practica05api.servicios;

import com.api.practica05api.modelos.Piloto;
import com.api.practica05api.repositorios.PilotoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotoServicioImpl implements PilotoServicio {
    @Autowired
    private PilotoRepositorio pilotoRepositorio;

    @Override
    public List<Piloto> findAllPilotos() {
        return pilotoRepositorio.findAll();
    }

    @Override
    public Piloto findPiloto(String id) {
        return pilotoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Piloto createPiloto(Piloto piloto) {
        return pilotoRepositorio.save(piloto);
    }

    @Override
    public Piloto updatePiloto(Piloto piloto) {
        return pilotoRepositorio.save(piloto);
    }

    @Override
    public void deletePiloto(String id) {
        pilotoRepositorio.deleteById(id);
    }
}
