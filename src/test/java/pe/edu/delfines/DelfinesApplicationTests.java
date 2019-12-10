package pe.edu.delfines;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.models.entity.Tipo;
import pe.edu.delfines.models.entity.Vendedor;
import pe.edu.delfines.models.repository.AlquilerRepository;
import pe.edu.delfines.models.repository.ClienteRepository;
import pe.edu.delfines.models.repository.HabitacionRepository;
import pe.edu.delfines.models.repository.TipoRepository;
import pe.edu.delfines.models.repository.VendedorRepository;
import pe.edu.delfines.services.VendedorService;

@RunWith(SpringRunner.class)
@SpringBootTest
class DelfinesApplicationTests {

	@Autowired
	private AlquilerRepository alquilerRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private HabitacionRepository habitacionRepository;
	@Autowired
	private TipoRepository tipoRepository;
	@Autowired
	private VendedorRepository vendedorRepository;

	@Test
	void contextLoads() {

		try {

			// tipo
			Tipo tipo1 = new Tipo();
			tipo1.setId("01");
			tipo1.setNombre("matrimonial");

			Tipo tipo2 = new Tipo();
			tipo2.setId("02");
			tipo2.setNombre("persona sola");

			tipo1 = tipoRepository.save(tipo1);
			tipo2 = tipoRepository.save(tipo2);

		

			//habitaciones

			Habitacion habitacion = new Habitacion();
			habitacion.setNumeroCamas(3);
			habitacion.setDescripcion("tres cama 2 almohadas");
			habitacion.setPrecio((float)150);
			habitacion.setObservacion("todo bien");
			
			Habitacion habitacion1 = new Habitacion();
			habitacion1.setNumeroCamas(2);
			habitacion1.setDescripcion("dos cama 2 almohadas");
			habitacion1.setPrecio((float)100);
			habitacion1.setObservacion("todo bien x2");
			
			habitacion = habitacionRepository.save(habitacion);
			habitacion1 = habitacionRepository.save(habitacion1);
			
			
			
			//vendedores
			
			Vendedor vendedor1 = new Vendedor();
			vendedor1.setId("v001");
			vendedor1.setNombre("bryan");
			vendedor1.setDireccion("av. 1");
			vendedor1.setTelefono("77154");
			vendedor1.setObservacion("todo bien ...");
			vendedor1.setSueldo((float)850);
			
			Vendedor vendedor2 = new Vendedor();
			vendedor2.setId("v002");
			vendedor2.setNombre("hernesto");
			vendedor2.setDireccion("av. 2");
			vendedor2.setTelefono("13212");
			vendedor2.setObservacion("todo bien x2 ...");
			vendedor2.setSueldo((float)650);
			
			vendedor1 = vendedorRepository.save(vendedor1);
			vendedor2 = vendedorRepository.save(vendedor2);
			
			
			//clientes
			
			Cliente c1 = new Cliente();
			c1.setDocumento("73975654");
			c1.setNombre("claudia");
			c1.setFechaNacimiento(new Date(2019, 4, 5));
			c1.setLugarNacimiento("lima");
			c1.setSexo('F');
			c1.setObservacion("aea");
			
			Cliente c2 = new Cliente();
			c2.setDocumento("03826654");
			c2.setNombre("Juancho");
			c2.setFechaNacimiento(new Date(2019, 10, 1));
			c2.setLugarNacimiento("San juan");
			c2.setSexo('M');
			c2.setObservacion("misia");
			
			c1 = clienteRepository.save(c1);
			c2 = clienteRepository.save(c2);
			
			
			
			//Alquileres
			Alquiler n01 = new Alquiler();
			n01.setPrecio("50");
			n01.setFecha_entrada(new Date(119, 9, 15));
			n01.setFecha_salida(new Date(119, 9, 16));
			n01.setEstado("muy bueno");
			n01.setObservacion("duradero");
			
			
			Alquiler n02 = new Alquiler();
			n02.setPrecio("40");
			n02.setFecha_entrada(new Date(119, 5, 10));
			n02.setFecha_salida(new Date(119, 5, 11));
			n02.setEstado("regular");
			n02.setObservacion("con ducha");
			
			n01 = alquilerRepository.save(n01);
			n02 = alquilerRepository.save(n02);

			
			//Relacion vendedor-alquiler
			vendedor1.addAlquileres(n02);
			
			//Relacion alquiler-vendedor

			n02.setVendedor(vendedor1);
			
			//Relacion alquiler-habitacion
			n01.setHabitaciones(habitacion1);
			
			
			//Relacion habitacion-alquiler
			habitacion1.addAlquiler(n01);
			
			//Relacion alquiler-cliente
			n01.setClientes(c2);
			
			//Relacion cliente-alquiler
			c2.addAlquiler(n01);
	
			//relacion habitaciones-tipo
			habitacion1.setTipo(tipo1);
			habitacion.setTipo(tipo2);

			//relacion tipo-habitaciones
			tipo1.addHabitacion(habitacion1);
			tipo2.addHabitacion(habitacion);

			
			habitacionRepository.save(habitacion);
			habitacionRepository.save(habitacion1);
			
			tipoRepository.save(tipo1);
			tipoRepository.save(tipo2);
	
			vendedorRepository.save(vendedor1);
			vendedorRepository.save(vendedor2);
			
			clienteRepository.save(c1);
			clienteRepository.save(c2);
			
			alquilerRepository.save(n01);
			alquilerRepository.save(n02);
		
			

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
