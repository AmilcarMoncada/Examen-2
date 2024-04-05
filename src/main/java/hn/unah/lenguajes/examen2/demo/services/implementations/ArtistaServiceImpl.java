package hn.unah.lenguajes.examen2.demo.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.examen2.demo.entities.Artista;
import hn.unah.lenguajes.examen2.demo.entities.Canciones;
import hn.unah.lenguajes.examen2.demo.entities.InformacionContacto;
import hn.unah.lenguajes.examen2.demo.repositories.ArtistaRepository;
import hn.unah.lenguajes.examen2.demo.repositories.CancionesRepository;
import hn.unah.lenguajes.examen2.demo.repositories.InformacionContactoRepository;
import hn.unah.lenguajes.examen2.demo.services.ArtistaService;


@Service
public class ArtistaServiceImpl implements ArtistaService{

    @Autowired
    private ArtistaRepository artistaRepository;
    
    @Autowired
    private CancionesRepository cancionesRepository;

    @Autowired
    private InformacionContactoRepository informacionContactoRepository;

    @Override
    public Artista CrearArtista(Artista artista) {
    return this.artistaRepository.save(artista);
    }

    @Override
    public String EliminarArtista(int codigoArtista) {
        Artista artistaEliminar = this.artistaRepository.findById(codigoArtista).get();
        InformacionContacto contactoArtistaEliminar= artistaEliminar.getInformacionContacto();
        List<Canciones> cancionesEliminar = artistaEliminar.getCanciones();
       this.informacionContactoRepository.deleteById(contactoArtistaEliminar.getCodigoContacto());
       for (Canciones cancionEliminar : cancionesEliminar) {
        this.cancionesRepository.delete(cancionEliminar);
       }
       this.artistaRepository.deleteById(codigoArtista);
       return "Artista, Informacion y Canciones Eliminadas Correctamente";
    }


    @Override
    public Artista BuscarArtista(int codigoArtista) {
      return this.artistaRepository.findById(codigoArtista).get();
    }

    @Override
    public Artista ActualizarArtista(InformacionContacto informacionContacto, int codigoArtista) {
      Artista artistaActualizar = this.artistaRepository.findById(codigoArtista).get();
      InformacionContacto contactoActualizar = artistaActualizar.getInformacionContacto();
      contactoActualizar.setCiudad(informacionContacto.getCiudad());
      contactoActualizar.setCorreo(informacionContacto.getCorreo());
      contactoActualizar.setPais(informacionContacto.getPais());
      contactoActualizar.setTelefono(informacionContacto.getTelefono());
      artistaActualizar.setInformacionContacto(contactoActualizar);
      this.artistaRepository.save(artistaActualizar);
      return artistaActualizar;
    }

    @Override
    public List<Artista> ObtenerArtistas() {
        return (List<Artista>) this.artistaRepository.findAll();
    }

    @Override
    public List<Canciones> CancionesDeArtista(int codigoArtista) {
        Artista artistaCanciones =this.artistaRepository.findById(codigoArtista).get();
        List<Canciones> CancionesArtista = artistaCanciones.getCanciones();
        return CancionesArtista;
    }
    
}
