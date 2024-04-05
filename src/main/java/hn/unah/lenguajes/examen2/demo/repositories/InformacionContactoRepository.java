package hn.unah.lenguajes.examen2.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes.examen2.demo.entities.InformacionContacto;

@Repository
public interface InformacionContactoRepository extends CrudRepository<InformacionContacto, Integer>{
    
}
