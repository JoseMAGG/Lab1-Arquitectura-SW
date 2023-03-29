/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author saxss
 */
@Entity
@Table(name = "facultad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facultad.findAll", query = "SELECT f FROM Facultad f")
    , @NamedQuery(name = "Facultad.findById", query = "SELECT f FROM Facultad f WHERE f.id = :id")
    , @NamedQuery(name = "Facultad.findByNombre", query = "SELECT f FROM Facultad f WHERE f.nombre = :nombre")
    , @NamedQuery(name = "Facultad.findByIdDecano", query = "SELECT f FROM Facultad f WHERE f.idDecano = :idDecano")})
public class Facultad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_decano")
    private int idDecano;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facultad")
    private Collection<Calendario> calendarioCollection;

    public Facultad() {
    }

    public Facultad(Integer id) {
        this.id = id;
    }

    public Facultad(Integer id, String nombre, int idDecano) {
        this.id = id;
        this.nombre = nombre;
        this.idDecano = idDecano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDecano() {
        return idDecano;
    }

    public void setIdDecano(int idDecano) {
        this.idDecano = idDecano;
    }

    @XmlTransient
    public Collection<Calendario> getCalendarioCollection() {
        return calendarioCollection;
    }

    public void setCalendarioCollection(Collection<Calendario> calendarioCollection) {
        this.calendarioCollection = calendarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facultad)) {
            return false;
        }
        Facultad other = (Facultad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Facultad[ id=" + id + " ]";
    }
    
}
