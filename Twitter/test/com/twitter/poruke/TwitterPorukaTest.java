package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {
	TwitterPoruka tp;
	
	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	@Test
	public void testSetKorisnik() {
		tp.setKorisnik("Milica");
		assertEquals("Milica", tp.getKorisnik());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		tp.setKorisnik("");
	}
	
	@Test
	public void testSetPoruka() {
		tp.setPoruka("Tekst poruke.");
		assertEquals("Tekst poruke.", tp.getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tp.setPoruka(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrazanString() {
		tp.setPoruka("");
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaDuzinaPorukeVecaOd140() {
		tp.setPoruka("Tekst poruke. Tekst poruke. Tekst poruke. Tekst poruke. "
				+ "Tekst poruke. Tekst poruke. Tekst poruke. Tekst poruke. "
				+ "Tekst poruke. Tekst poruke. Tekst poruke.");
	}

	@Test
	public void testToString1() {
		tp.setKorisnik("Milica");
		tp.setPoruka("Tekst poruke.");
		
		assertEquals("KORISNIK:Milica PORUKA:Tekst poruke.", tp.toString());
	}

	@Test
	public void testToString2() {
		assertEquals("KORISNIK:"+ tp.getKorisnik() + " PORUKA:" + tp.getPoruka(), tp.toString());
	}
	
	@Test
	public void testToString3() {
		tp.setKorisnik("Milica");
		tp.setPoruka("Tekst poruke.");
		
		assertTrue(tp.toString().contains("KORISNIK:Milica"));
		assertTrue(tp.toString().contains("PORUKA:Tekst poruke."));
	}
	
	@Test
	public void testToString4() {
		tp.setKorisnik("Milica");
		tp.setPoruka("Tekst poruke.");
		
		assertFalse(tp.toString().contains("KORISNIK:Tekst poruke."));
		assertFalse(tp.toString().contains("PORUKA:Milica"));
	}
}
