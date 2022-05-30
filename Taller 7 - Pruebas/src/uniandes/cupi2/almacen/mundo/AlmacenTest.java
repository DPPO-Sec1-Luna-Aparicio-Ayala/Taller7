package uniandes.cupi2.almacen.mundo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AlmacenTest {

	private Almacen almacen;
	
	@BeforeEach
	public void setUp() throws AlmacenException
	{
		this.almacen = new Almacen(new File("data/datos.txt"));
	}
	
	
	@Test
	void TestDarCategoriaRaiz()
	{
		assertEquals("Tecnología",this.almacen.darCategoriaRaiz().buscarNodo("11").darNombre());
	}
	
	@Test
	void TestCargar () throws AlmacenException
	{
		assertNotNull(this.almacen, "No deberia de ser null");
	}
	
	@Test
	void TestAgregarNodo() throws AlmacenException
	{
		this.almacen.agregarNodo("1", "Marca", "101", "Prueba");
		assertNotNull(this.almacen.buscarNodo("101"), "No se agrego");	
	}
	
	@Test
	void TestEliminarNodo () throws AlmacenException
	{
		this.almacen.agregarNodo("1", "Marca", "101", "Prueba");
		assertNotNull(this.almacen.buscarNodo("101"), "No se agrego");
		this.almacen.eliminarNodo("101");
		assertNull(this.almacen.buscarNodo("101"), "No se elimino");
	}
	
	@Test
	void TestVenderProducto () throws AlmacenException
	{
		
		int ventasI = this.almacen.darCategoriaRaiz().buscarProducto("31759941").darCantidadUnidadesVendidas();
		this.almacen.venderProducto("31759941", 10);
		int ventasF = this.almacen.darCategoriaRaiz().buscarProducto("31759941").darCantidadUnidadesVendidas();
		boolean prueba = ventasF > ventasI;
		
		assertTrue(prueba);
	}
	
	@Test
	void TestBuscarNodo ()
	{
		assertNotNull(this.almacen.buscarNodo("1"), "No sirvio la busqueda");
	}
	
	@Test 
	void TestAgregarProducto () throws AlmacenException
	{
		this.almacen.agregarProducto("1111", "12345", "test", "sirve", 10);
		assertNotNull(this.almacen.darCategoriaRaiz().buscarProducto("12345"));
		assertEquals("test", this.almacen.darCategoriaRaiz().buscarProducto("12345").darNombre());
	}
	
	@Test
	void TestEliminarProducto() 
	{
		this.almacen.eliminarProducto("31759941");
		assertNull(this.almacen.darCategoriaRaiz().buscarProducto("31759941"));
	}
	
	@Test
	void TestMetodo1()
	{
		assertEquals("Respuesta 1", this.almacen.metodo1());
	}
	
	@Test
	void TestMetodo2()
	{
		assertEquals("Respuesta 2", this.almacen.metodo2());
	}
	

}