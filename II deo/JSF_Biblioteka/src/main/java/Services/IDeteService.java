package Services;

import Entities.Dete;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public interface IDeteService
{
	
	Dete create(int idClanskeKarte, String ime, String imeRoditelja, String prezime, int brojGodina, String brojTelefonaRoditelja, String clanarina, String korisnickoIme, String password)
			throws ParseException;
	
	String readString(String username, String password);
	
	Dete register(int idClanskeKarte, String ime, String imeRoditelja, String prezime, int brojGodina, String brojTelefonaRoditelja, String clanarina, String korisnickoIme, String password)
			throws ParseException;
	
	Dete read(int id);	
	Dete read(String username, String password);
	
	List<Dete> readAll();	
	
	void platiClanarinu(Dete k);	
	
	void delete(Dete k);
	void delete(int id);
	void delete(String username, String password);
	void produziClanarinu(int idck) throws ParseException;
	boolean validate(String tekst) throws IOException;
}