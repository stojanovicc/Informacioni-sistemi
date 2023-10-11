package Services;

import Entities.Dete;

import java.text.ParseException;
import java.util.*;

public interface IDeteService {

	Dete create(int idClanskeKarte, String ime, String prezime, String imeRoditelja, int brojGodina, String vazenjeClanarine, String placanjeClanarine, String datumUclanjenja, String korisnickoIme, String password);
	String readString(String username, String password);
	Dete read(int id);
	Dete read(String username, String password);
	List<Dete> readAll();
	void platiClanarinu(Dete k);
	void produziClanarinu(int idck) throws ParseException;
	void delete(Dete k);
	void delete(int id);
	void delete(String username, String password);
	Dete create(int idClanskeKarte, String ime, String imeRoditelja, String prezime, int brojGodina, String brojTelefonaRoditelja, String clanarina, String korisnickoIme, String password)
			throws ParseException;
}
