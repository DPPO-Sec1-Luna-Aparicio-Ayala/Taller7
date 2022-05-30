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
		assertEquals("Cupi2",this.almacen.darCategoriaRaiz().buscarNodo("1").darNombre());
	}

}