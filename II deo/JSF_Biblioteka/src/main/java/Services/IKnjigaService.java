package Services;

import java.util.List;
import Entities.Knjiga;

public interface IKnjigaService
{
	Knjiga read(Integer id);
	
	void rezervisi(Integer idk,Integer idck);
	boolean otkaziRezervaciju(Integer id, String jmbg);
	boolean iznajmi(int idck, int ink);
	boolean vratiKnjigu(Integer id, String jmbg);
	
	List<Knjiga> readAll();	
	void delete(Knjiga k);
	void delete(Integer id);
	Knjiga create(Integer id, String autor, String naslov);

	List<Knjiga> readAllFor(Integer id);

}
