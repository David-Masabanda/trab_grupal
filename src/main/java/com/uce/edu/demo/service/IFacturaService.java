package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaService {
	
	//CRUD
	public Factura consultar(Integer id);
	public void create(Factura f);
	public void update(Factura f);
	public void delete(Integer id);
	
	public BigDecimal calcularPrecio(Integer id);
	
	public int cantidad(Integer id);
	
	//Inner Join
	public List<Factura> buscarFacturaInnerJoin(BigDecimal precio);
	//Inner Outer Join Left
	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal precio);
	//Inner Outer Join Right
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad);
	
	//Where Join
	public List<Factura> buscarFacturaJoinWhere(BigDecimal precio);
	//Fetch Join
	public List<Factura> buscarFacturaJoinFetch(BigDecimal precio);


	
}
