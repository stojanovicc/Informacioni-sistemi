package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.text.ParseException;

@Entity
@Table(name="zaposleni")
public class Zaposleni  {
	@Id
	@Column(name="jmbg")
	private String jmbg;
	
	@Column(name="ime")
	private String ime;
	
	@Column(name="prezime")
	private String prezime;
	
	
	@Column(name="pozicija")
	private String pozicija;
	
	@Column(name="plata")
	private Double plata;

	
	@Column(name="korisnickoIme")
	private String korisnickoIme;
	
	@Column(name="sifra")
	private String sifra;
	
	public Zaposleni()
	{
		
	}
	public Zaposleni(String jmbg,String ime,String prezime,String pozicija, double plata,String korisnickoIme,String sifra) throws ParseException
	{
		this.jmbg = jmbg;
		this.ime = ime;
		this.prezime = prezime;
		this.pozicija = pozicija;;
		this.korisnickoIme = korisnickoIme;
		this.sifra = sifra;
		
		/*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		Date date = formatter.parse(trajanjeUgovora);
		this.trajanjeUgovora = date;
		*/
		this.plata = plata;
		
	}
	public Double getPlata() {
		return plata;
	}
	public void setPlata(Double plata) {
		this.plata = plata;
	}
	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getPozicija() {
		return pozicija;
	}

	public void setPozicija(String pozicija) {
		this.pozicija = pozicija;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
}