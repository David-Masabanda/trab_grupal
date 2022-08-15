package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	private static Logger LOG =Logger.getLogger(HotelRepositoryImpl.class);
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Hotel> buscarHoteles(String tipo) {
		//SELECT * FROM Hotel h INNER JOIN Habitacion ha ON h.hote_id=ha.hab_id_hotel WHERE ha.hab_tipo='Suite'
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo= :datoTipo",
				Hotel.class);
		myQuery.setParameter("datoTipo", tipo);
		return myQuery.getResultList();
	}
	
	@Override
	public Hotel buscarHotel(String tipo) {
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo= :datoTipo",
				Hotel.class);
		myQuery.setParameter("datoTipo", tipo);
		return myQuery.getSingleResult();
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo= :tipoHabitacion", 
				Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		List<Hotel> hoteles=myQuery.getResultList();
		for(Hotel h: hoteles) {
			h.getHabitaciones().size();
		}
		return hoteles;
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin2() {
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN h.habitaciones ha", 
				Hotel.class);
		return myQuery.getResultList();
	}

	//LEFT JOIN ----------
	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery(
				"SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo= :tipoHabitacion", 
				Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Hotel> buscarHotelOuterJoinLeft2() {
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery(
				"SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha", 
				Hotel.class);
		return myQuery.getResultList();
	}

	
	//RIGHT JOIN ----------
	@Override
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery(
				"SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo= :tipoHabitacion", 
				Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	
	
	//WHERE
	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery(
				"SELECT h FROM Hotel h, Habitacion ha WHERE h.id= ha.hotel AND ha.tipo =:tipoHabitacion",
				Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	//FETCH
	@Override
	//@Transactional(value = TxType.MANDATORY)
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		LOG.info("Funciona: "+ org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive());
		
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo =:tipoHabitacion", 
				Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public void insertar(Hotel h) {
		this.entityManager.persist(h);
		
	}

	@Override
	public Hotel buscar(Integer id) {
		
		return this.entityManager.find(Hotel.class, id);
	}








}
