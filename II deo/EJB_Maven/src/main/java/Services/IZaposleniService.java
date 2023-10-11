package Services;

import java.util.List;

import Entities.Zaposleni;


public interface IZaposleniService {
	
	Zaposleni create(String jmbg,String ime,String prezime,String pozicija,String radnoVreme, double plata, String brojTelefona, String adresa);
	Zaposleni read(String jmbg);
	Zaposleni read(String username, String password);
	String readString(String username, String password);
	String readString(String jmbg );
	
	List<Zaposleni> readAllFor(int plata);
	String readAllForString(int plata);
	
	List<Zaposleni> readAll();
	String readAllString();
	
	boolean setPlata(String jmbg,double val);
	boolean setUgovorZaStalno(String jmbg);
	
	
	void update(Zaposleni z);
	void update(String jmbg,String ime,String prezime,String pozicija,String radnoVreme, double plata, String brojTelefona, String adresa);
	
	void delete(Zaposleni z);
	void delete(String jmbg);
	Zaposleni create(String jmbg, String ime, String prezime, String pozicija, double plata, String korisnickoIme,
			String sifra);
	boolean produziUgovor(String jmbg, int months);

}
