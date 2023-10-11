package ServicesImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Knjiga;
import Services.IKnjigaService;

public class KnjigaService implements IKnjigaService {
	
	private EntityManager em;
	
	public KnjigaService() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("InfoSysPU");
		em = emf.createEntityManager();
	}

	@Override
	public Knjiga create(Integer id, String autor, String naslov) {
		Knjiga k = null;
		try {
			em.getTransaction().begin();
			k = new Knjiga(id,autor,naslov);
			em.persist(k);
			em.getTransaction().commit();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return k;
	}

	@Override
	public Knjiga read(int id) {
		Knjiga ret = null;
		
		try {
			ret = em.find(Knjiga.class, id);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return ret;
	}


	@Override
	public void rezervisi(Integer idKnjige, Integer idClanskeKarte)
	{
		try {
		Knjiga ret = null;
		ret = em.find(Knjiga.class, idKnjige);
		if(ret!=null)
		if(ret.getisDostupna() && !ret.getisRezervisana())
		{
			em.getTransaction().begin();
			ret.setRezervisana(true);
			ret.setRezervisao(idClanskeKarte);
			//Date date = new Date(System.currentTimeMillis());
			em.persist(ret);
		}
	}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Override
	public boolean otkaziRezervaciju(int id, String jmbg) {
		return false;
		/*Knjiga ret = null;
		ret = em.find(Knjiga.class, id);
		if(ret!=null)
			if(ret.isRezervisana() && ret.getRezervisao()==jmbg)
			{
				em.getTransaction().begin();
				ret.setRezervisana(false);
				ret.setRezervisao(null);
				em.getTransaction().commit();
				return true;
			}
			return false; */
	}
	@Override
	public boolean iznajmi(int idck,int idk) {
		Knjiga ret = em.find(Knjiga.class, idk);
		if(ret!=null)
		{
			System.out.println(idck + "DOSTUPNA");
			System.out.println(idk);
			if(ret.getisDostupna())
			{
				ret.setIznajmio(idck);
				ret.setDostupna(false);
				return true;
			}
			return false;
		}
		else
		{
			System.out.println("nije dostupan id clanske karte = " + idck);
			System.out.println("nije dostupan id knjige = " +idk);
			return false;
		}
	}

	@Override
	public boolean vratiKnjigu(int id, String jmbg) {
		return false;
		/*Knjiga ret = null;
		ret = em.find(Knjiga.class, id);
		if(ret!=null)
			if(!ret.isDostupnost() && ret.getRezervisao().compareTo(jmbg)==0)
			{
				em.getTransaction().begin();
				ret.setIznajmio(null);
				ret.setDostupnost(true);
				
				ret.setIznajmljenaOd(null);
				ret.setZauzetaDo(null);
				em.getTransaction().commit();
				return true;
			}
			return false;
		
		*/
	}

	@Override
	public List<Knjiga> readAll() {
		return em.createQuery("SELECT k FROM Knjiga k", Knjiga.class).getResultList();
	}

	@Override
	public void delete(Knjiga k) {
		try {
			Knjiga kl = em.find(Knjiga.class, k.getIdKnjiga());
			if(kl != null)
			{
				em.getTransaction().begin();
				em.remove(kl);
				em.getTransaction().commit();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void delete(int id) {
		try {
			Knjiga k = em.find(Knjiga.class, id);
			if(k != null)
			{
				em.getTransaction().begin();
				em.remove(k);
				em.getTransaction().commit();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Knjiga create(int id, String autor, String naslov, int tiraz, int godinaIzdavanja, String izdavac,
			int brojStrana) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean rezervisi(int id, String jmbg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean iznajmi(int id, String jmbg) {
		// TODO Auto-generated method stub
		return false;
	}

}
