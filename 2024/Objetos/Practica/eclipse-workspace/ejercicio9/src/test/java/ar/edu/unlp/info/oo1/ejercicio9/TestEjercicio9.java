package ar.edu.unlp.info.oo1.ejercicio9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEjercicio9 {
		private CuentaCorriente cuentaCorriente;
		private CajaDeAhorro cajaDeAhorro;
		
		@BeforeEach
		void setUp() {
			cuentaCorriente= new CuentaCorriente(100);
			cuentaCorriente.setDescubierto(500);
			cajaDeAhorro=new CajaDeAhorro(400);
		}
		//depositar 200
		@Test
		void testDeposito() {
			cuentaCorriente.depositar(200);
			cajaDeAhorro.depositar(200);
			assertEquals(300.0,cuentaCorriente.getSaldo());
			assertEquals(596.0,cajaDeAhorro.getSaldo());
		}
		
		
		//extraer 100
		@Test
		void testExtraccionSegura() {
			assertTrue(cuentaCorriente.extraer(100));
			assertTrue(cajaDeAhorro.extraer(100));
			assertEquals(0.0,cuentaCorriente.getSaldo());
			assertEquals(298.0,cajaDeAhorro.getSaldo());
		}
		
		
		//extraer 400
		@Test
		void testExtraccionPeligrosa() {
			assertTrue(cuentaCorriente.extraer(400));
			assertFalse(cajaDeAhorro.extraer(400));
			assertEquals(-300.0,cuentaCorriente.getSaldo());
		}
		

}
