package com.twitter.poruke;

/**
 * Klasa TwitterPoruka predstavlja poruku na twitteru.
 * @author Milica Bogdanovic
 * @version 1.0
 */
public class TwitterPoruka {
	/**
	 * Atribut korisnik predstavlja ime korisnika.
	 */
	private String korisnik;
	
	/**
	 * Atribut poruka predstavlja tekst poruke.
	 */
	private String poruka;

	/**
	 * Metoda getKorisnik() vraca vrednost atributa korisnik.
	 * @return String korisnik
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Metoda setKorisnik(String korisnik) postavlja vrednost atributa korisnik
	 * na unetu vrednost uz logicku proveru parametra.
	 * 
	 * @param korisnik
	 *            String koji se dodeljuje atributu korisnik
	 * @throws java.lang.RuntimeException
	 *             U situaciji kada parametar metode ne zadovoljava logicke
	 *             uslove, metoda baca RuntimeException
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || !korisnik.isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Metoda getPoruka() vraca String "poruka".
	 * @return String "poruka"
	 */
	public String getPoruka() {
		return "poruka";
	}

	/**
	 * Metoda setPoruka(String poruka) postavlja vrednost atributa poruka
	 * na unetu vrednost uz logicku proveru parametra.
	 * 
	 * @param poruka
	 *            String koji se dodeljuje atributu poruka
	 * @throws java.lang.RuntimeException
	 *             U situaciji kada parametar metode ne zadovoljava logicke
	 *             uslove, metoda baca RuntimeException
	 */
	public void setPoruka(String poruka) {
		if (this.poruka == null || this.poruka == new String("") || this.poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/**
	 * Metoda toString vraca informaciju o twitter poruci.
	 * @return String sa podacima o korisniku i poruci
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}
