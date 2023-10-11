package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "dete")
public class Dete
{
	@Id
	@Column(name = "idClanskeKarte")
	private Integer idClanskeKarte;
	
	@Column(name = "ime")
	private String ime;
	
	@Column(name = "imeRoditelja")
	private String imeRoditelja;
	
	@Column(name = "prezime")
	private String prezime;	
	
	@Column(name = "brojGodina")
	private Integer brojGodina;
	
	@Column(name = "brojTelefonaRoditelja")
	private String brojTelefonaRoditelja;
	
	@Column(name = "clanarina")
	private Date clanarina;
	
	@Column(name = "korisnickoIme")
	private String korisnickoIme;
	
	@Column(name = "password")
	private String password;
	
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Dete() {
		
	}
	public Dete(int idClanskeKarte, String ime, String imeRoditelja, String prezime, int brojGodina, String brojTelefonaRoditelja, String clanarina, String korisnickoIme, String password)
			throws ParseException
	{
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.imeRoditelja = imeRoditelja;
		this.idClanskeKarte = idClanskeKarte;
		this.brojGodina = brojGodina;
		this.brojTelefonaRoditelja = brojTelefonaRoditelja;
		this.korisnickoIme = korisnickoIme;
		this.password = password;
		Date sdf = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(clanarina);
		this.clanarina = sdf;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public Integer getBrojGodina() {
		return brojGodina;
	}
	public void setBrojGodina(int brojGodina) {
		this.brojGodina = brojGodina;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getImeRoditelja() {
		return imeRoditelja;
	}
	public void setImeRoditelja(String imeRoditelja) {
		this.imeRoditelja = imeRoditelja;
	}
	public Integer getIdClanskeKarte() {
		return idClanskeKarte;
	}
	public void setIdClanskeKarte(int idClanskeKarte) {
		this.idClanskeKarte = idClanskeKarte;
	}
	public String getBrojTelefonaRoditelja() {
		return brojTelefonaRoditelja;
	}
	public void setBrojTelefonaRoditelja(String brojTelefonaRoditelja) {
		this.brojTelefonaRoditelja = brojTelefonaRoditelja;
	}
	public Date getClanarina() {
		return clanarina;
	}
	public String getClanarinaString() {
		return clanarina.toString();
	}
	public void setClanarina(String clanarina) throws ParseException {
		Date sdf =   new java.text.SimpleDateFormat("yyyy-MM-dd").parse(clanarina);
		this.clanarina = sdf;
	}
	public void setIdClanskeKarte(Integer idClanskeKarte) {
		this.idClanskeKarte = idClanskeKarte;
	}
	public void setBrojGodina(Integer brojGodina) {
		this.brojGodina = brojGodina;
	}
	
	
}
