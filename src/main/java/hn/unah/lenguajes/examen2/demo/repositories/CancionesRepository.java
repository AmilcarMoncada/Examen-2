package hn.unah.lenguajes.examen2.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes.examen2.demo.entities.Canciones;
import java.util.List;


@Repository
public interface CancionesRepository extends CrudRepository<Canciones, Integer>{

    public List<Canciones> findByTitulo(String titulo);
    
}
