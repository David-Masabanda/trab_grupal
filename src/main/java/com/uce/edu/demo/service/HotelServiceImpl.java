package com.uce.edu.demo.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{
	
	private static Logger LOG =Logger.getLogger(HotelServiceImpl.class);
	
	@Autowired
	private IHotelRepository hotelRepository;
	
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		return this.hotelRepository.buscarHotelInnerJoin(tipoHabitacion);
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin2() {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelInnerJoin2();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		return this.hotelRepository.buscarHotelOuterJoinLeft(tipoHabitacion);
	}
	
	@Override
	public List<Hotel> buscarHotelOuterJoinLeft2() {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelOuterJoinLeft2();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
		return this.hotelRepository.buscarHotelOuterJoinRight(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelJoinWhere(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		LOG.info("Transaccion activa service: "+TransactionSynchronizationManager.isActualTransactionActive());
		return this.hotelRepository.buscarHotelJoinFetch(tipoHabitacion);
	}

	@Override
	public void insertar(Hotel h) {
		this.hotelRepository.insertar(h);
		
	}

	@Override
	public List<Hotel> buscarHoteles(String tipo) {
		return this.hotelRepository.buscarHoteles(tipo);
	}

	@Override
	public Hotel buscarHotel(String tipo) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotel(tipo);
	}

	@Override
	public int contarHabitaciones(Integer id, String tipo) {
		Hotel h=this.hotelRepository.buscar(id);
		List<Habitacion>lista=h.getHabitaciones();
		int numHabitaciones=0;
		
		for(Habitacion item: lista) {
			if(item.getTipo().equals(tipo)) {
				numHabitaciones=numHabitaciones+1;
			}
		}
		
		return numHabitaciones;
	}

	



}
