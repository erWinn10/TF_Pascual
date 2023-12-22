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
@Table(name="pedidos")
public class Pedido implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ped_id")
    private Long id;

    @Column(name = "ped_cantidad")
    private Integer cantidad;

    @Column(name = "ped_fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fecha_registro;

    @ManyToOne()
    @JoinColumn(name = "art_id")
    private Articulo articulo;

    @PrePersist
    private void registrarFecha(){
        this.fecha_registro = new Date();
    }
}
