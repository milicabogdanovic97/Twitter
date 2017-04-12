package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	Twitter t;
	TwitterPoruka tp;

	@Before
	public void setUp() throws Exception {
		t = new Twitter();
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
		tp = null;
	}

	@Test
	public void testVratiSvePoruke() {
		t.unesi("Milica", "Tekst poruke.");
		assertEquals(1, t.vratiSvePoruke().size());
		assertEquals("Milica", t.vratiSvePoruke().get(0).getKorisnik());
		assertEquals("Tekst poruke.", t.vratiSvePoruke().get(0).getPoruka());
	}

	@Test
	public void testVratiSvePorukePoslednjaPoruka() {
		LinkedList<TwitterPoruka> p = t.vratiSvePoruke();
		t.unesi("Milica", "Tekst poruke.");
		t.unesi("Jovana", "Ovo je poruka.");
		assertEquals("Jovana", p.getLast().getKorisnik());
	}

	@Test
	public void testVratiSvePorukeNula() {
		LinkedList<TwitterPoruka> p = t.vratiSvePoruke();
		assertEquals(0, p.size());
	}

	@Test
	public void testVratiSvePorukeSve() {
		LinkedList<TwitterPoruka> p = t.vratiSvePoruke();
		t.unesi("Milica", "Tekst poruke.");
		t.unesi("Jovana", "Ovo je poruka.");
		t.unesi("Milos", "Zdravo!");
		t.unesi("Nikola", "Dobar dan.");

		assertEquals("Milica", p.get(0).getKorisnik());
		assertEquals("Jovana", p.get(1).getKorisnik());
		assertEquals("Milos", p.get(2).getKorisnik());
		assertEquals("Nikola", p.get(3).getKorisnik());

		assertEquals("Tekst poruke.", p.get(0).getPoruka());
		assertEquals("Ovo je poruka.", p.get(1).getPoruka());
		assertEquals("Zdravo!", p.get(2).getPoruka());
		assertEquals("Dobar dan.", p.get(3).getPoruka());
	}

	@Test
	public void testUnesi() {
		tp.setKorisnik("Milica");
		tp.setPoruka("Tekst poruke.");
		t.unesi(tp.getKorisnik(), tp.getPoruka());

		assertEquals(1, t.vratiSvePoruke().size());
		assertEquals("Milica", t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("Tekst poruke.", t.vratiSvePoruke().getLast().getPoruka());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiNull() {
		t.unesi(null, "poruka");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiNull2() {
		t.unesi("poruka", null);
	}

	@Test
	public void testUnesiJedna() {
		LinkedList<TwitterPoruka> p = t.vratiSvePoruke();
		t.unesi("Milica", "poruka");
		assertEquals("Milica", p.getLast().getKorisnik());
		assertEquals("poruka", p.getLast().getPoruka());
	}

	@Test
	public void testUnesiVise() {
		LinkedList<TwitterPoruka> p = t.vratiSvePoruke();
		t.unesi("Milica", "Tekst poruke.");
		t.unesi("Ana", "Ovo je poruka.");

		assertEquals("Ana", p.getLast().getKorisnik());
		assertEquals("Ovo je poruka.", p.getLast().getPoruka());
	}
	
	@Test
	public void testVratiPoruke() {
		t.unesi("Milica", "Ovo je poruka.");
		t.unesi("Jovana", "Zdravo!");
		t.unesi("Nikola", "Ovo je jos jedna poruka.");

		TwitterPoruka [] niz = t.vratiPoruke(50, "por");
		
		int brojac = 0;
		for (int i=0;i<niz.length;i++){
			if(niz[i] != null)
				brojac++;
		}
		assertEquals(2, brojac);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(100, null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		t.vratiPoruke(100, "");
	}

	@Test
	public void testVratiPorukeMaxBroj() {
		TwitterPoruka[] niz = t.vratiPoruke(-1, "poruka");
		assertEquals(100, niz.length);
	}
}
