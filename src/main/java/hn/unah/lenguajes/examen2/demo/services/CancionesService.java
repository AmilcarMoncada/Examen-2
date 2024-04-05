package hn.unah.lenguajes.examen2.demo.services;

import hn.unah.lenguajes.examen2.demo.entities.Artista;

public interface CancionesService {
  
public String EliminarCancion (int codigoCancion);

public Artista AsociarCancionArtista (int codigoArtista, int codigoCancion);

public Artista ObtenerArtistaPorCancion (String nombre);
    
}
