package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="detalle")
public class Detalle {
	
	@Id
	@Column(name="det_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="det_id_seq" )
	@SequenceGenerator(name="det_id_seq", sequenceName = "det_id_seq", allocationSize =1 )
	private Integer id;
	
	@Column(name="det_nombre")
	private String nombre;
	
	@Column(name="det_cantidad")
	private Integer cantidad;
	
	@Column(name="det_precio")
	private BigDecimal precio;
	
	@ManyToOne
	@JoinColumn(name="det_fact_id" )
	private Factura factura;
	
	
	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}








	
	
}
