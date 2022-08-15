package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;

public interface IHotelRepository {
	
	//Inner Join
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);
	public List<Hotel> buscarHotelInnerJoin2();
	//Inner Outer Join Left
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion);
	public List<Hotel> buscarHotelOuterJoinLeft2();
	//Inner Outer Join Right
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion);
	
	
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion);
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion);
	
	
	//Cree todos estos
	public void insertar(Hotel h);
	
	public List<Hotel> buscarHoteles(String tipo);
	public Hotel buscarHotel(String tipo);
	public Hotel buscar(Integer id);
	
	
	
}
