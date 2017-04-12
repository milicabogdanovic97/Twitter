package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * @author Milica Bogdanovic
 * @version 1.0
 */
public class Twitter {

	/**
	 * Atribut poruke predstavlja listu TwitterPoruka.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Metoda vratiSvePoruke() vraca listu TwitterPoruka.
	 * 
	 * @return lista TwitterPoruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Metoda unesi(String korisnik, String poruka) kreira novi objekat klase
	 * TwitterPoruka, puni podacima i ubacuje u listu na kraj.
	 * 
	 * @param korisnik
	 *            Informacija o korisniku koja se unosi u listu
	 * @param poruka
	 *            Informacija o poruci koja se unosi u listu
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}

	/**
	 * Metoda vratiPoruke(int maxBroj, String tag) pronalazi poruke sa zadatim
	 * tagom u listi i vraca niz sa tim porukama.
	 * 
	 * @param maxBroj Maksimalan broj poruka u nizu
	 * @param tag Parametar na osnovu koga se vrsi pretrazivanje liste
	 * @return niz poruka
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}