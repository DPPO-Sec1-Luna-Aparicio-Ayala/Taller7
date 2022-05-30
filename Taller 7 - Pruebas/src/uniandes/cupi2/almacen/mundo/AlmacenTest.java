package uniandes.cupi2.almacen.mundo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//IMPORTANTE: SE REALIZAN ACA LAS PRUEBAS DE TANTO ALMACEN COMO CATEGORIA
//POR LO QUE COMPARTEN VARIOS METODOS, NO SE CAMBIO EL NOMBRE


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
	
	//INICIO DE LAS PRUEBAS DE CATEGORIA
	
	@Test
	void TestCategoria () 
	{
		Categoria cat = new Categoria ("0101", "Prueba");
		assertNotNull(cat);
	}
	
	@Test
	void TesTCategoria2 ()
	{
		Categoria cat = this.almacen.darCategoriaRaiz();
		assertNotNull(cat);
	}
	
	@Test
	void TestDarNodos ()
	{
		Categoria cat = new Categoria ("0101", "Prueba");
		List<NodoAlmacen> nodos = cat.darNodos();	
		int tam = nodos.size();
		boolean p1 = tam==0;
		assertTrue(p1);
		List<NodoAlmacen> nodos1 = this.almacen.darCategoriaRaiz().darNodos();
		int tam1 = nodos1.size();
		boolean p2 = tam1 > 0;
		assertTrue(p2);
	}
	
	@Test
	void TestTieneHijo () 
	{
		boolean p = this.almacen.darCategoriaRaiz().tieneHijo("11");
		assertTrue(p);
	}
	
	@Test
	void TestBuscarPadre ()
	{
		NodoAlmacen nodo = this.almacen.darCategoriaRaiz().buscarPadre("11");
		assertSame(nodo, this.almacen.darCategoriaRaiz());
	}
	
	@Test
	void TestBuscarCNodo ()
	{
		assertNotNull(this.almacen.darCategoriaRaiz().buscarNodo("11"), "No sirvio la busqueda");
	}
	
	@Test 
	void TestAgregarCNodo () throws AlmacenException
	{
		this.almacen.darCategoriaRaiz().agregarNodo("1", "Marca", "101", "Prueba");
		assertNotNull(this.almacen.darCategoriaRaiz().buscarNodo("101"), "No se agrego");	
	}
	
	@Test
	void TestEliminarCNodo () throws AlmacenException
	{
		this.almacen.darCategoriaRaiz().agregarNodo("1", "Marca", "101", "Prueba");
		assertNotNull(this.almacen.darCategoriaRaiz().buscarNodo("101"), "No se agrego");
		this.almacen.darCategoriaRaiz().eliminarNodo("101");
		assertNull(this.almacen.darCategoriaRaiz().buscarNodo("101"), "No se elimino");
	}
	
	@Test
	void TestBuscarProducto()
	{
		assertNotNull(this.almacen.darCategoriaRaiz().buscarProducto("30747531"));
	}
	
	@Test
	void TestDarMarcas () 
	{
		List<Marca> lista = this.almacen.darCategoriaRaiz().darMarcas();
		int tam = lista.size();
		boolean pq = tam > 0;
		assertTrue(pq);		
	}
	
	@Test
	void TestDarPreorden ()
	{
		List<NodoAlmacen> lista = this.almacen.darCategoriaRaiz().darPreorden();
		int tam = lista.size();
		boolean pq = tam > 0;
		assertTrue(pq);		
	}
	
	@Test
	void TestDarPosorden ()
	{
		List<NodoAlmacen> lista = this.almacen.darCategoriaRaiz().darPosorden();
		int tam = lista.size();
		boolean pq = tam > 0;
		assertTrue(pq);		
	}
	
	@Test
	void TestDarValorVentas() 
	{
		this.almacen.venderProducto("31759941", 10);
		int ventas = this.almacen.darCategoriaRaiz().buscarProducto("31759941").darCantidadUnidadesVendidas();
		boolean prueba = ventas == 10;
		assertTrue(prueba);
	}
	
	

}