package com.uce.edu.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrabGrupalApplication implements CommandLineRunner{

	//@Autowired
	//private IFacturaService facturaService;
	
	//@Autowired
	//private IHotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(TrabGrupalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
	//	BigDecimal valor=this.facturaService.calcularPrecio(3);
/*
		List<Hotel>	lista=this.hotelService.buscarHabitacion("Suite");
		
		for(Hotel item: lista) {
			System.out.println(item.getNombre());
		}*/
	}

}
