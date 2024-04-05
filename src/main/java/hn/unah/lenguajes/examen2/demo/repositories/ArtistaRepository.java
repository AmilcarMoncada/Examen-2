package hn.unah.lenguajes.examen2.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes.examen2.demo.entities.Artista;

@Repository
public interface ArtistaRepository extends CrudRepository<Artista, Integer>{
    
}
