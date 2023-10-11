package Services.implementation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Knjiga;
import Services.IKnjigaService;
@Stateless
public class KnjigaService implements IKnjigaService
{
	@PersistenceContext(name="JSF_Biblioteka")
	private EntityManager em;
	
	public KnjigaService()
	{
		
	}

	@Override
	public Knjiga create(Integer id, String autor, String naslov)
	{
		Knjiga k = null;
		k = new Knjiga(id, autor, naslov);
		em.persist(k);
		return k;
	}

	@Override
	public Knjiga read(Integer id)
	{
		Knjiga ret = null;
		
		try
		{
			ret = em.find(Knjiga.class, id);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return ret;
	}

	@Override
	public void rezervisi(Integer idKnjige, Integer idClanskeKarte)
	{
		try
		{
			Knjiga ret = null;
			ret = em.find(Knjiga.class, idKnjige);
			if (ret != null)
				if (ret.getisDostupna() && !ret.getisRezervisana())
				{
					ret.setRezervisana(true);
					ret.setRezervisao(idClanskeKarte);
				}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
		
	@Override
	public boolean iznajmi(int idck, int idk)
	{
		Knjiga ret = em.find(Knjiga.class, idk);
		if (ret != null)
		{
			System.out.println(idck + "DOSTUPNA");
			System.out.println(idk);
			if (ret.getisDostupna())
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
			System.out.println("nije dostupan id knjige = " + idk);
			return false;
		}
	}

	@Override
	public List<Knjiga> readAllFor(Integer id)
	{
		List<Knjiga> knjige = em.createQuery("SELECT k from Knjiga k where k.iznajmio=" + id + " or k.rezervisao=" + id, Knjiga.class).getResultList();
		return knjige;
	}

	@Override
	public void delete(Knjiga k)
	{
		try
		{
			Knjiga kl = em.find(Knjiga.class, k.getIdKnjiga());
			if (kl != null)
			{
				em.getTransaction().begin();
				em.remove(kl);
				em.getTransaction().commit();
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void delete(Integer id)
	{
		try
		{
			Knjiga k = em.find(Knjiga.class, id);
			if (k != null)
			{
				em.getTransaction().begin();
				em.remove(k);
				em.getTransaction().commit();
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public boolean vratiKnjigu(Integer id, String jmbg)
	{
		return false;
	}

	@Override
	public List<Knjiga> readAll()
	{
		List<Knjiga> knjigice = em.createQuery("SELECT k FROM Knjiga k", Knjiga.class).getResultList();
		return knjigice;
	}

	@Override
	public boolean otkaziRezervaciju(Integer id, String jmbg)
	{
		return false;
	}
}