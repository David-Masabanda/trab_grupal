package com.uce.edu.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.TransactionRequiredException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.demo.repository.modelo.Hotel;

@SpringBootTest
class HotelServiceImplTest {
	
	@Autowired
	private IHotelService hotelService;
	
	@Test
	void testBuscarHabitacion() {
		try {
			
			Hotel h2=hotelService.buscarHotel("Suite");
			assertNotNull(h2);
			
		}catch(TransactionRequiredException e){
			
		}
	}

}
