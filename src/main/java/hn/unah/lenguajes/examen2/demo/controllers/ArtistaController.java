package hn.unah.lenguajes.examen2.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.examen2.demo.entities.Artista;
import hn.unah.lenguajes.examen2.demo.entities.Canciones;
import hn.unah.lenguajes.examen2.demo.entities.InformacionContacto;
import hn.unah.lenguajes.examen2.demo.services.implementations.ArtistaServiceImpl;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;






@RestController
@RequestMapping("/api")
public class ArtistaController {
    
    @Autowired
    private ArtistaServiceImpl artistaServiceImpl;

    @PostMapping("/artista/crear")
    public Artista CrearArtista(@RequestBody Artista artista){
        return this.artistaServiceImpl.CrearArtista(artista);
    }

    @DeleteMapping("/artista/eliminar")
        public String EliminarArtista(@RequestParam int codigoArtista){
            return this.artistaServiceImpl.EliminarArtista(codigoArtista);
    }

    @PutMapping("/artista/actualizar/{codigoArtista}")
    public Artista ActualizarArtista(@PathVariable int codigoArtista, @RequestBody InformacionContacto informacionContacto) {
        return this.artistaServiceImpl.ActualizarArtista(informacionContacto, codigoArtista);
    }

    @GetMapping("/artista/buscar")
    public Artista BuscarArtista(@RequestParam int codigoArtista) {
        return this.artistaServiceImpl.BuscarArtista(codigoArtista);
    }

    @GetMapping("/artista/obtener")
    public List<Artista> ObtenerArtistas() {
        return this.artistaServiceImpl.ObtenerArtistas();
    }

    @GetMapping("/artista/canciones")
    public List<Canciones> CancionesDeArtista(@RequestParam int codigoArtista) {
        return this.artistaServiceImpl.CancionesDeArtista(codigoArtista);
    }
    

    
    

}
