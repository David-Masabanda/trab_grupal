package com.uce.edu.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FacturaServiceImplTest {
	
	@Autowired
	private IFacturaService facturaService;
	
	@Test
	void testCantidad() {
		
		assertTrue(this.facturaService.cantidad(1)>3);
		assertFalse(this.facturaService.cantidad(1)<3);
		
	}

}
