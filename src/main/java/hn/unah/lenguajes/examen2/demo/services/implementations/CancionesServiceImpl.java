package hn.unah.lenguajes.examen2.demo.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.examen2.demo.entities.Artista;
import hn.unah.lenguajes.examen2.demo.entities.Canciones;
import hn.unah.lenguajes.examen2.demo.repositories.ArtistaRepository;
import hn.unah.lenguajes.examen2.demo.repositories.CancionesRepository;
import hn.unah.lenguajes.examen2.demo.services.CancionesService;


@Service
public class CancionesServiceImpl implements CancionesService{

    @Autowired
    private CancionesRepository cancionesRepository;

    @Autowired
    private ArtistaRepository artistaRepository;

    @Override
    public String EliminarCancion(int codigoCancion) {
    this.cancionesRepository.deleteById(codigoCancion);
    return "Cancion eliminada correctamente";
    }

    @Override
    public Artista AsociarCancionArtista(int codigoArtista, int codigoCancion) {
        if(this.artistaRepository.findById(codigoArtista)!=null){
            if(this.cancionesRepository.findById(codigoCancion)!=null){
                Canciones CancionAsociar = this.cancionesRepository.findById(codigoCancion).get();
                Artista ArtistaAsociar = this.artistaRepository.findById(codigoArtista).get();
                ArtistaAsociar.getCanciones().add(CancionAsociar);
                this.artistaRepository.save(ArtistaAsociar);
                return ArtistaAsociar;
        }
    }
    return null;
    }

    @Override
    public Artista ObtenerArtistaPorCancion(String nombre) {
      Canciones CancionBuscada= this.cancionesRepository.findByTitulo(nombre).get(0);
      Artista ArtistaBuscado= CancionBuscada.getArtista();
      return ArtistaBuscado;
    }
    
}
