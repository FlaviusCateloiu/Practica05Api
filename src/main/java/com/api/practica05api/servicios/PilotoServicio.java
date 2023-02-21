package com.api.practica05api.servicios;

import com.api.practica05api.modelos.Piloto;

import java.util.List;

public interface PilotoServicio {
    List<Piloto> findAllPilotos();
    Piloto findPiloto(String id);
    Piloto createPiloto(Piloto piloto);
    Piloto updatePiloto(Piloto piloto);
    Piloto deletePiloto(String id);
}
