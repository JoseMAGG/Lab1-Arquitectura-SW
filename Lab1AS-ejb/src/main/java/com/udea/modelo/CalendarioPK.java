/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author saxss
 */
@Embeddable
public class CalendarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_facultad")
    private int idFacultad;

    public CalendarioPK() {
    }

    public CalendarioPK(String id, int idFacultad) {
        this.id = id;
        this.idFacultad = idFacultad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        hash += (int) idFacultad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalendarioPK)) {
            return false;
        }
        CalendarioPK other = (CalendarioPK) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        if (this.idFacultad != other.idFacultad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.CalendarioPK[ id=" + id + ", idFacultad=" + idFacultad + " ]";
    }
    
}
