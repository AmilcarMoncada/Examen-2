package hn.unah.lenguajes.examen2.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="canciones")
public class Canciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigocancion")
    private int codigoCancion;

    private String titulo;

    private String album;

    @Column(name="anyolanzamiento")
    private int anyoLanzamiento;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "codigoartista",referencedColumnName ="codigoartista")
    private Artista artista;
}
