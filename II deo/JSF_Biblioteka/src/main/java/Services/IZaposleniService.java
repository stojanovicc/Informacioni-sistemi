package Services;

import java.util.List;

import Entities.Zaposleni;


public interface IZaposleniService
{
	
	Zaposleni create(String jmbg, String ime, String prezime, String pozicija, double plata, String korisnickoIme, String sifra);
	Zaposleni read(String jmbg);
	Zaposleni read(String username, String password);
	String readString(String username, String password);
	String readString(String jmbg );
	
	List<Zaposleni> readAllFor(int plata);
	String readAllForString(int plata);
	
	List<Zaposleni> citaj();
	String readAllString();
	
	Zaposleni setPlata(String jmbg,double val);
	boolean setUgovorZaStalno(String jmbg);
	boolean produziUgovor(String jmbg,int months);
	
	void update(Zaposleni z);
	void update(String jmbg, String ime, String prezime, String pozicija, String radnoVreme, double plata, String brojTelefona, String adresa);
	
	void delete(Zaposleni z);
	void delete(String jmbg);
}