package com.uce.edu.demo.service;

import static org.junit.Assert.assertSame;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Factura;

@SpringBootTest
class FacturaServiceImplTest3 {
	
	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Autowired
	private IFacturaService facturaService;
	
	@Test
	void testConsultar() {

			Factura f=new Factura();
			f.setId(2);
			f.setNumero("1020");
			f.setFecha(LocalDateTime.of(2022, 7, 21, 0, 0));
			f.setTotal(new BigDecimal(7.6));
			
			Factura f2=this.facturaService.consultar(2);
			Factura f3=this.facturaRepository.consultar(2);
			
			//assertEquals(f.getNumero(),f2.getNumero());
			assertSame(this.facturaService.consultar(2), this.facturaRepository.consultar(2));
			
	}

}
