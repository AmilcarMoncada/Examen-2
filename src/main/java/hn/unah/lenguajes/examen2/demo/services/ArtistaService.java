package hn.unah.lenguajes.examen2.demo.services;

import java.util.List;

import hn.unah.lenguajes.examen2.demo.entities.Artista;
import hn.unah.lenguajes.examen2.demo.entities.Canciones;
import hn.unah.lenguajes.examen2.demo.entities.InformacionContacto;

public interface ArtistaService {
    
    public Artista CrearArtista (Artista artista);

    public String EliminarArtista (int codigoArtista);

    public Artista BuscarArtista (int codigoArtista);

    public Artista ActualizarArtista (InformacionContacto informacionContacto, int codigoArtista);

    public List<Artista> ObtenerArtistas ();

    public List<Canciones> CancionesDeArtista(int codigoArtista);
}
