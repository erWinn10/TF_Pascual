package com.cocobolo.t4pascual.model.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "correo")

public class Correo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cor_id")
    private Long id;

    @Column(name = "cor_direccion")
    private String direccion;

    @Column(name = "cor_fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fecha_registro;

    @PrePersist
    private void registrarFecha(){
        this.fecha_registro = new Date();
    }
}
