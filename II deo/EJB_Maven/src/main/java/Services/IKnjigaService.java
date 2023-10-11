package Services;

import java.util.List;
import Entities.Knjiga;

public interface IKnjigaService {
	
	Knjiga create(int id, String autor, String naslov, int tiraz, int godinaIzdavanja, String izdavac, int brojStrana);
	Knjiga read(int id);
	
	boolean rezervisi(int id,String jmbg);
	boolean otkaziRezervaciju(int id,String jmbg);
	boolean iznajmi(int id,String jmbg);
	boolean vratiKnjigu(int id,String jmbg);
	
	List<Knjiga> readAll();	
	void delete(Knjiga k);
	void delete(int id);
	Knjiga create(Integer id, String autor, String naslov);
	void rezervisi(Integer idKnjige, Integer idClanskeKarte);
	boolean iznajmi(int idck, int idk);

}
