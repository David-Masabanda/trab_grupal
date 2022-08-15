package com.uce.edu.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import javax.persistence.TransactionRequiredException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FacturaServiceImplTest2 {
	
	@Autowired
	private IFacturaService facturaService;
	
	@Test
	void testCalcularPrecio() {
		try {
			
			BigDecimal valor=this.facturaService.calcularPrecio(1);
			
			Double valorReal=valor.doubleValue();
			Double valorEsperado=9.45;
			
			assertEquals(valorEsperado, valorReal);
			
		}catch(TransactionRequiredException e){
			System.out.println("Error: "+e);
		}
	}

}
