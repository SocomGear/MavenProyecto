/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gonzalez.mavenproyecto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author socom_000
 */
@Entity
@Table(name = "sueldo")
@NamedQueries({
    @NamedQuery(name = "Sueldo.findAll", query = "SELECT s FROM Sueldo s")})
public class Sueldo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sueldo")
    private Integer idSueldo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sueldo")
    private Float sueldo;
    @JoinColumn(name = "id_jugador", referencedColumnName = "id_jugador")
    @ManyToOne
    private Jugador idJugador;

    public Sueldo() {
    }

    public Sueldo(Integer idSueldo) {
        this.idSueldo = idSueldo;
    }
    
    public Sueldo(float sueldo, Jugador idJugador) {
        this.sueldo = sueldo;
        this.idJugador=idJugador;
    }
    public Integer getIdSueldo() {
        return idSueldo;
    }

    public void setIdSueldo(Integer idSueldo) {
        this.idSueldo = idSueldo;
    }

    public Float getSueldo() {
        return sueldo;
    }

    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }

    public Jugador getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugador idJugador) {
        this.idJugador = idJugador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSueldo != null ? idSueldo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sueldo)) {
            return false;
        }
        Sueldo other = (Sueldo) object;
        if ((this.idSueldo == null && other.idSueldo != null) || (this.idSueldo != null && !this.idSueldo.equals(other.idSueldo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gonzalez.mavenproyecto.Sueldo[ idSueldo=" + idSueldo + " ]";
    }
    
}
