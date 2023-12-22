package com.cocobolo.t4pascual.model.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="articulo")

public class Articulo implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "art_id")
    private Long id;

    @Column(name = "art_nombre")
    private String nombre;

    @Column(name = "art_precio")
    private Float precio;

    @Column(name = "art_fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fecha_registro;

    @Column(name = "art_imagen")
    private String imagen;
    
    @ManyToOne()
    @JoinColumn(name = "col_id")
    private Coleccion coleccion;

    @PrePersist
    private void registrarFecha(){
        this.fecha_registro = new Date();
    }
}
