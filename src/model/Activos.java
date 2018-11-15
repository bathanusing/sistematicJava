/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PERSONAL
 */
@Entity
@Table(name = "activos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activos.findAll", query = "SELECT a FROM Activos a"),
    @NamedQuery(name = "Activos.findByIdproducto", query = "SELECT a FROM Activos a WHERE a.idproducto = :idproducto"),
    @NamedQuery(name = "Activos.findByCodigo", query = "SELECT a FROM Activos a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Activos.findByArticulo", query = "SELECT a FROM Activos a WHERE a.articulo = :articulo"),
    @NamedQuery(name = "Activos.findByNumeroSer", query = "SELECT a FROM Activos a WHERE a.numeroSer = :numeroSer"),
    @NamedQuery(name = "Activos.findByMarca", query = "SELECT a FROM Activos a WHERE a.marca = :marca"),
    @NamedQuery(name = "Activos.findByFecha", query = "SELECT a FROM Activos a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Activos.findByPrecioCom", query = "SELECT a FROM Activos a WHERE a.precioCom = :precioCom"),
    @NamedQuery(name = "Activos.findByPrecioAct", query = "SELECT a FROM Activos a WHERE a.precioAct = :precioAct"),
    @NamedQuery(name = "Activos.findByMoneda", query = "SELECT a FROM Activos a WHERE a.moneda = :moneda"),
    @NamedQuery(name = "Activos.findByPeso", query = "SELECT a FROM Activos a WHERE a.peso = :peso"),
    @NamedQuery(name = "Activos.findByUbicacion", query = "SELECT a FROM Activos a WHERE a.ubicacion = :ubicacion")})
public class Activos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Integer idproducto;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "articulo")
    private String articulo;
    @Column(name = "numero_ser")
    private String numeroSer;
    @Column(name = "marca")
    private String marca;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_com")
    private Double precioCom;
    @Column(name = "precio_act")
    private Double precioAct;
    @Column(name = "moneda")
    private String moneda;
    @Column(name = "peso")
    private Double peso;
    @Column(name = "ubicacion")
    private String ubicacion;

    public Activos() {
    }

    public Activos(String codigo, String articulo, String numeroSer, String marca, Date fecha, Double precioCom, Double precioAct, String moneda, Double peso, String ubicacion) {
        this.codigo = codigo;
        this.articulo = articulo;
        this.numeroSer = numeroSer;
        this.marca = marca;
        this.fecha = fecha;
        this.precioCom = precioCom;
        this.precioAct = precioAct;
        this.moneda = moneda;
        this.peso = peso;
        this.ubicacion = ubicacion;
    }

    public Activos(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getNumeroSer() {
        return numeroSer;
    }

    public void setNumeroSer(String numeroSer) {
        this.numeroSer = numeroSer;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPrecioCom() {
        return precioCom;
    }

    public void setPrecioCom(Double precioCom) {
        this.precioCom = precioCom;
    }

    public Double getPrecioAct() {
        return precioAct;
    }

    public void setPrecioAct(Double precioAct) {
        this.precioAct = precioAct;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activos)) {
            return false;
        }
        Activos other = (Activos) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.Activos[ idproducto=" + idproducto + " ]";
    }
    
}
