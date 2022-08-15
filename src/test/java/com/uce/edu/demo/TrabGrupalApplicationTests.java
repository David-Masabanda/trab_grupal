package com.uce.edu.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.service.IFacturaService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class TrabGrupalApplicationTests {

	//@Autowired
	//private HotelServiceImpl hotelService;
	
	
	//@PersistenceContext	
	//private EntityManager entityManager;
	
	
	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Autowired
	private IFacturaService facturaService;
	
	@MockBean
	private IFacturaRepository facturaRepositoryM;
	
	
	@Test
	void contextLoads() {
		//assertThat(hotelService.buscarHotelInnerJoin("")).toString();
	}
	
	@Test
	void metodo1() {
	/*
		List<Hotel>hoteles=new ArrayList<>();
		Hotel h=new Hotel();
		h.setNombre("Cameron");
		h.setDireccion("Manta");
		
		Hotel h2=new Hotel();
		h2.setNombre("Oro Verde");
		h2.setDireccion("Cuenca");
		
		this.hotelService.insertar(h);
		this.hotelService.insertar(h2);
		
		hoteles.add(h);
		hoteles.add(h2);
		
		when(hotelService.buscarHotelInnerJoin("Familiar")).thenReturn(hoteles);
		*/
	}
	
	@Test
	void testEncontrar() {
		//assertEquals(1, hotelService.buscarHotelInnerJoin2());
	}
	
	/*
	@Test
	void testFactura (){
		Factura f=new Factura(5, LocalDateTime.of(2000,11,4,0,0), "1050");
		entityManager.persist(f);
		assertThat(f.getId()).isNotNull();
	}*/

	
	@Test
	void testBuscarFechaService() {
		Factura f=new Factura();
		f.setId(5);
		f.setNumero("1050");
		f.setFecha(LocalDateTime.of(2022, 7, 28, 0, 0));
		
		List<Factura> lista=new ArrayList<>();
		lista.add(f);
		
		assertEquals(lista, facturaRepository.consultarFecha(LocalDateTime.of(2022, 7, 25, 0, 0)));
		assertEquals(lista, facturaRepository.consultar(5));
	}
	
	
	@Test
	void testBuscarFechaRepository() {
		Factura f=new Factura();
		f.setId(6);
		f.setNumero("1060");
		f.setFecha(LocalDateTime.of(2022, 8, 2, 0, 0));
		
		List<Factura> lista=new ArrayList<>();
		lista.add(f);
		
		//when(facturaRepositoryM.consultarFecha(LocalDateTime.of(2022, 7, 25, 0, 0))).thenReturn(lista);
	//	assertEquals(lista, facturaService.consultarFecha(LocalDateTime.of(2022, 7, 25, 0, 0)));

	}
	
	

}
