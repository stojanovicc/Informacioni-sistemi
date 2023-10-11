package Services.implementation; 
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import Entities.Zaposleni;
import Services.IZaposleniService;

@Stateless
public class ZaposleniService implements IZaposleniService
{
	@PersistenceContext(name="JSF_Biblioteka")
	private EntityManager em;
	
	public ZaposleniService()
	{
		
	}
	
	@Override
	public Zaposleni create(String jmbg, String ime, String prezime, String pozicija, double plata, String korisnickoIme,String sifra)
	{
		try
		{
			Zaposleni z = new Zaposleni(jmbg, ime, prezime, pozicija, plata, korisnickoIme, sifra);
			em.persist(z);
			return z;
		}
		catch (Exception e)
		{
			System.out.print(e.getMessage());
		}
		return null;
		
	}
	
	@Override
	public Zaposleni read(String jmbg)
	{
			Zaposleni ret = null;	
		try
		{
			ret  = em.createQuery("SELECT z FROM Zaposleni z WHERE z.jmbg='" + jmbg + "'", Zaposleni.class).getSingleResult();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	
		return ret;
	}
	
	@Override
	public Zaposleni read(String username, String password)
	{
			Zaposleni ret = null;
		
		try
		{
			ret  = em.createQuery("SELECT z FROM Zaposleni z WHERE z.korisnickoIme='" + username + "' AND z.sifra='" + password + "'", Zaposleni.class).getSingleResult();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return ret;
	}
	
	@Override
	public String readString(String username, String password)
	{
		Zaposleni ret = null;
		
		try
		{
			ret  = em.createQuery("SELECT z FROM Zaposleni z WHERE z.korisnickoIme='" + username + "' AND z.sifra='" + password + "'", Zaposleni.class).getSingleResult();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		if(ret != null)
			return ret.toString();
		
		return "";
	}
	
	@Override
	public String readString(String jmbg)
	{
		Zaposleni ret = null;
		
		try
		{
			ret  = em.createQuery("SELECT z FROM Zaposleni z WHERE z.jmbg='" + jmbg + "'", Zaposleni.class).getSingleResult();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		if (ret != null)
			return ret.toString();
		
		return "";
	}
	
	@Override
	public List<Zaposleni> readAllFor(int plata)
	{
		return em.createQuery("SELECT z FROM Zaposleni z WHERE z.plata>" + plata + " '", Zaposleni.class).getResultList();
	}
	
	@Override
	public String readAllForString(int plata)
	{
		return null;
	}
	
	@Override
	public List<Zaposleni> citaj()
	{
		List<Zaposleni> zaps = em.createQuery("SELECT z FROM Zaposleni z", Zaposleni.class).getResultList();
		return zaps;
	}
	
	@Override
	public String readAllString()
	{
		List<Zaposleni> list = em.createQuery("SELECT z FROM Zaposleni z", Zaposleni.class).getResultList();
		
		String ret = "";
		for (Zaposleni z : list)
		{
			ret += z.toString();
			ret += ";;\n";
		}
		return ret;
	}
	
	@Override
	public void update(Zaposleni z)
	{
		try
		{
			Zaposleni zap = em.find(Zaposleni.class, z.getJmbg());
			if (zap != null)
			{
				em.getTransaction().begin();
				zap.setIme(z.getIme());
				zap.setPrezime(z.getPrezime());
				zap.setPlata(z.getPlata());
				zap.setPozicija(z.getPozicija());
				em.getTransaction().commit();
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void update(String jmbg, String ime, String prezime, String pozicija, String radnoVreme, double plata, String brojTelefona, String adresa)
	{
		try 
		{
			Zaposleni zap = em.find(Zaposleni.class, jmbg);
			if (zap != null)
			{
				em.getTransaction().begin();
				zap.setIme(ime);
				zap.setPrezime(prezime);
				zap.setPozicija(pozicija);
				zap.setPlata(plata);
				em.getTransaction().commit();
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void delete(Zaposleni z)
	{
		try
		{
			Zaposleni zap = em.find(Zaposleni.class, z.getJmbg());
			if (zap != null)
			{
				em.getTransaction().begin();
				em.remove(zap);
				em.getTransaction().commit();
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void delete(String jmbg)
	{
		try
		{
			Zaposleni zap = em.find(Zaposleni.class, jmbg);
			if (zap != null)
			{
				em.remove(zap);
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public Zaposleni setPlata(String jmbg,double val)
	{
		Zaposleni zap = em.find(Zaposleni.class, jmbg);
		if (zap != null)
		{
			zap.setPlata(val);
			System.out.println(zap.toString());
		}
		else
		{
			System.out.println(jmbg);
		}
		return zap;
	}

	@Override
	public boolean setUgovorZaStalno(String jmbg)
	{
		Zaposleni zap = null;
		zap = em.find(Zaposleni.class, jmbg);
		if (zap != null)
		{
			em.getTransaction().begin();
			em.getTransaction().commit();
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean produziUgovor(String jmbg, int months)
	{
		Zaposleni zap = null;
		zap = em.find(Zaposleni.class, jmbg);
		if (zap != null)
		{
			em.getTransaction().begin();
			LocalDate localDate = LocalDate.now( ).plusMonths(months);
			Date datesix = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			em.getTransaction().commit();
		}
		
		return false;
	}
}