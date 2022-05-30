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
	void TestMetodo1()
	{
		assertEquals("Respuesta 1", this.almacen.metodo1());
	}
	
	@Test
	void TestDarCategoriaRaiz()
	{
		assertEquals("Tecnología",this.almacen.darCategoriaRaiz().buscarNodo("11").darNombre());
	}

}