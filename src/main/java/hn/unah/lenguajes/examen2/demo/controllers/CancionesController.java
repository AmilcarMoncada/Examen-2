package hn.unah.lenguajes.examen2.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.examen2.demo.entities.Artista;
import hn.unah.lenguajes.examen2.demo.services.implementations.CancionesServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class CancionesController {
    
@Autowired
private CancionesServiceImpl cancionesServiceImpl;

    @DeleteMapping("/cancion/eliminar")
    public String EliminarCancion(@RequestParam int codigoCancion) {
        return this.cancionesServiceImpl.EliminarCancion(codigoCancion);
    }

    @PutMapping("/cancion/asociar")
    public Artista ArtistaAsociar(@RequestParam int codigoArtista,@RequestParam int codigoCancion) {
        return this.cancionesServiceImpl.AsociarCancionArtista(codigoArtista, codigoCancion);
    }

    @GetMapping("/cancion/obtener")
    public Artista ArtistaBuscado(@RequestParam String titulo) {
        return this.cancionesServiceImpl.ObtenerArtistaPorCancion(titulo);
    }
    
    
}
