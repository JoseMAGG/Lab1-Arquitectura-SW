/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saxss
 */
@Entity
@Table(name = "calendario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendario.findAll", query = "SELECT c FROM Calendario c")
    , @NamedQuery(name = "Calendario.findById", query = "SELECT c FROM Calendario c WHERE c.calendarioPK.id = :id")
    , @NamedQuery(name = "Calendario.findByIdFacultad", query = "SELECT c FROM Calendario c WHERE c.calendarioPK.idFacultad = :idFacultad")
    , @NamedQuery(name = "Calendario.findByIdAprobador", query = "SELECT c FROM Calendario c WHERE c.idAprobador = :idAprobador")
    , @NamedQuery(name = "Calendario.findByPublicacionOferta", query = "SELECT c FROM Calendario c WHERE c.publicacionOferta = :publicacionOferta")
    , @NamedQuery(name = "Calendario.findByInicioMatriculas", query = "SELECT c FROM Calendario c WHERE c.inicioMatriculas = :inicioMatriculas")
    , @NamedQuery(name = "Calendario.findByFinMatriculas", query = "SELECT c FROM Calendario c WHERE c.finMatriculas = :finMatriculas")
    , @NamedQuery(name = "Calendario.findByInicioAjustes", query = "SELECT c FROM Calendario c WHERE c.inicioAjustes = :inicioAjustes")
    , @NamedQuery(name = "Calendario.findByFinAjustes", query = "SELECT c FROM Calendario c WHERE c.finAjustes = :finAjustes")
    , @NamedQuery(name = "Calendario.findByInicioClases", query = "SELECT c FROM Calendario c WHERE c.inicioClases = :inicioClases")
    , @NamedQuery(name = "Calendario.findByFinClases", query = "SELECT c FROM Calendario c WHERE c.finClases = :finClases")
    , @NamedQuery(name = "Calendario.findByInicioExamenesFinales", query = "SELECT c FROM Calendario c WHERE c.inicioExamenesFinales = :inicioExamenesFinales")
    , @NamedQuery(name = "Calendario.findByFinExamenesFinales", query = "SELECT c FROM Calendario c WHERE c.finExamenesFinales = :finExamenesFinales")
    , @NamedQuery(name = "Calendario.findByInicioValidaciones", query = "SELECT c FROM Calendario c WHERE c.inicioValidaciones = :inicioValidaciones")
    , @NamedQuery(name = "Calendario.findByFinValidaciones", query = "SELECT c FROM Calendario c WHERE c.finValidaciones = :finValidaciones")
    , @NamedQuery(name = "Calendario.findByInicioHabilitaciones", query = "SELECT c FROM Calendario c WHERE c.inicioHabilitaciones = :inicioHabilitaciones")
    , @NamedQuery(name = "Calendario.findByFinHabilitaciones", query = "SELECT c FROM Calendario c WHERE c.finHabilitaciones = :finHabilitaciones")
    , @NamedQuery(name = "Calendario.findByTerminacionOficial", query = "SELECT c FROM Calendario c WHERE c.terminacionOficial = :terminacionOficial")})
public class Calendario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CalendarioPK calendarioPK;
    @Size(max = 15)
    @Column(name = "id_aprobador")
    private String idAprobador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "publicacion_oferta")
    @Temporal(TemporalType.DATE)
    private Date publicacionOferta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicio_matriculas")
    @Temporal(TemporalType.DATE)
    private Date inicioMatriculas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fin_matriculas")
    @Temporal(TemporalType.DATE)
    private Date finMatriculas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicio_ajustes")
    @Temporal(TemporalType.DATE)
    private Date inicioAjustes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fin_ajustes")
    @Temporal(TemporalType.DATE)
    private Date finAjustes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicio_clases")
    @Temporal(TemporalType.DATE)
    private Date inicioClases;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fin_clases")
    @Temporal(TemporalType.DATE)
    private Date finClases;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicio_examenes_finales")
    @Temporal(TemporalType.DATE)
    private Date inicioExamenesFinales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fin_examenes_finales")
    @Temporal(TemporalType.DATE)
    private Date finExamenesFinales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicio_validaciones")
    @Temporal(TemporalType.DATE)
    private Date inicioValidaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fin_validaciones")
    @Temporal(TemporalType.DATE)
    private Date finValidaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicio_habilitaciones")
    @Temporal(TemporalType.DATE)
    private Date inicioHabilitaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fin_habilitaciones")
    @Temporal(TemporalType.DATE)
    private Date finHabilitaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "terminacion_oficial")
    @Temporal(TemporalType.DATE)
    private Date terminacionOficial;
    @JoinColumn(name = "id_facultad", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Facultad facultad;

    public Calendario() {
    }

    public Calendario(CalendarioPK calendarioPK) {
        this.calendarioPK = calendarioPK;
    }

    public Calendario(CalendarioPK calendarioPK, Date publicacionOferta, Date inicioMatriculas, Date finMatriculas, Date inicioAjustes, Date finAjustes, Date inicioClases, Date finClases, Date inicioExamenesFinales, Date finExamenesFinales, Date inicioValidaciones, Date finValidaciones, Date inicioHabilitaciones, Date finHabilitaciones, Date terminacionOficial) {
        this.calendarioPK = calendarioPK;
        this.publicacionOferta = publicacionOferta;
        this.inicioMatriculas = inicioMatriculas;
        this.finMatriculas = finMatriculas;
        this.inicioAjustes = inicioAjustes;
        this.finAjustes = finAjustes;
        this.inicioClases = inicioClases;
        this.finClases = finClases;
        this.inicioExamenesFinales = inicioExamenesFinales;
        this.finExamenesFinales = finExamenesFinales;
        this.inicioValidaciones = inicioValidaciones;
        this.finValidaciones = finValidaciones;
        this.inicioHabilitaciones = inicioHabilitaciones;
        this.finHabilitaciones = finHabilitaciones;
        this.terminacionOficial = terminacionOficial;
    }

    public Calendario(String id, int idFacultad) {
        this.calendarioPK = new CalendarioPK(id, idFacultad);
    }

    public CalendarioPK getCalendarioPK() {
        return calendarioPK;
    }

    public void setCalendarioPK(CalendarioPK calendarioPK) {
        this.calendarioPK = calendarioPK;
    }

    public String getIdAprobador() {
        return idAprobador;
    }

    public void setIdAprobador(String idAprobador) {
        this.idAprobador = idAprobador;
    }

    public Date getPublicacionOferta() {
        return publicacionOferta;
    }

    public void setPublicacionOferta(Date publicacionOferta) {
        this.publicacionOferta = publicacionOferta;
    }

    public Date getInicioMatriculas() {
        return inicioMatriculas;
    }

    public void setInicioMatriculas(Date inicioMatriculas) {
        this.inicioMatriculas = inicioMatriculas;
    }

    public Date getFinMatriculas() {
        return finMatriculas;
    }

    public void setFinMatriculas(Date finMatriculas) {
        this.finMatriculas = finMatriculas;
    }

    public Date getInicioAjustes() {
        return inicioAjustes;
    }

    public void setInicioAjustes(Date inicioAjustes) {
        this.inicioAjustes = inicioAjustes;
    }

    public Date getFinAjustes() {
        return finAjustes;
    }

    public void setFinAjustes(Date finAjustes) {
        this.finAjustes = finAjustes;
    }

    public Date getInicioClases() {
        return inicioClases;
    }

    public void setInicioClases(Date inicioClases) {
        this.inicioClases = inicioClases;
    }

    public Date getFinClases() {
        return finClases;
    }

    public void setFinClases(Date finClases) {
        this.finClases = finClases;
    }

    public Date getInicioExamenesFinales() {
        return inicioExamenesFinales;
    }

    public void setInicioExamenesFinales(Date inicioExamenesFinales) {
        this.inicioExamenesFinales = inicioExamenesFinales;
    }

    public Date getFinExamenesFinales() {
        return finExamenesFinales;
    }

    public void setFinExamenesFinales(Date finExamenesFinales) {
        this.finExamenesFinales = finExamenesFinales;
    }

    public Date getInicioValidaciones() {
        return inicioValidaciones;
    }

    public void setInicioValidaciones(Date inicioValidaciones) {
        this.inicioValidaciones = inicioValidaciones;
    }

    public Date getFinValidaciones() {
        return finValidaciones;
    }

    public void setFinValidaciones(Date finValidaciones) {
        this.finValidaciones = finValidaciones;
    }

    public Date getInicioHabilitaciones() {
        return inicioHabilitaciones;
    }

    public void setInicioHabilitaciones(Date inicioHabilitaciones) {
        this.inicioHabilitaciones = inicioHabilitaciones;
    }

    public Date getFinHabilitaciones() {
        return finHabilitaciones;
    }

    public void setFinHabilitaciones(Date finHabilitaciones) {
        this.finHabilitaciones = finHabilitaciones;
    }

    public Date getTerminacionOficial() {
        return terminacionOficial;
    }

    public void setTerminacionOficial(Date terminacionOficial) {
        this.terminacionOficial = terminacionOficial;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calendarioPK != null ? calendarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendario)) {
            return false;
        }
        Calendario other = (Calendario) object;
        if ((this.calendarioPK == null && other.calendarioPK != null) || (this.calendarioPK != null && !this.calendarioPK.equals(other.calendarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Calendario[ calendarioPK=" + calendarioPK + " ]";
    }
    
}
