package com.uce.edu.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class HotelServiceImplTest2 {

	@Autowired
	private IHotelService hotelService;
	
	@Test
	void testContarHabitaciones() {
		assertTrue(this.hotelService.contarHabitaciones(3, "Familiar")>1);
	}

}
