package Test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Aplicación.*;

public class TestPong {

	@Test
	public void creacionPersonaje1X() {
		// arrange
		Pong pong = new Pong("10");
		// act
		int posicionX = pong.getPersonaje1().getX();
		int posicionY = pong.getPersonaje1().getY();
		// assert
		assertEquals(posicionX, 0);
		assertEquals(posicionY, 0);
	}

	@Test
	public void creacionPersonaje2X() {
		// arrange
		Pong pong = new Pong("10");
		// act
		int posicionX = pong.getPersonaje2().getX();
		int posicionY = pong.getPersonaje2().getY();
		// assert
		assertEquals(posicionX, 240);
		assertEquals(posicionY, 349);
	}

	@Test
	public void colisionPersonaje1() {
		// arrange
		Pong pong = new Pong("10");
		// act
		pong.getBall().setPosicion(30, 55);
		// assert
		assertEquals(pong.getColision().colisionP1(), true);
	}

	@Test
	public void colisionPersonaje2() {
		// arrange
		Pong pong = new Pong("10");
		// act
		pong.getBall().setPosicion(250, 349);
		// assert
		assertEquals(pong.getColision().colisionP2(), true);
	}

	@Test
	public void moverPersonaje1() {
		// arrange
		Pong pong = new Pong("10");
		// act
		int posicion = pong.getPersonaje1().moverDerecha();
		// asert
		assertEquals(posicion, 20);
	}

	@Test
	public void moverPersonaje2() {
		// arrange
		Pong pong = new Pong("10");
		// act
		int posicion = pong.getPersonaje2().moverIzquierda();
		// assert
		assertEquals(posicion, 220);
	}

	@Test
	public void puntoP1() {
		// arrange
		Pong pong = new Pong("10");
		// act
		pong.getBall().setPosicion(0, 390);
		// assert
		assertEquals(pong.getColision().puntajeUno(), true);

	}

	@Test
	public void puntoP2() {
		// arrange
		Pong pong = new Pong("10");
		// act
		pong.getBall().setPosicion(0, 0);
		// assert
		assertEquals(pong.getColision().puntajeDos(), true);

	}

	@Test
	public void fortaleza1() {
		// arrange
		Pong pong = new Pong("10");
		// act
		pong.getPersonaje1().moverDerecha();
		// assert
		assertEquals(pong.getPersonaje1().getFortaleza(), 195);
	}

	@Test
	public void fortaleza2() {
		// arrange
		Pong pong = new Pong("10");
		// act
		pong.getPersonaje2().moverIzquierda();
		// assert
		assertEquals(pong.getPersonaje2().getFortaleza(), 195);
	}

	@Test
	public void colisionPoder() {
		// arrange
		Pong pong = new Pong("10");
		// act
		pong.getBall().setPosicion(100, 80);
		pong.getPoder().setPosicion(100, 80);
		// assert
		assertEquals(pong.getColision().colisionPoder(), true);
	}

	@Test
	public void colisionBloque1() {
		// arrange
		Pong pong = new Pong("10");
		// act
		pong.getPersonaje1().setPosicion(80, 0);
		pong.getBloque().setPosicion(80, 0);
		// assert
		assertEquals(pong.getColision().colisionBloqueP1(), true);
	}

	@Test
	public void colisionBloque2() {
		// arrange
		Pong pong = new Pong("10");
		// act
		pong.getPersonaje2().setPosicion(80, 360);
		pong.getBloque().setPosicion(80, 360);
		// assert
		assertEquals(pong.getColision().colisionBloqueP2(), true);
	}

	@Test
	public void colisionBloqueFortaleza1() {
		// arrange
		Pong pong = new Pong("10");
		// act
		pong.getPersonaje1().setPosicion(80, 0);
		int numeroFortaleza = pong.getPersonaje1().getFortaleza();
		pong.getBloque().setPosicion(80, 0);
		pong.accionBloque();
		// assert
		assertEquals(pong.getPersonaje1().getFortaleza(), numeroFortaleza / 2);
	}

	@Test
	public void colisionBloqueFortaleza2() {
		// arrange
		Pong pong = new Pong("10");
		// act
		pong.getPersonaje2().setPosicion(80, 360);
		int numeroFortaleza = pong.getPersonaje2().getFortaleza();
		pong.getBloque().setPosicion(80, 360);
		pong.accionBloque();
		// assert
		assertEquals(pong.getPersonaje2().getFortaleza(), numeroFortaleza / 2);
	}

	@Test
	public void probarEnergy() {
		// arrange
		Pong pong = new Pong("10");
		// act
		pong.getBall().setPosicion(100, 80);
		pong.getBall().setVisibilidad(true);
		pong.getPoder().setNumero(6);
		pong.getPoder().setPosicion(100, 80);
		int fortaleza = pong.getPersonaje2().getFortaleza();
		pong.colisionBola();
		// assert
		assertTrue(pong.getPersonaje2().getFortaleza()>fortaleza);
	}
	
	@Test
	public void probarCold() {
		// arrange
		Pong pong = new Pong("10");
		// act
		pong.getBall().setPosicion(100, 80);
		pong.getBall().setVisibilidad(true);
		pong.getPoder().setNumero(4);
		pong.getPoder().setPosicion(100, 80);
		Color color = pong.getBall().getColor();
		pong.colisionBola();
		// assert
		assertTrue(pong.getBall().getColor()!=color);
	}
}
