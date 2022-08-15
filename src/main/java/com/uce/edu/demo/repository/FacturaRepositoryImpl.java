package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Factura;


@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	//CRUD----
	@Override
	public Factura consultar(Integer id) {
		return this.entityManager.find(Factura.class, id);
	}
	
	@Override
	public void create(Factura f) {
		this.entityManager.persist(f);
	}

	@Override
	public void update(Factura f) {
		this.entityManager.merge(f);
	}

	@Override
	public void delete(Integer id) {
		Factura f=this.consultar(id);
		this.entityManager.remove(f);
	}
	

	
	
	

	//---------
	//INNER JOIN
	@Override
	public List<Factura> buscarFacturaInnerJoin(BigDecimal precio) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN f.detalles d WHERE d.subtotal> :datoPrecio", 
				Factura.class);
		myQuery.setParameter("datoPrecio", precio);
		return myQuery.getResultList();
	}

	
	//OUTER JOIN LEFT
	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal precio) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(
				"SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE d.subtotal> : datoPrecio ", 
				Factura.class);
		myQuery.setParameter("datoPrecio", precio);
		return myQuery.getResultList();
	}


	//OUTER JOIN RIGHT
	@Override
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(
				"SELECT f FROM Factura f RIGHT JOIN f.detalles d WHERE d.cantidad> : datoCantidad ", 
				Factura.class);
		myQuery.setParameter("datoCantidad", cantidad);
		return myQuery.getResultList();
	}

	//WHERE JOIN 
	@Override
	public List<Factura> buscarFacturaJoinWhere(BigDecimal precio) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(
				"SELECT f FROM Factura f, Detalle d WHERE f.id=d.factura AND d.subtotal> :datoPrecio",
				Factura.class);
		myQuery.setParameter("datoPrecio", precio);
		return myQuery.getResultList();
	}

	//FETCH JOIN
	@Override
	public List<Factura> buscarFacturaJoinFetch(BigDecimal precio) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN FETCH f.detalles d WHERE d.subtotal> :datoPrecio",
				Factura.class);
		myQuery.setParameter("datoPrecio", precio);
		return myQuery.getResultList();
	}




}
